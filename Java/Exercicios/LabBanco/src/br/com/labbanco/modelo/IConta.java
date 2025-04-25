package br.com.labbanco.modelo;

/**
 * Interface que define as operações básicas de uma conta bancária.
 */
public interface IConta {
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, IConta contaDestino);
	void imprimirExtrato();
}