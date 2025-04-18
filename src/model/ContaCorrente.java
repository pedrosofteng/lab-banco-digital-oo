package model;

public class ContaCorrente extends Conta {

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato model.Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
