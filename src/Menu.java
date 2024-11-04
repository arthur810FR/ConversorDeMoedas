import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo ao Conversor de Moedas!");

        while (true) {
            System.out.println("Escolha uma opção de conversão:");
            System.out.println("1. USD para EUR");
            System.out.println("2. USD para GBP");
            System.out.println("3. USD para JPY");
            System.out.println("4. USD para BRL");
            System.out.println("5. USD para CAD");
            System.out.println("6. Sair");

            int escolha = entrada.nextInt();
            if (escolha == 6) break;

            try {
                String moedaEscolhida = switch (escolha) {
                    case 1 -> "EUR";
                    case 2 -> "GBP";
                    case 3 -> "JPY";
                    case 4 -> "BRL";
                    case 5 -> "CAD";
                    default -> throw new IllegalArgumentException("Opção inválida.");
                };

                double taxa = ServicoDeCambio.obterTaxa(moedaEscolhida);
                System.out.println("Digite o valor em USD:");
                double valor = entrada.nextDouble();
                System.out.println("Valor convertido: " + (valor * taxa));
            } catch (Exception e) {
                System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            }
        }

        entrada.close();
    }
}
