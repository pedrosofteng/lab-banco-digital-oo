package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidarInformacoes {
    private Scanner scanner = new Scanner(System.in);

    public String lerSomentePalavras() {
        String texto;
        while (true) {
            texto = scanner.nextLine();
            if (texto.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Erro: digite apenas letras.");
            }
        }
        return texto;
    }

    public String lerSomenteFrases() {
        String texto;
        while (true) {
            texto = scanner.nextLine();
            if (texto.matches("[\\p{L} ]+")) {
                break;
            } else {
                System.out.println("Erro: digite apenas letras.");
            }
        }
        return texto;
    }

    public int lerInteiro() {
        int numero = 0;
        while (true) {
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.nextLine();
                continue;
            }
        }
        return numero;
    }

    public double lerDouble() {
        double numero = 0.0;
        while (true) {
            try {
                numero = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número decimal válido (use vírgula ou ponto).");
                scanner.nextLine();
                continue;
            }
        }
        return numero;
    }

    public String lerTexto() {
        String texto = "";
        while (true) {
            texto = scanner.nextLine();
            if (!texto.trim().isEmpty()) {
                break;
            } else {
                System.out.println("O texto não pode estar vazio.");
            }
        }
        return texto;
    }
}