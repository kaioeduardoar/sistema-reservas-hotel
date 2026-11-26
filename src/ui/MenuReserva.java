package ui;

import model.*;
import service.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuReserva extends Menu {

	public MenuReserva(Hotel hotel, Scanner sc) {
		super(hotel, sc);
	}
	
	@Override
	public void init() {
		String escolha;
		do {
			escolha = menu();
			
			switch (escolha) {
		    case "1":
		    	create();
		        break;
		    case "2":
		    	list();
		        break;
		    case "3":
		    	delete();
		        break;
		}
			
		}while(!escolha.equals("0"));
	}
	
	@Override
	public String menu() {
		String escolha;
		clear();
		System.out.println("============================");
		System.out.println("    SERVIÇO DE RESERVAS     ");
		System.out.println("============================");
		
		System.out.println();
		System.out.println("1 - Fazer reserva.");
		System.out.println("2 - Listar reservas.");
		System.out.println("3 - Excluir reserva.");
		System.out.println();
		
		System.out.println("0 - voltar");
		System.out.println("============================");
		
		System.out.print("Digite uma opção: ");
		escolha = sc.nextLine();

		return escolha;
	}

	@Override
	public void create() {
		clear();
		if (hotel.clienteService.listarClientes().size() == 0) {
			clear();
			System.out.println("Não há nenhum cliente cadastrado ainda!");
			System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
			return;
		}
		if (hotel.quartoService.listarQuartos().size() == 0) {
			clear();
			System.out.println("Não há nenhum quarto cadastrado ainda!");
			System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
			return;
		}
		
		Cliente cliente;
		Quarto quarto;
		int diarias;
		
		// Seleção de cliente
		cliente = buscarClientePorCpf();
		if (cliente == null) {
			return;
		}
		
		System.out.println("\nCliente encontrado:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        
        pausar();
		
		
		// Seleção de quarto
		System.out.println();
		System.out.println("QUARTOS DISPONÍVEIS");
		System.out.println();
		
		ArrayList<Quarto> quartosDisponiveis = hotel.quartoService.buscarQuartosDisponiveis();
		for(Quarto q: quartosDisponiveis) {
			System.out.printf(" %-5d - %-10s - R$ %.2f/dia", q.getNumero(), q.getTipo(), q.getDiaria());
			System.out.println();
		}
		
		System.out.println();
		quarto = buscarQuartoPorNumero();
        
        if(quarto == null) {
        	return;
        }
		
		// Seleção de diárias
		diarias = lerInteiro("\nQuantos dias: ");
		
		
		// Criação e confimeção da reserva
		clear();
		System.out.println();
		System.out.println("RESUMO DA RESERVA");
		System.out.println();
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Quarto: " + quarto.getNumero() + " (" + quarto.getTipo() + ")");
		System.out.println("Diárias: " + diarias);
		System.out.printf("Valor: R$%.2f \n", quarto.getDiaria()*diarias);
		
	
		if (confirmar("\nConfirmar reserva? (S/N): ")) {
			hotel.reservaService.realizarReserva(cliente, quarto, diarias);
			clear();
			System.out.println("Reserva concluída!");
			pausar();
			return;
		} else {
			clear();
			System.out.println("Reserva cancelada!");
			pausar();
			return;
		}
	}
	
	@Override
	public void list() {
		ArrayList<Reserva> reservas = hotel.reservaService.listarReservas();
		clear();
		
	    if (reservas.isEmpty()) {
	        System.out.println("\nNenhuma reserva cadastrada!");
	        pausar();
	        return;
	    }

	    System.out.println("\n" + "=".repeat(65));
	    System.out.printf("%-8s %-20s %-12s %-8s %12s%n", "CÓDIGO", "CLIENTE", "QUARTO", "DIÁRIAS", "VALOR");
	    System.out.println("-".repeat(65));

	    for (Reserva r : reservas) {

	        System.out.printf("%-8d %-20s %-12s %-8d R$ %9.2f%n",
	                r.getCodigo(),
	                r.getCliente().getNome(),
	                r.getQuarto().getNumero(),
	                r.getQuantidadeDiarias(),
	                r.getValorTotal()
	        );
	    }

	    System.out.println("=".repeat(65));
	    
		pausar();
		return;
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void delete() {
	    clear();

	    System.out.println("===== CANCELAR RESERVA =====");

	    int codigo = lerInteiro("Digite o código da reserva: ");

	    Reserva reserva = hotel.reservaService.pesquisarReserva(codigo);

	    if (reserva == null) {
	        System.out.println("\nReserva não encontrada!");
	        pausar();
	        return;
	    }

	    System.out.println("\nReserva encontrada:");
	    System.out.println("----------------------------");
	    System.out.println("Código: " + reserva.getCodigo());
	    System.out.println("Cliente: " + reserva.getCliente().getNome());
	    System.out.println("Quarto: " + reserva.getQuarto().getNumero());
	    System.out.println("Diárias: " + reserva.getQuantidadeDiarias());
	    System.out.println("----------------------------");


	    if (confirmar("\nDeseja realmente cancelar? (S/N): ")) {
	        reserva.getQuarto().liberar();

	        hotel.reservaService.cancelarReservaPorCodigo(codigo);

	        System.out.println("\nReserva cancelada com sucesso!");
	    } else {
	        System.out.println("\nOperação cancelada.");
	    }

	    pausar();
	}
	
}
