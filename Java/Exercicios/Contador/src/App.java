import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = terminal.nextInt();
        
        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = terminal.nextInt();
        
        try {
            // Chamando o método de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            // Captura a exceção e imprime a mensagem de erro
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
        
        terminal.close(); // Fechando o Scanner para evitar vazamento de recursos
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Valida se o primeiro parâmetro é maior que o segundo
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm; // Calcula o número de interações
        
        // Executa a contagem e imprime os números
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
