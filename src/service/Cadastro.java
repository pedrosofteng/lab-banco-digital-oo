package service;

import model.Cliente;
import model.ContaCorrente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private ValidarInformacoes validar = new ValidarInformacoes();
    private Scanner scanner = new Scanner(System.in);
    private static List<Cadastro> listaCadastros = new ArrayList<>();
    private static List<ContaCorrente> listaContasCorrente = new ArrayList<>();
    private String nome;
    private String senha;
    private String login;

    public Cadastro(String login, String senha) {
        this.login = login;
        this.senha = senha;

        System.out.print("Informe seu nome completo: ");
        this.nome = validar.lerSomenteFrases();
        Cliente cliente = new Cliente(nome);
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.criarConta(cliente);
        listaCadastros.add(this);
        listaContasCorrente.add(contaCorrente);
    }

    public static boolean validarLogin(String login, String senha) {
        return listaCadastros.stream()
                .anyMatch(c -> c.login.equalsIgnoreCase(login) && c.senha.equalsIgnoreCase(senha));
    }

    public static void listarCadastros() {
        listaCadastros.stream()
                .forEach(c -> System.out.println("Nome: " + c.nome + " || Senha: " + c.senha));
    }

    public static ContaCorrente buscarContaPorLogin(String login) {
        for (int i = 0; i < listaCadastros.size(); i++) {
            Cadastro c = listaCadastros.get(i);
            if (c.login.equalsIgnoreCase(login)) {
                return listaContasCorrente.get(i);
            }
        }
        return null;
    }

    public static ContaCorrente buscarContaPorNome(String nome) {
        for (int i = 0; i < listaCadastros.size(); i++) {
            Cadastro c = listaCadastros.get(i);
            if (c.nome.equalsIgnoreCase(nome)) {
                return listaContasCorrente.get(i);
            }
        }
        return null;
    }
}
