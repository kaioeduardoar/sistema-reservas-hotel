package ui;

import java.util.Scanner;

import model.Cliente;
import model.Quarto;
import service.Hotel;

public class Menu {
	protected Hotel hotel;
	protected Scanner sc;
	
	public Menu(Hotel hotel, Scanner sc) {
		this.hotel = hotel;
		this.sc = sc;
	}
	
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
		    	update();
		        break;
		    case "4":
		    	delete();
		        break;
		}
			
		}while(!escolha.equals("0"));
	}
	
	
	// Metodos que serão substituidas nas classes filhas
	
	public String menu() {
		return null;
	}
	public void create() {
		
	}
	public void list() {
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
	
	
	// Metodos auxiliares / tratamentos
	protected Cliente buscarClientePorCpf() {
    	Cliente cliente;
    	do {
	        System.out.print("Digite o CPF do cliente: ");
	        String cpf = sc.nextLine();
	
	        cliente = hotel.clienteService.buscarCliente(cpf);
	
	        if (cliente == null) {
	            System.out.println("\nCliente não encontrado!");
	        }
    	}while(cliente == null && confirmar("\nTentar novamente? (S/N): "));

        return cliente;
    }
	protected Quarto buscarQuartoPorNumero() {
    	Quarto quarto;
    	do {
	        int numero = lerInteiro("Digite o número do quarto: ");
	
	        quarto = hotel.quartoService.buscarQuarto(numero);
	
	        if (quarto == null) {
	            System.out.println("\nQuarto não encontrado!");
	        }
    	}while(quarto == null && confirmar("\nTentar novamente? (S/N): "));
        
    	return quarto;
    }
	protected boolean confirmar(String mensagem) {
		System.out.print(mensagem);
		
		String entrada = sc.nextLine().trim();
		
		return entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("SIM");
	}
	protected int lerInteiro(String mensagem) {
	    while (true) {
	        System.out.print(mensagem);

	        try {
	            return Integer.parseInt(sc.nextLine());

	        } catch (NumberFormatException e) {
	            System.out.println("Digite apenas números inteiros!");
	        }
	    }
	}
	protected void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
	public void clear() {
		for(int i = 0;i < 100;i++) {
			System.out.println();
		}
	}
}
