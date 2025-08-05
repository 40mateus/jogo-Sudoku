import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

public class SudokuGame extends JFrame {
    private JTextField[][] fields = new JTextField[9][9];
    public SudokuGame(int[][] initialBoard) {
        setTitle("Sudoku Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new JTextField();
                if (initialBoard[i][j] != 0) {
                    fields[i][j].setText(String.valueOf(initialBoard[i][j]));
                    fields[i][j].setEditable(false);
                    fields[i][j].setBackground(Color.LIGHT_GRAY);
                }
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
                boardPanel.add(fields[i][j]);
            }
        }

        JPanel buttonPanel = new JPanel();
        JButton verificarButton = new JButton("Verificar");
        JButton reiniciarButton = new JButton("Reiniciar");
        JButton cancelarButton = new JButton("Cancelar");

        cancelarButton.addActionListener(e -> System.exit(0));

        reiniciarButton.addActionListener(e -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (fields[i][j].isEditable()) {
                        fields[i][j].setText("");
                        fields[i][j].setEditable(true);
                        fields[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        });
        buttonPanel.add(verificarButton);
        buttonPanel.add(reiniciarButton);
        buttonPanel.add(cancelarButton);

        add(boardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(600, 600);
        setVisible(true);
    }
}
