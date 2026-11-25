package model;

public class Reserva {
	int codigo;
	Cliente cliente;
	Quarto quarto;
	int quantidadeDiarias;

	double valorTotal;
	
	
	
	public Reserva(int codigo, Cliente cliente, Quarto quarto, int quantidadeDiarias) {
		super();

		this.codigo = codigo;
		this.cliente = cliente;
		this.quarto = quarto;
		this.quantidadeDiarias = quantidadeDiarias;
		this.valorTotal = calcularValorTotal();
	}
	
	
	
	public double calcularValorTotal() {
		return this.quarto.getDiaria()*this.quantidadeDiarias;
	}
	
	
	public void cancelar() {
		quarto.liberar();
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public int getQuantidadeDiarias() {
		return quantidadeDiarias;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public void setQuantidadeDiarias(int quantidadeDiarias) {
		this.quantidadeDiarias = quantidadeDiarias;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
