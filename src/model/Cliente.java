package model;

public class Cliente extends Pessoa {
	private int id;
	public Cliente(int id, String nome, String cpf, int idade, char sexo) {
		super(nome, cpf, idade, sexo);
		this.id = id;
	}

	@Override
	public String toString() {
		return "- " + this.getNome() 
				+ "\nCPF: " + this.getCpf() 
				+ "\nSEXO: " + this.getSexo() 
				+ "\nIDADE: " + this.getIdade();
	}
	
}
