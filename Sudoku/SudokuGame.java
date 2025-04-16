import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bem-vindo ao Jogo de Sudoku!");
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir tabuleiro inicial");
            System.out.println("2. Jogar");
            System.out.println("3. Resolver automaticamente");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número de 1 a 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    inputBoard();
                    break;
                case 2:
                    playGame();
                    break;
                case 3:
                    solveBoard();
                    break;
                case 4:
                    System.out.println("Obrigado por jogar!");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 4.");
            }
        }
    }

    private void inputBoard() {
        System.out.println("Digite o tabuleiro inicial (9 linhas, 9 números por linha, use 0 para células vazias):");
        for (int row = 0; row < 9; row++) {
            System.out.print("Linha " + (row + 1) + ": ");
            String[] input = scanner.nextLine().trim().split("\\s+");
            if (input.length != 9) {
                System.out.println("Erro: Cada linha deve ter exatamente 9 números.");
                row--;
                continue;
            }
            try {
                for (int col = 0; col < 9; col++) {
                    int value = Integer.parseInt(input[col]);
                    if (value < 0 || value > 9) {
                        throw new NumberFormatException();
                    }
                    if (value != 0 && !board.isValidMove(row, col, value)) {
                        System.out.println("Erro: Número " + value + " na posição (" + (row + 1) + "," + (col + 1) + ") é inválido.");
                        row--;
                        continue;
                    }
                    board.setCell(row, col, value);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números de 0 a 9.");
                row--;
            }
        }
        System.out.println("\nTabuleiro inicial:");
        board.printBoard();
    }

    private void playGame() {
        System.out.println("\nDigite 'row col value' para preencher uma célula (ex: 1 2 5).");
        System.out.println("Digite 'solve' para resolver automaticamente ou 'exit' para voltar ao menu.");
        while (!board.isBoardComplete()) {
            System.out.println("\nTabuleiro atual:");
            board.printBoard();
            System.out.print("Seu movimento: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("solve")) {
                solveBoard();
                return;
            }
            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 3) {
                System.out.println("Erro: Digite três valores: linha coluna número (ex: 1 2 5).");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;
                int value = Integer.parseInt(parts[2]);

                if (row < 0 || row >= 9 || col < 0 || col >= 9) {
                    System.out.println("Erro: Linha e coluna devem estar entre 1 e 9.");
                    continue;
                }
                if (value < 0 || value > 9) {
                    System.out.println("Erro: Valor deve estar entre 0 e 9.");
                    continue;
                }

                if (!board.isValidMove(row, col, value)) {
                    System.out.println("Erro: Movimento inválido! O número " + value + " não pode ser colocado em (" + (row + 1) + "," + (col + 1) + ").");
                    continue;
                }

                board.setCell(row, col, value);
                System.out.println("Movimento realizado!");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números inteiros.");
            }
        }

        System.out.println("\nParabéns! Você completou o Sudoku:");
        board.printBoard();
    }

    private void solveBoard() {
        System.out.println("\nTentando resolver o tabuleiro...");
        if (SudokuSolver.solveSudoku(board.getBoard())) {
            System.out.println("Tabuleiro resolvido:");
            board.printBoard();
        } else {
            System.out.println("Sem solução para este tabuleiro.");
        }
    }

    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.start();
    }
}