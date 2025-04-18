package service;

import model.ContaCorrente;

import java.util.Scanner;

public class Menu {
    private ValidarInformacoes validar = new ValidarInformacoes();
    private String login;
    private String senha;

    public void executar(){
        int numero = 0;
        String mensagem = """
                \n[1] Login
                [2] Cadastro
                [3] Sair
                
                Escolha uma opção: """;

        while(numero != 100) {
            System.out.println(mensagem);
            numero = validar.lerInteiro();

            switch (numero) {
                case 1:
                    System.out.print("\nDigite o login: ");
                    login = validar.lerTexto();
                    System.out.print("Digite a senha: ");
                    senha = validar.lerTexto();

                    if (Cadastro.validarLogin(login, senha)) {
                        ContaCorrente contaCorrente = Cadastro.buscarContaPorLogin(login);
                        if (contaCorrente != null) {
                            MenuCliente menuCliente = new MenuCliente(contaCorrente);
                            menuCliente.executar();
                        } else {
                            System.out.println("Erro: Conta não encontrada.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nDigite o login para cadastrar: ");
                    login = validar.lerTexto();
                    System.out.print("Digite a senha para cadastrar: ");
                    senha = validar.lerTexto();
                    Cadastro cadastro = new Cadastro(login, senha);
                    break;
                case 3:
                    numero = 100;
                    break;
            }
        }
    }
}
