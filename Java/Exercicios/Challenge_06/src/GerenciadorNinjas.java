import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Scanner;

public class GerenciadorNinjas {
    private LinkedList<Ninja> listaNinjas;

    //Constructor
    public GerenciadorNinjas() {
        listaNinjas = new LinkedList<>();
    }

    //Adicionar o ninja inicial
    public  void adicionarNinjaInicio(Ninja ninja) {
        listaNinjas.addFirst(ninja);
    }

    //Remover o primeiro Ninja
    public void removerPrimeiroNinja() {
        if (!listaNinjas.isEmpty()) {
            Ninja removido = listaNinjas.removeFirst();
            System.out.println("Ninja removido: " + removido.getNome() + ", " +
                    removido.getIdade() + ", " + removido.getVila());
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    //Exibit lista completa
    public void exibirLista() {
        if (listaNinjas.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }

        // Cabeçalho da tabela
        System.out.println("\nLista de Ninjas:");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-20s | %-5s | %-15s |\n", "Nome", "Idade", "Vila");
        System.out.println("------------------------------------------------");

        // Linhas da tabela
        for (Ninja ninja : listaNinjas) {
            System.out.printf("| %-20s | %-5d | %-15s |\n",
                    ninja.getNome(), ninja.getIdade(), ninja.getVila());
        }

        // Rodapé da tabela
        System.out.println("------------------------------------------------");
    }

    //Acessar ninja especifico
    public void acessarNinja(int posicao) {
        System.out.println("\n=== Acessando Ninja na Posição " + posicao + " ===");
        if (posicao >= 0 && posicao < listaNinjas.size()) {
            Ninja ninja = listaNinjas.get(posicao);
            System.out.printf("| %-5s | %-5d | %-5s |\n",
                    ninja.getNome(), ninja.getIdade(), ninja.getVila());
        } else {
            System.out.println("Posição inválida!");
        }
    }

    //Buscar por nome
    public void buscarNinjaPorNome(String nome) {
        System.out.println("\n=== Buscando Ninja: " + nome + " ===");
        for (Ninja ninja : listaNinjas) {
            if (ninja.getNome().equalsIgnoreCase(nome)) {
                System.out.println("------------------------------------------------");
                System.out.printf("| %-20s | %-5s | %-15s |\n", "Nome", "Idade", "Vila");
                System.out.println("------------------------------------------------");
                System.out.printf("| %-20s | %-5d | %-15s |\n",
                        ninja.getNome(), ninja.getIdade(), ninja.getVila());
                System.out.println("------------------------------------------------");
                return;
            }
        }
        System.out.println("Ninja com nome '" + nome + "' não encontrado!");
    }

    //Ordernar lista por criterios
    public void ordenarLista(String criterio) {
        System.out.println("\n=== Ordenando por " + criterio + " ===");
        switch (criterio.toLowerCase()) {
            case "nome":
                listaNinjas.sort(Comparator.comparing(Ninja::getNome));
                break;
            case "idade":
                listaNinjas.sort(Comparator.comparingInt(Ninja::getIdade));
                break;
            case "vila":
                listaNinjas.sort(Comparator.comparing(Ninja::getVila));
                break;
            default:
                System.out.println("Critério inválido! Use 'nome', 'idade' ou 'vila'.");
                return;
        }
        exibirLista();
    }
    // Metodo principal
    public static void main(String[] args) {
        GerenciadorNinjas gerenciador = new GerenciadorNinjas();
        Scanner scanner = new Scanner(System.in);

        // Adicionar sete ninjas iniciais
        gerenciador.adicionarNinjaInicio(new Ninja("Naruto", 17, "Konoha"));
        gerenciador.adicionarNinjaInicio(new Ninja("Sasuke", 17, "Konoha"));
        gerenciador.adicionarNinjaInicio(new Ninja("Sakura", 17, "Konoha"));
        gerenciador.adicionarNinjaInicio(new Ninja("Kakashi", 30, "Konoha"));
        gerenciador.adicionarNinjaInicio(new Ninja("Gaara", 16, "Suna"));
        gerenciador.adicionarNinjaInicio(new Ninja("Temari", 19, "Suna"));
        gerenciador.adicionarNinjaInicio(new Ninja("Kankuro", 18, "Suna"));

        // Exibir lista inicial
        System.out.println("Lista inicial:");
        gerenciador.exibirLista();

        // Testar operações
        System.out.println("\nRemovendo o primeiro ninja:");
        gerenciador.removerPrimeiroNinja();

        System.out.println("\nAdicionando novo ninja no início:");
        gerenciador.adicionarNinjaInicio(new Ninja("Hinata", 17, "Konoha"));
        gerenciador.exibirLista();

        System.out.println("\nAcessando ninja na posição 2:");
        gerenciador.acessarNinja(2);

        // Testar busca
        System.out.println("\nBuscando ninja por nome 'Naruto':");
        gerenciador.buscarNinjaPorNome("Naruto");

        // Testar ordenação
        System.out.println("\nDigite o critério de ordenação (nome, idade, vila):");
        String criterio = scanner.nextLine();
        gerenciador.ordenarLista(criterio);

        scanner.close();
    }
}