package model;

public class ContaPoupanca extends Conta {

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato model.Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
