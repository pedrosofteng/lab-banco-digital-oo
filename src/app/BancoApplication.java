package app;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.Menu;

public class BancoApplication {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.executar();
    }
}
