import javax.swing.*;
import java.awt.*;

public class SudokuBoard extends JPanel {
    private SudokuCell[][] cells = new SudokuCell[9][9];

    public SudokuBoard(String[] args) {
        setLayout(new GridLayout(9, 9));

        // Inicializar células
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new SudokuCell(row, col);
                add(cells[row][col]);
            }
        }

        // Preencher os dados recebidos
        for (String arg : args) {
            String[] parts = arg.split(";");
            if (parts.length == 2) {
                String[] coords = parts[0].split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                String[] valueAndFixed = parts[1].split(",");
                int value = Integer.parseInt(valueAndFixed[0]);
                boolean fixed = Boolean.parseBoolean(valueAndFixed[1]);
                cells[y][x].setValue(value, fixed);
            }
        }
    }

    public void resetBoard() {
        for (SudokuCell[] row : cells) {
            for (SudokuCell cell : row) {
                cell.reset();
            }
        }
    }

    public void checkSolution() {
        if (SudokuUtils.isValidSolution(cells)) {
            JOptionPane.showMessageDialog(this, "Parabéns! Sudoku resolvido corretamente!");
        } else {
            JOptionPane.showMessageDialog(this, "A solução está incorreta.");
        }
    }
}
