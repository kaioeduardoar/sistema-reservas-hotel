package service;

import java.util.Scanner;

public class Service {
	protected Hotel hotel;
	protected Scanner sc;
	
	public Service(Hotel hotel, Scanner sc) {
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
	
	public void clear() {
		for(int i = 0;i < 50;i++) {
			System.out.println();
		}
	}
}
