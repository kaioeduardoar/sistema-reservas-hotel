package service;

import model.Quarto;
import model.TipoQuarto;

import java.util.ArrayList;

public class QuartoService {
	private ArrayList<Quarto> quartos = new ArrayList<Quarto>();

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
	        if (q.getNumero() == numero) {
	            return q;
	        }
	    }
	    return null;
	}
	public Quarto buscarQuartoDisponivel(int numero){
		Quarto q = buscarQuarto(numero);
		if (q != null && q.isDisponivel()){
			return q;
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
}
