package br.com.labbanco.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um banco e gerencia suas contas.
 */
public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		if (conta == null) {
			throw new IllegalArgumentException("Conta não pode ser nula");
		}
		this.contas.add(conta);
	}

	public boolean removerConta(Conta conta) {
		return this.contas.remove(conta);
	}

	public Conta buscarConta(int agencia, int numero) {
		for (Conta conta : contas) {
			if (conta.getAgencia() == agencia && conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public List<Conta> getContas() {
		return new ArrayList<>(contas); // Retorna uma cópia da lista
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do banco não pode ser vazio");
		}
		this.nome = nome;
	}

	public void listarClientes() {
		System.out.println("=== Clientes do " + this.nome + " ===");
		for (Conta conta : contas) {
			System.out.println(conta.cliente.getNome() + " - Ag: " +
					conta.getAgencia() + ", Conta: " + conta.getNumero());
		}
	}
}