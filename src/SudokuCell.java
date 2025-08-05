import javax.swing.*;
import java.awt.*;

public class SudokuCell extends JTextField {
    // Removed unused field 'col'
    private boolean fixed;

    public SudokuCell(int row, int col) {
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("SansSerif", Font.BOLD, 20));
    }

    public void setValue(int value, boolean fixed) {
        this.fixed = fixed;
        setText(String.valueOf(value));
        setEditable(!fixed);
        setBackground(fixed ? Color.LIGHT_GRAY : Color.WHITE);
    }

    public void reset() {
        if (!fixed) {
            setText("");
        }
    }

    public int getValue() {
        try {
            return Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
