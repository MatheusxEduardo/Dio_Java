public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, instalando Java 8 com asdf no WSL2!");
        String primeiroNome = "Matheus";
        String segundoNome = "Eduardo";

        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);
        System.out.println(nomeCompleto);
        	
    }

    public static String nomeCompleto (String primeiroNome, String segundoNome){
        return primeiroNome.concat(" ").concat(segundoNome);
    }
}
