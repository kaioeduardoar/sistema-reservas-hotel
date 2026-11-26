
package ui;

import model.*;
import service.Hotel;

import java.util.ArrayList;
import java.util.Scanner;


public class MenuQuarto extends Menu {

    public MenuQuarto(Hotel hotel, Scanner sc) {
        super(hotel, sc);
    }

    @Override
    public String menu() {
        clear();

        System.out.println("============================");
        System.out.println("     SERVIÇO DE QUARTO      ");
        System.out.println("============================");

        System.out.println();
        System.out.println("1 - Cadastrar quarto.");
        System.out.println("2 - Listar quartos.");
        System.out.println("3 - Atualizar quarto.");
        System.out.println("4 - Excluir quarto.");
        System.out.println();

        System.out.println("0 - voltar");
        System.out.println("============================");

        System.out.print("Digite uma opção: ");
        return sc.nextLine();
    }

    // CADASTRAR QUARTO
    @Override
    public void create() {
        clear();

        System.out.println("===== CADASTRAR QUARTO =====");

        int numero = lerInteiro("Número do quarto: ");

        TipoQuarto tipo = lerTipoQuarto();

        double diaria = lerDouble("Valor da diária: ");

        boolean disponivel = lerDisponibilidade();

        Quarto quarto = hotel.quartoService.adicionarQuarto(
            numero, tipo, diaria, disponivel
        );

        System.out.println("\nQuarto cadastrado com sucesso!");
        System.out.println("Número: " + quarto.getNumero());

        pausar();
    }

    // LISTAR QUARTOS
    @Override
    public void list() {
        clear();

        System.out.println("======= LISTA DE QUARTOS =======");

        ArrayList<Quarto> quartos = hotel.quartoService.listarQuartos();

        if (quartos.isEmpty()) {
            System.out.println("\nNenhum quarto cadastrado.");
        } else {
            for (Quarto q : quartos) {
                System.out.println("----------------------------");
                System.out.println("Número: " + q.getNumero());
                System.out.println("Tipo: " + q.getTipo());
                System.out.printf("Diária: R$ %.2f%n", q.getDiaria());
                System.out.println(
                    "Disponibilidade: " +
                    (q.isDisponivel() ? "Disponível" : "Ocupado")
                );
            }

            System.out.println("----------------------------");
            System.out.println("Total de quartos: " + quartos.size());
        }

        pausar();
    }

    // ATUALIZAR QUARTO
    @Override
    public void update() {
        clear();

        System.out.println("===== ATUALIZAR QUARTO =====");

        Quarto quarto = buscarQuartoPorNumero();
                
        if(quarto == null) {
        	return;
        }

        String escolha;

        do {
            clear();

            System.out.println("===== ATUALIZAR QUARTO =====");
            System.out.println("Quarto: " + quarto.getNumero());
            System.out.println("Tipo: " + quarto.getTipo());
            System.out.printf("Diária: R$ %.2f%n", quarto.getDiaria());
            System.out.println(
                "Disponibilidade: " +
                (quarto.isDisponivel() ? "Disponível" : "Ocupado")
            );

            System.out.println();
            System.out.println("1 - Alterar número.");
            System.out.println("2 - Alterar tipo.");
            System.out.println("3 - Alterar diária.");
            System.out.println("4 - Alterar disponibilidade.");
            System.out.println();
            System.out.println("0 - Voltar");

            System.out.print("\nEscolha: ");
            escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    quarto.setNumero(
                        lerInteiro("Novo número: ")
                    );
                    System.out.println("Número atualizado!");
                    pausar();
                    break;

                case "2":
                    quarto.setTipo(lerTipoQuarto());
                    System.out.println("Tipo atualizado!");
                    pausar();
                    break;

                case "3":
                    quarto.setDiaria(
                        lerDouble("Nova diária: ")
                    );
                    System.out.println("Diária atualizada!");
                    pausar();
                    break;

                case "4":
                    quarto.setDisponivel(lerDisponibilidade());
                    System.out.println("Disponibilidade atualizada!");
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

    // EXCLUIR QUARTO
    @Override
    public void delete() {
        clear();

        System.out.println("===== EXCLUIR QUARTO =====");

        Quarto quarto = buscarQuartoPorNumero();
        
        if(quarto == null) {
        	return;
        }
        
        System.out.println("\nQuarto encontrado:");
        System.out.println("Número: " + quarto.getNumero());
        System.out.println("Tipo: " + quarto.getTipo());

        System.out.print("\nDeseja realmente excluir? (S/N): ");
        String escolha = sc.nextLine();

        if (escolha.equalsIgnoreCase("S")) {
            hotel.quartoService.excuirQuarto(quarto.getNumero());
            System.out.println("\nQuarto excluído com sucesso!");
        } else {
            System.out.println("\nOperação cancelada.");
        }

        pausar();
    }

    // MÉTODOS AUXILIARES
 
    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            try {
                String entrada = sc.nextLine().replace(",", ".");
                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido!");
            }
        }
    }

    private TipoQuarto lerTipoQuarto() {
        while (true) {
            System.out.println("\nTipos de quarto:");
            System.out.println("1 - Solteiro");
            System.out.println("2 - Casal");
            System.out.println("3 - Suíte");
            System.out.println("4 - Luxo");

            System.out.print("Escolha o tipo: ");
            String escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    return TipoQuarto.SOLTEIRO;

                case "2":
                    return TipoQuarto.CASAL;

                case "3":
                    return TipoQuarto.SUITE;

                case "4":
                    return TipoQuarto.LUXO;

                default:
                    System.out.println("\nTipo inválido! Tente novamente.");
            }
        }
    }

    private boolean lerDisponibilidade() {
        while (true) {
            System.out.println("\nDisponibilidade:");
            System.out.println("1 - Disponível");
            System.out.println("2 - Ocupado");

            System.out.print("Escolha: ");
            String escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    return true;

                case "2":
                    return false;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
    }

}
