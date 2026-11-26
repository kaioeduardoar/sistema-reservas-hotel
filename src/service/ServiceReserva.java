package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceReserva extends Service{

	public ServiceReserva(Hotel hotel, Scanner sc) {
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
		escolha = sc.next();

		return escolha;
	}

	@Override
	public void create() {
		if (hotel.listarClientes().size() == 0) {
			clear();
			System.out.println("Não há nenhum cliente cadastrado ainda!");
			System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
			return;
		}
		if (hotel.listarQuartos().size() == 0) {
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
		do {
			System.out.println();
			System.out.println("Digite o CPF do cliente: ");  // TODO: Tratamento
			System.out.print("> ");
			String cpf = sc.next();
			
			cliente = hotel.buscarCliente(cpf);
			
			if(cliente != null) {
				break;
			} else {
				System.out.println();
				System.out.println("CPF inválido!");
			}
			
		}while(true);
		
		
		// Seleção de quarto
		System.out.println();
		System.out.println("QUARTOS DISPONÍVEIS");
		System.out.println();
		
		ArrayList<Quarto> quartosDisponiveis = hotel.buscarQuartosDisponiveis();
		for(Quarto q: quartosDisponiveis) {
			System.out.printf(" %-5d - %-10s - R$ %.2f/dia", q.getNumero(), q.getTipo(), q.getDiaria());
			System.out.println();
		}
		
		do {
			System.out.println();
			System.out.println("Digite o numero do quarto: ");
			System.out.print("> ");
			int numero = sc.nextInt();
			
			quarto = hotel.buscarQuarto(numero);
			
			if(quarto != null) {
				break;
			} else {
				System.out.println();
				System.out.println("Numero inválido!");
			}
			
		}while(true);
		
		// Seleção de diárias
		System.out.println();
		System.out.println("Quantos dias?");
		System.out.print("> ");
		diarias = sc.nextInt();
		
		
		// Criação e confimeção da reserva
		System.out.println();
		System.out.println("RESUMO DA RESERVA");
		System.out.println();
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Quarto: " + quarto.getNumero() + " (" + quarto.getTipo() + ")");
		System.out.println("Diárias: " + diarias);
		System.out.printf("Valor: R$%.2f \n", quarto.getDiaria()*diarias);
		
		System.out.println();
		System.out.println("Confirmar? (s ou sim / outra coisa cancela)");
		System.out.print("> ");
		String confirmacao = sc.next().toLowerCase();
		if (confirmacao.equals("s") || confirmacao.equals("sim")) {
			hotel.realizarReserva(cliente, quarto, diarias);
			clear();
			System.out.println("Reserva concluída!");
			System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
			return;
		} else {
			clear();
			System.out.println("Reserva cancelada!");
			System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
			return;
		}
	}
	
	@Override
	public void list() {
		ArrayList<Reserva> reservas = hotel.listarReservas();
		clear();
		
	    if (reservas.isEmpty()) {
	        System.out.println("\nNenhuma reserva cadastrada!");
	        System.out.println("(Digite algo para voltar)");
			System.out.print("> ");
			sc.next();
	        return;
	    }

	    System.out.println("\n" + "=".repeat(65));
	    System.out.printf("%-8s %-20s %-12s %-8s %12s%n",
	            "CÓDIGO", "CLIENTE", "QUARTO", "DIÁRIAS", "VALOR");
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
	    
		System.out.println("(Digite algo para voltar)");
		System.out.print("> ");
		sc.next();
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

	    Reserva reserva = hotel.pesquisarReserva(codigo);

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

	    System.out.print("\nDeseja realmente cancelar? (S/N): ");
	    String escolha = sc.nextLine();

	    if (escolha.equalsIgnoreCase("S")) {
	        reserva.getQuarto().liberar();

	        hotel.cancelarReservaPorCodigo(codigo);

	        System.out.println("\nReserva cancelada com sucesso!");
	    } else {
	        System.out.println("\nOperação cancelada.");
	    }

	    pausar();
	}
	
	private int lerInteiro(String mensagem) {
	    while (true) {
	        System.out.print(mensagem);

	        try {
	            return Integer.parseInt(sc.nextLine());

	        } catch (NumberFormatException e) {
	            System.out.println("Digite apenas números inteiros!");
	        }
	    }
	}

	private void pausar() {
	    System.out.println("\nPressione ENTER para continuar...");
	    sc.nextLine();
	}
}
