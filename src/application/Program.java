package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();

		// Instancia o objeto Account com os dados obtidos acima
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		if (amount > acc.getWithdrawLimit()) {
			System.out.println("Erro de saque: A quantia excede o limte de saque");
		}
		else if (amount > acc.getBalance()) {
			System.out.println("Erro de saque: Saldo insuficiente");
		}
		else {
			acc.withdraw(amount);
		
			// System.out.println("Novo Saldo: " + String.format("%.2f", acc.getBalance()));
			System.out.printf("Novo Saldo: %.2f%n", acc.getBalance());
		}
		
		sc.close();
		}
}