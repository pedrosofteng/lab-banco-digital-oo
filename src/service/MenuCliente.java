package service;

import model.ContaCorrente;

import java.util.Scanner;

public class MenuCliente {
    private ContaCorrente conta;
    private ValidarInformacoes validar = new ValidarInformacoes();

    public MenuCliente(ContaCorrente conta) {
        this.conta = conta;
    }

    public void executar() {
        int numero = 0;
        String mensagem = """
                \n[1] Consultar extrato bancário
                [2] Sacar
                [3] Transferir
                [4] Depositar
                [5] Sair
                
                Escolha uma opção: """;

        while (numero != 100) {
            System.out.println(mensagem);
            numero = validar.lerInteiro();

            switch (numero) {
                case 1:
                    conta.imprimirExtrato();
                    break;
                case 2:
                    System.out.print("\nQuanto deseja sacar? ");
                    conta.sacar(validar.lerDouble());
                    break;
                case 3:
                    System.out.print("\nQuanto deseja transferir? ");
                    double valor = validar.lerDouble();
                    System.out.print("Digite o nome completo da pessoa que deseja transferir: ");
                    String iConta = validar.lerTexto();

                    conta.transferir(valor, iConta);
                    break;
                case 4:
                    System.out.print("\nQuanto deseja depositar? ");
                    conta.depositar(validar.lerDouble());
                    break;
                case 5:
                    numero = 100;
                    break;
            }
        }
    }
}
