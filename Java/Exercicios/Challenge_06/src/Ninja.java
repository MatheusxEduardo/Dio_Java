public class Ninja {
    private String name;
    private int idade;
    private String vila;

    // Construtor da classe
    public Ninja(String name, int idade, String vila) {
        this.name = name;
        this.idade = idade;
        this.vila = vila;
    }

    //Getters para atributos privados
    public String getNome() {
        return this.name;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getVila() {
        return this.vila;
    }

    @Override
    public String toString() {
        return "Ninja{nome='" + name + "', idade=" + idade + ", vila='" + vila + "'}";    }
}
