public class Main {
    public static void main(String[] args) {
        int[][] initialBoard = new int[9][9];

        if (args.length == 81) {
            for (int i = 0; i < 81; i++) {
                try {
                    int value = Integer.parseInt(args[i]);
                    if (value >= 0 && value <= 9) {
                        initialBoard[i / 9][i % 9] = value;
                    } else {
                        initialBoard[i / 9][i % 9] = 0;
                    }
                } catch (NumberFormatException e) {
                    initialBoard[i / 9][i % 9] = 0;
                }
            }
        } else {
            System.out.println("Aviso: argumentos inválidos. Usando tabuleiro vazio.");
        }

        new SudokuGame(initialBoard);
    }
}
