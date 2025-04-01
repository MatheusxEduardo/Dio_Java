import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, digite o número da Agência: ");
        int numeroAgencia = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble(); // Lê valor decimal

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %d e seu saldo %.2f já está disponível para saque. \n", nome, numeroAgencia, saldo);
        scanner.close();
    }
}
