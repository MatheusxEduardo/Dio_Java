import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        imprimirSelecionados();
    }

    static void imprimirSelecionados() {
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Candidatos Selecionados índice de numero");
        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }        
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;

        while (candidatosSelecionados < 5) {
            if (candidatosAtual >= candidatos.length) {
                System.out.println("Não há mais candidatos disponíveis.");
                break;
            }

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                candidatosSelecionados++;
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
            }

            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDAR DEMAIS RESULTADOS.");
        }
    }
}