public class SudokuBoard {
    private static final int GRID_SIZE = 9;
    private int[][] board;

    public SudokuBoard() {
        board = new int[GRID_SIZE][GRID_SIZE];
    }

    // Define um valor na célula (row, col)
    public void setCell(int row, int col, int value) throws IllegalArgumentException {
        if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
            throw new IllegalArgumentException("Linha ou coluna inválida");
        }
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Valor deve estar entre 0 e 9");
        }
        board[row][col] = value;
    }

    // Obtém o valor da célula (row, col)
    public int getCell(int row, int col) {
        return board[row][col];
    }

    // Verifica se o número pode ser colocado na posição (row, col)
    public boolean isValidMove(int row, int col, int num) {
        if (num == 0) return true; // Permite apagar células
        // Verifica linha
        for (int x = 0; x < GRID_SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }
        // Verifica coluna
        for (int x = 0; x < GRID_SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }
        // Verifica quadrado 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se o tabuleiro está completo e válido
    public boolean isBoardComplete() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    return false; // Ainda há células vazias
                }
            }
        }
        return true; // Todas as células estão preenchidas
    }

    // Exibe o tabuleiro no terminal
    public void printBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("- - - - - - - - - - - -");
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                if (board[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    // Retorna a matriz do tabuleiro
    public int[][] getBoard() {
        return board;
    }
}