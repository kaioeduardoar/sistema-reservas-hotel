package service;

import model.Cliente;
import model.Quarto;
import model.Reserva;

import java.util.ArrayList;

public class ReservaService {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	public ArrayList<Reserva> listarReservas(){
		return reservas;
	}

	public Reserva pesquisarReserva(int codigo){
		for(Reserva r : reservas){
			if(r.getCodigo() == codigo){
				return r;
			}
		}
		return null;
	}

	int proximoCodigoReserva = 1;
	public Reserva realizarReserva(Cliente cliente, Quarto quarto, int quantidadeDiarias){
		Reserva reserva = new Reserva(proximoCodigoReserva, cliente, quarto, quantidadeDiarias);
		reservas.add(reserva);
		proximoCodigoReserva++;
		quarto.setDisponivel(false);
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
}
