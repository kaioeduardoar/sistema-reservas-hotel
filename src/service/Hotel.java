package service;

import model.Cliente;
import model.Quarto;
import model.Reserva;
import model.TipoQuarto;

import java.util.ArrayList;

public class Hotel {
	//Quartos
	private ArrayList<Quarto> quartos = new ArrayList<Quarto>();;

	public ArrayList<Quarto> listarQuartos(){
		return quartos;
	}
	public Quarto adicionarQuarto(int numero, TipoQuarto tipo, double diaria, boolean disponivel){
		Quarto quarto = new Quarto(numero, tipo, diaria, disponivel);
		quartos.add(quarto);
		return quarto;
	}
	public Quarto excuirQuarto(int numero){
		for (Quarto q : quartos){
			if(numero == q.getNumero()){
				quartos.remove(q);
				return q;
			}
		}
		return null;
	}
	// Retorna um Quarto cadastrado pelo Numero ou null se não encontrar
	public Quarto buscarQuarto(int numero) {
	    for (Quarto q : quartos) {
	        if (q.getNumero() == numero && q.isDisponivel()) {
	            return q;
	        }
	    }
	    return null;
	}
	// Retorna todos os quartos disponíveis
	public ArrayList<Quarto> buscarQuartosDisponiveis() {
		ArrayList<Quarto> quartosDisponiveis = new ArrayList<Quarto>();
		
		for(Quarto q:quartos) {
			if (q.isDisponivel()) {
				quartosDisponiveis.add(q);
			}
		}
		
		return quartosDisponiveis;
	}

	
	//Clientes
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();;
	public ArrayList<Cliente> listarClientes(){
		return clientes;
	}
	int proximoIdCliente = 1;
	public Cliente cadastrarCliente(String nome, String cpf, int idade, char sexo){
		Cliente cliente = new Cliente(proximoIdCliente, nome, cpf, idade, sexo);
		clientes.add(cliente);
		proximoIdCliente++;
		return cliente;
	}
	public Cliente excluirClientePorCpf(String cpf){
		for (Cliente c : clientes){
			if(cpf.equals(c.getCpf())){
				clientes.remove(c);
				return c;
			}
		}
		return null;
	}
	// Retorna um Cliente cadastrado pelo CPF ou null se não encontrar
	public Cliente buscarCliente(String cpf) {
	    for (Cliente c : clientes) {
	        if (c.getCpf().equals(cpf)) {
	            return c;
	        }
	    }
	    return null;
	}

	
	//Reservas
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();;
	public ArrayList<Reserva> listarReservas(){
		return reservas;
	}
	public ArrayList<Reserva> listarReservasPorCliente(String cpf){
		ArrayList<Reserva> reservasCliente = new ArrayList<>();
		for(Reserva r : reservas){
			if(r.getCliente().getCpf().equals(cpf)){
				reservasCliente.add(r);
			}
		}
		if(!reservasCliente.isEmpty()){
			return reservasCliente;
		}
		return null;
	}
	int proximoCodigoReserva = 1;
	public Reserva realizarReserva(Cliente cliente, Quarto quarto, int quantidadeDiarias){
		Reserva reserva = new Reserva(proximoCodigoReserva, cliente, quarto, quantidadeDiarias);
		reservas.add(reserva);
		proximoCodigoReserva++;
		return reserva;
	}
	public Reserva cancelarReservaPorCodigo(int codigo){
		for (Reserva r : reservas){
			if (r.getCodigo() == codigo){
				reservas.remove(r);
				return r;
			}
		}
		return null;
	}


	// cria 5 Clientes e 5 Quartos para testes
 	public void testeData() {
		for(int i = 0; i < 5; i++) {
			clientes.add(new Cliente(999+i, "Clone Name "+i, "999"+i, 18+i, (i%2==0)?'M':'F'));
			quartos.add(new Quarto(100+i, TipoQuarto.CASAL, 30+i*3, true));
		}
	}
	public Hotel() {

	}
	

	
}
