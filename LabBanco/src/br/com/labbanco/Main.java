package br.com.labbanco;


import br.com.labbanco.modelo.*;

/**
 * Classe principal para testar o sistema bancário.
 */
public class Main {

	public static void main(String[] args) {
		try {
			Banco banco = new Banco("Banco Digital");

			Cliente cliente1 = new Cliente("João da Silva", "123.456.789-00");
			Cliente cliente2 = new Cliente("Maria Santos", "987.654.321-00");

			Conta cc = new ContaCorrente(cliente1);
			Conta poupanca = new ContaPoupanca(cliente2);

			banco.adicionarConta(cc);
			banco.adicionarConta(poupanca);

			cc.depositar(100);
			cc.transferir(50, poupanca);

			cc.imprimirExtrato();
			poupanca.imprimirExtrato();

			banco.listarClientes();

			// Teste de erro: saque com valor maior que o saldo
			try {
				cc.sacar(100); // Deve lançar exceção - saldo insuficiente
			} catch (RuntimeException e) {
				System.out.println("Erro capturado: " + e.getMessage());
			}

			// Teste de erro: depósito com valor negativo
			try {
				cc.depositar(-10); // Deve lançar exceção - valor negativo
			} catch (IllegalArgumentException e) {
				System.out.println("Erro capturado: " + e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Erro inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}
}