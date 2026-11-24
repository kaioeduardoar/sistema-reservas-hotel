import service.Hotel;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Hotel hotel = new Hotel();
	
	public static void main(String[] args) {
		
		int escolha;
		do {
			escolha = menuPrincipal();
			
			switch (escolha) {
		    case 1:
		        cadastrarCliente();
		        break;

		    case 2:
		        listarClientes();
		        break;

		    case 3:
		        listarQuartos();
		        break;

		    case 4:
		        cadastrarQuarto();
		        break;

		    case 5:
		        realizarReserva();
		        break;

		    case 6:
		        listarReservas();
		        break;

		    case 7:
		        cancelarReserva();
		        break;
		}
			
		}while(escolha != 0);
		
		
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
		
	}
	public static void listarReservas() {
		
	}
	public static void cancelarReserva() {
		
	}



	public static int menuPrincipal() {
		clear();
		int escolha = 0;
		
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
		while(true) {
			System.out.print("Digite uma opção: ");
			escolha = sc.nextInt();
			
			if(escolha < 0 || escolha > 7) {
				System.out.println("Valor inválido!");
				continue;
			}
			break;
		}

		return escolha;
	}
	
	
	
	static public void clear() {
		for(int i = 0;i < 50;i++) {
			System.out.println();
		}
	}
	

}
