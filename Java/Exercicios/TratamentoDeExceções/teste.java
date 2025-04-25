package TratamentoDeExceções;
public class teste {

    public static void main(String[] args) {
        String input = "a1.75";
        Double valor;

        try {
            // Remover todos os caracteres que não são dígitos, pontos ou sinais negativos (se necessário)
            String cleanedInput = input.replaceAll("[^0-9.]", "");

            // Verificar se a string limpa não está vazia
            if (cleanedInput.isEmpty()) {
                throw new NumberFormatException("Nenhum número encontrado na string.");
            }

            // Converter a string limpa para double
            valor = Double.parseDouble(cleanedInput);
            System.out.println("Valor convertido: " + valor);
        } catch (NumberFormatException e) {
            System.out.println("Não foi possível converter a string para número: " + e.getMessage());
        }
    }
}