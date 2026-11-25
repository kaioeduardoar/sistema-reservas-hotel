import service.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;
import model.Quarto;
import model.Reserva;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Hotel hotel = new Hotel();
	
	
	public static void main(String[] args) {
		hotel.testeData();
		String escolha;
		do {
			escolha = menuPrincipal();
			
			switch (escolha) {
		    case "1":
		        cadastrarCliente();
		        break;

		    case "2":
		        listarClientes();
		        break;

		    case "3":
		        listarQuartos();
		        break;

		    case "4":
		        cadastrarQuarto();
		        break;

		    case "5":
		        realizarReserva();
		        break;

		    case "6":
		        listarReservas();
		        break;

		    case "7":
		        cancelarReserva();
		        break;
		}
			
		}while(!escolha.equals("0"));
		
		
		sc.close();
	}
	
	
	
	public static void cadastrarCliente() {
		
	}
	public static void listarClientes() {
		
	}
	public static void listarQuartos() {
		
	}
	public static void cadastrarQuarto() {
		
	}
	
	
	public static void realizarReserva() {
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
	
	public static void listarReservas() {
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
	
	
	public static void cancelarReserva() {
		
	}



	public static String menuPrincipal() {
		clear();
		String escolha;
		
		System.out.println("============================");
		System.out.println("      SISTEMA DE HOTEL      ");
		System.out.println("============================");
		System.out.println();
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Listar clientes");
		
		System.out.println();
		
		System.out.println("3 - Listar quartos");
		System.out.println("4 - Cadastrar quarto");
		
		System.out.println();
		
		System.out.println("5 - Realizar reserva");
		System.out.println("6 - Listar reservas");
		System.out.println("7 - Cancelar reserva");
		
		System.out.println();
		
		System.out.println("0 - Sair");
		System.out.println("============================");
		
		// TRATAMENTO
		System.out.print("Digite uma opção: ");
		escolha = sc.next();

		return escolha;
	}
	
	
	
	static public void clear() {
		for(int i = 0;i < 50;i++) {
			System.out.println();
		}
	}
	

}
