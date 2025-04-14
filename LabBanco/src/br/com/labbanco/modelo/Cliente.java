package br.com.labbanco.modelo;

/**
 * Classe que representa um cliente do banco.
 */
public class Cliente {

	private String nome;
	private String cpf;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
			throw new IllegalArgumentException("CPF não pode ser vazio");
		}
		this.cpf = cpf;
	}
}