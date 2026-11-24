package model;

public class Quarto {
	private int numero;
	private TipoQuarto tipo;
	private double diaria;
	private boolean disponivel = true;
	
	
	public Quarto(int numero, TipoQuarto tipo, double diaria, boolean disponivel) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.diaria = diaria;
		this.disponivel = disponivel;
	}
	
	
	
	public void ocupar() {
		setDisponivel(false);
	}
	public void liberar() {
		setDisponivel(true);
	}
	
	
	
	public int getNumero() {
		return numero;
	}
	public String getTipo() {
		return tipo.getDescricao();
	}
	public double getDiaria() {
		return diaria;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}
	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	
}
