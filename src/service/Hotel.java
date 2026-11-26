package service;

import model.Cliente;
import model.Quarto;
import model.TipoQuarto;

public class Hotel {
	public final ClienteService clienteService = new ClienteService();
	public final QuartoService quartoService = new QuartoService();
	public final ReservaService reservaService = new ReservaService();

	// cria 5 Clientes e 5 Quartos para testes
 	public void testeData() {
		for(int i = 0; i < 5; i++) {
			clienteService.listarClientes().add(new Cliente(999+i, "Clone Name "+i, "999"+i, 18+i, (i%2==0)?'M':'F'));
			quartoService.listarQuartos().add(new Quarto(100+i, TipoQuarto.CASAL, 30+i*3, true));
		}
	}
	public Hotel() {

	}
}
