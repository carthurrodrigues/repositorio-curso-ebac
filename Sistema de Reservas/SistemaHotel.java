import java.util.Scanner;

public class SistemaHotel {

    private static final int CAPACIDADE_MAXIMA = 10;

    private static Reserva[] reservas = new Reserva[CAPACIDADE_MAXIMA];
    private static int totalReservas = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        System.out.println("═══════════════════════════════════════");
        System.out.println("   BEM-VINDO AO SISTEMA HOTEL JAVA     ");
        System.out.println("═══════════════════════════════════════");

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> novaReserva();
                case 2 -> listarReservas();
                case 3 -> buscarPorNome();
                case 4 -> ordenarPorDias();
                case 5 -> System.out.println("\nEncerrando o sistema. Até logo!");
                default -> System.out.println("\n[ERRO] Opção inválida. Tente novamente.\n");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n───────────────────────────────────────");
        System.out.println("             MENU PRINCIPAL            ");
        System.out.println("───────────────────────────────────────");
        System.out.println("  1. Nova Reserva");
        System.out.println("  2. Listar Reservas");
        System.out.println("  3. Buscar Reserva por Nome");
        System.out.println("  4. Ordenar por Número de Dias (↓)");
        System.out.println("  5. Sair");
        System.out.println("───────────────────────────────────────");
    }

    private static void novaReserva() {
        System.out.println("\n[ NOVA RESERVA ]");

        // Verifica se o vetor tem espaço
        if (totalReservas >= CAPACIDADE_MAXIMA) {
            System.out.println("[AVISO] Capacidade máxima de reservas atingida (" + CAPACIDADE_MAXIMA + ").");
            return;
        }

        // Coleta os dados do usuário
        System.out.print("Nome do hóspede  : ");
        String nome = scanner.nextLine().trim();

        System.out.println("Tipos disponíveis: Standard | Luxo | Presidencial");
        System.out.print("Tipo do quarto   : ");
        String tipo = scanner.nextLine().trim();

        int dias = 0;
        while (dias < 1) {
            dias = lerInteiro("Número de dias   : ");
            if (dias < 1) {
                System.out.println("[ERRO] O número de dias deve ser pelo menos 1.");
            }
        }

        double diaria = 0;
        while (diaria <= 0) {
            diaria = lerDouble("Valor da diária (R$): ");
            if (diaria <= 0) {
                System.out.println("[ERRO] O valor da diária deve ser maior que zero.");
            }
        }

        Reserva nova = new Reserva(nome, tipo, dias, diaria);
        reservas[totalReservas] = nova;
        totalReservas++;

        System.out.println("\n[OK] Reserva cadastrada com sucesso!");
        System.out.println(nova);
    }

    private static void listarReservas() {
        System.out.println("\n[ LISTAGEM DE RESERVAS ]");

        if (totalReservas == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.println("Total de reservas: " + totalReservas);

        for (int i = 0; i < totalReservas; i++) {
            System.out.println("\nReserva #" + (i + 1));
            System.out.println(reservas[i].toString());
        }
    }

    private static void buscarPorNome() {
        System.out.println("\n[ BUSCA POR NOME ]");

        if (totalReservas == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }

        System.out.print("Digite o nome (ou parte dele): ");
        String termo = scanner.nextLine().trim().toLowerCase();

        boolean encontrou = false;

        for (int i = 0; i < totalReservas; i++) {
            String nomeCadastrado = reservas[i].getNomeHospede().toLowerCase();

            if (nomeCadastrado.contains(termo)) {
                if (!encontrou) {
                    System.out.println("\nResultados encontrados:");
                    encontrou = true;
                }
                System.out.println("\nReserva #" + (i + 1));
                System.out.println(reservas[i].toString());
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada para \"" + termo + "\".");
        }
    }

    private static void ordenarPorDias() {
        System.out.println("\n[ ORDENAÇÃO POR DIAS (DECRESCENTE) ]");

        if (totalReservas == 0) {
            System.out.println("Nenhuma reserva para ordenar.");
            return;
        }

        for (int i = 0; i < totalReservas - 1; i++) {
            for (int j = 0; j < totalReservas - 1 - i; j++) {
                if (reservas[j].getNumeroDias() < reservas[j + 1].getNumeroDias()) {

                    Reserva temp = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = temp;
                }
            }
        }

        System.out.println("Reservas ordenadas com sucesso (maior número de dias primeiro).");
        listarReservas(); // Exibe o resultado após a ordenação
    }

    private static int lerInteiro(String mensagem) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Entrada inválida. Digite um número inteiro.");
            }
        }

        return valor;
    }

    private static double lerDouble(String mensagem) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            try {
                String entrada = scanner.nextLine().trim().replace(",", ".");
                valor = Double.parseDouble(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Entrada inválida. Digite um valor numérico (ex: 250.00 ou 250,00).");
            }
        }

        return valor;
    }
}