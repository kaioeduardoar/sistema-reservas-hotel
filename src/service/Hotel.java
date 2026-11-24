package service;

import model.Cliente;
import model.Quarto;
import model.Reserva;
import model.TipoQuarto;

import java.util.ArrayList;

public class Hotel {
	//Quartos
	private ArrayList<Quarto> quartos;

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

	//Clientes
	private ArrayList<Cliente> clientes;
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

	//Reservas
	private ArrayList<Reserva> reservas;
	public ArrayList listarReservas(){
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


	
	public Hotel() {

	}
	

	
}
