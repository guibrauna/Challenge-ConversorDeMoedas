package br.com.conversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService api = new ExchangeRateService();
        Conversor conversor = new Conversor();

        System.out.println("=== Conversor de Moedas ===");

        while (true) {
            System.out.println("\nEscolha a conversão desejada:");
            System.out.println("1. BRL → USD");
            System.out.println("2. USD → BRL");
            System.out.println("3. BRL → ARS");
            System.out.println("4. ARS → BRL");
            System.out.println("5. USD → CLP");
            System.out.println("6. CLP → USD");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                System.out.println("Encerrando...");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
                continue;
            }

            String from = "", to = "";

            switch (opcao) {
                case "1" -> { from = "BRL"; to = "USD"; }
                case "2" -> { from = "USD"; to = "BRL"; }
                case "3" -> { from = "BRL"; to = "ARS"; }
                case "4" -> { from = "ARS"; to = "BRL"; }
                case "5" -> { from = "USD"; to = "CLP"; }
                case "6" -> { from = "CLP"; to = "USD"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            double taxa = api.obterTaxa(from, to);
            if (taxa == -1) {
                System.out.println("Erro ao obter taxa de câmbio.");
            } else {
                double convertido = conversor.converter(valor, taxa);
                System.out.printf("✅ %.2f %s = %.2f %s%n", valor, from, convertido, to);
            }
        }

        scanner.close();
    }
}
