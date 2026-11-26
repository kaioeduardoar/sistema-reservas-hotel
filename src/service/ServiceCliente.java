
package service;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ServiceCliente extends Service {

    public ServiceCliente(Hotel hotel, Scanner sc) {
        super(hotel, sc);
    }

    @Override
    public String menu() {
        clear();

        System.out.println("============================");
        System.out.println("     SERVIÇO DE CLIENTE     ");
        System.out.println("============================");

        System.out.println();
        System.out.println("1 - Cadastrar cliente.");
        System.out.println("2 - Listar clientes.");
        System.out.println("3 - Atualizar cliente.");
        System.out.println("4 - Excluir cliente.");
        System.out.println();

        System.out.println("0 - voltar");
        System.out.println("============================");

        System.out.print("Digite uma opção: ");
        return sc.nextLine();
    }

    // CADASTRAR CLIENTE
    @Override
    public void create() {
        clear();

        System.out.println("===== CADASTRAR CLIENTE =====");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        int idade = lerInteiro("Idade: ");

        char sexo = lerSexo();

        Cliente cliente = hotel.cadastrarCliente(
            nome, cpf, idade, sexo
        );

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println("ID: " + cliente.getId());

        pausar();
    }

    // LISTAR CLIENTES
    @Override
    public void list() {
        clear();

        System.out.println("======= LISTA DE CLIENTES =======");

        ArrayList<Cliente> clientes = hotel.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println("----------------------------");
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Idade: " + c.getIdade());
                System.out.println("Sexo: " + c.getSexo());
            }

            System.out.println("----------------------------");
            System.out.println("Total de clientes: " + clientes.size());
        }

        pausar();
    }

    // ATUALIZAR CLIENTE
    @Override
    public void update() {
        clear();

        System.out.println("===== ATUALIZAR CLIENTE =====");

        Cliente cliente;
        
        cliente = buscarClientePorCpf();
        
        if(cliente == null) {
        	return;
        }

        
        String escolha;

        do {
            clear();

            System.out.println("===== ATUALIZAR CLIENTE =====");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println();

            System.out.println("1 - Alterar nome.");
            System.out.println("2 - Alterar CPF.");
            System.out.println("3 - Alterar idade.");
            System.out.println("4 - Alterar sexo.");
            System.out.println();
            System.out.println("0 - Voltar");

            System.out.print("\nEscolha: ");
            escolha = sc.nextLine();

            switch (escolha) {
            	case "1":
            		System.out.print("Novo nome: ");
            		cliente.setNome(sc.nextLine());
            		System.out.println("Nome atualizado!");
            		pausar();
            		break;

            	case "2":
            		System.out.print("Novo CPF: ");
            		cliente.setCpf(sc.nextLine());
            		System.out.println("CPF atualizado!");
            		pausar();
            		break;

            	case "3":
                	cliente.setIdade(lerInteiro("Nova idade: "));
                	System.out.println("Idade atualizada!");
                	pausar();
                	break;

            	case "4":
            		cliente.setSexo(lerSexo());
            		System.out.println("Sexo atualizado!");
            		pausar();
            		break;

            	case "0":
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    pausar();
            }

        } while (!escolha.equals("0"));
    }

    // EXCLUIR CLIENTE
    @Override
    public void delete() {
        clear();

        System.out.println("===== EXCLUIR CLIENTE =====");
        
        Cliente cliente = buscarClientePorCpf();
        
        if(cliente == null) {
        	return;
        }

        System.out.println("\nCliente encontrado:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        if (confirmar("\nDeseja realmente excluir? (S/N): ")) {
        	hotel.excluirClientePorCpf(cliente.getCpf());
        	System.out.println("\nCliente excluído com sucesso!");
        } else {
        	System.out.println("\nOperação cancelada.");
        }

        pausar();
    }

    
    // MÉTODOS AUXILIARES

    private char lerSexo() {
    	while (true) {
        	System.out.print("Sexo (M/F): ");
        	
        	String entrada = sc.nextLine();

        	if (entrada.equalsIgnoreCase("M") || entrada.equalsIgnoreCase("F")) {
        		return entrada.toUpperCase().charAt(0);
        	}

        	System.out.println("Opção inválida! Digite M ou F.");
        }
    }

}
