package model;

public class Pessoa {
	String nome;
	String cpf;
	int idade;
	char sexo;
	
	public Pessoa(String nome, String cpf, int idade, char sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int getIdade() {
		return idade;
	}
	public char getSexo() {
		return sexo;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
	
	

	
}
