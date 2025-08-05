public class SudokuUtils {

    public static boolean isValidSolution(SudokuCell[][] cells) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(cells, i) || !isValidColumn(cells, i) || !isValidBox(cells, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(SudokuCell[][] cells, int row) {
        boolean[] seen = new boolean[10];
        for (int col = 0; col < 9; col++) {
            int val = cells[row][col].getValue();
            if (val < 1 || val > 9 || seen[val]) return false;
            seen[val] = true;
        }
        return true;
    }

    private static boolean isValidColumn(SudokuCell[][] cells, int col) {
        boolean[] seen = new boolean[10];
        for (int row = 0; row < 9; row++) {
            int val = cells[row][col].getValue();
            if (val < 1 || val > 9 || seen[val]) return false;
            seen[val] = true;
        }
        return true;
    }

    private static boolean isValidBox(SudokuCell[][] cells, int boxIndex) {
        boolean[] seen = new boolean[10];
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                int val = cells[r][c].getValue();
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }
        return true;
    }
}
