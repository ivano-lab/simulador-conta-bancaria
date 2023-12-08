package co.javaproject.bank;

import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");
        // 1 = Criar conta
        // 2 = Sair

        while(true) {
            System.out.println("O que deseja fazer?\n1) Criar conta\n2) Sair");
            String op = scanner.nextLine();

            if (op.equals("1")) {
                System.out.print("Digite o nome do titular da conta: ");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("2")) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Operação inválida! Tente novamente!");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for(Account cc: accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        // 1 = Depositar
        // 2 = Saque
        // 3 = Sair (exit)
        while (true) {
            System.out.println("O que deseja fazer?\n=====================\n1) Depósito\n2) Saque\n3) Sair da Conta");
            String op = scanner.nextLine();

            if (op.equals("1")) {
                System.out.print("Qual valor deseja depositar?\nR$");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("2")){
                System.out.print("Qual valor deseja sacar?\nR$");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Nâo foi possível sacar o valor R$" + value);
                }
            } else if (op.equals("3")) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Operação inválida! Tente novamente!");
            }
            scanner = new Scanner(System.in);
        }
    }
}