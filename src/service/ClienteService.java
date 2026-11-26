package service;

import model.Cliente;

import java.util.ArrayList;

public class ClienteService {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ArrayList<Cliente> listarClientes(){
		return clientes;
	}
	int proximoIdCliente = 1;
	public Cliente cadastrarCliente(String nome, String cpf, int idade, char sexo){
		Cliente cliente = new Cliente(proximoIdCliente, nome, cpf, idade, sexo);
		clientes.add(cliente);
		proximoIdCliente++;
		return cliente;
	}
	public Cliente excluirClientePorCpf(String cpf){
		for (Cliente c : clientes){
			if(cpf.equals(c.getCpf())){
				clientes.remove(c);
				return c;
			}
		}
		return null;
	}
	// Retorna um Cliente cadastrado pelo CPF ou null se não encontrar
	public Cliente buscarCliente(String cpf) {
	    for (Cliente c : clientes) {
	        if (c.getCpf().equals(cpf)) {
	            return c;
	        }
	    }
	    return null;
	}
}
