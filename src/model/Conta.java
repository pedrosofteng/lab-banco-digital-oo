package model;

import service.Cadastro;

import java.util.Random;

public abstract class Conta implements IConta {
	Random random = new Random();

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public void criarConta(Cliente cliente) {
        this.agencia = random.nextInt(900000) + 100000;
		this.numero = random.nextInt(10) + 1;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor >= 1) {
			saldo += valor;
		} else {
			System.out.println("Só é possível creditar valores acima de R$ 1,00.");
		}
	}


	// verificar se vai dar pra transferir pra poupança ou corrente.
	@Override
	public void transferir(double valor, String conta) {
		if (saldo >= valor) {
			this.sacar(valor);
			ContaCorrente contaDestino = Cadastro.buscarContaPorNome(conta);
			if (contaDestino != null) {
				contaDestino.depositar(valor);
			} else {
				System.out.println("Erro, conta não encontrada.");
			}
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
