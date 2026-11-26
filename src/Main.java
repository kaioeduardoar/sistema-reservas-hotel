import java.util.Scanner;

import service.Hotel;
import ui.MenuCliente;
import ui.MenuQuarto;
import ui.MenuReserva;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel();
		//TODO: Aqui vai ter o "hotel.load()" quando fizer
		hotel.testeData(); // TODO: TIRAR ISSO DPS KK
		
		MenuCliente serviceCliente = new MenuCliente(hotel, sc);
		MenuQuarto serviceQuarto = new MenuQuarto(hotel, sc);
		MenuReserva serviceReserva = new MenuReserva(hotel, sc);
		
		String escolha;
		do {
			escolha = menuPrincipal(sc);
			
			switch (escolha) {
		    case "1":
		        serviceCliente.init();
		        break;
		    case "2":
		    	serviceQuarto.init();
		        break;
		    case "3":
		    	serviceReserva.init();
		        break;
		}
			
		}while(!escolha.equals("0"));
		
		sc.close();
		
	}
	
	static public String menuPrincipal(Scanner sc) {
		String escolha;
		System.out.println("\n".repeat(10));
		System.out.println("============================");
		System.out.println("      SISTEMA DE HOTEL      ");
		System.out.println("============================");
		
		System.out.println();
		System.out.println("1 - Opções de cliente");
		System.out.println("2 - Opções de quartos");
		System.out.println("3 - Opções de reservas");
		System.out.println();
		
		System.out.println("0 - sair");
		System.out.println("============================");
		
		System.out.print("Digite uma opção: ");
		escolha = sc.next();

		return escolha;
	}
	
}
