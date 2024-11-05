import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo ao Conversor de Moedas!");

        while (true) {
            try {
                System.out.println("Escolha uma opção de conversão:");
                System.out.println("1. USD para ARS (Peso argentino)");
                System.out.println("2. USD para BOB (Boliviano)");
                System.out.println("3. USD para BRL (Real brasileiro)");
                System.out.println("4. USD para CLP (Peso chileno)");
                System.out.println("5. USD para COP (Peso colombiano)");
                System.out.println("6. USD para USD (Dólar americano)");
                System.out.println("7. Sair");

                if (!entrada.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                    entrada.next();
                    continue;
                }

                int escolha = entrada.nextInt();
                if (escolha == 7) break;

                String moedaEscolhida;
                boolean opcaoValida = true;

                switch (escolha) {
                    case 1 -> moedaEscolhida = "ARS";
                    case 2 -> moedaEscolhida = "BOB";
                    case 3 -> moedaEscolhida = "BRL";
                    case 4 -> moedaEscolhida = "CLP";
                    case 5 -> moedaEscolhida = "COP";
                    case 6 -> moedaEscolhida = "USD";
                    default -> {
                        System.out.println("Opção inválida. Tente novamente.");
                        opcaoValida = false;
                        continue;
                    }
                }

                if (!opcaoValida) {
                    continue;
                }

                System.out.println("Digite o valor em USD:");
                if (!entrada.hasNextDouble()) {
                    System.out.println("Entrada inválida. Por favor, digite um número com vírgula.");
                    entrada.next();
                    continue;
                }

                double valor = entrada.nextDouble();
                double taxa = ServicoDeCambio.obterTaxa(moedaEscolhida);
                System.out.printf("Valor convertido para %s: %.2f%n", moedaEscolhida, (valor * taxa));
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, tente novamente.");
                entrada.next();
            } catch (Exception e) {
                System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            }
        }

        entrada.close();
    }
}