package co.javaproject.bank;

public class App {
    public static void main(String[] args) {

        // criar uma conta (agencia, conta, nome)
        // limitar o nome = 12 caracteres
        Account account = new Account("0001", "1234", "usuário 1");

        // sacar valores
        // não pode sacar mais do que tem
        boolean succed = account.withDraw(200.0);
        if (!succed) {
            System.out.println("Você não tem saldo suficiente para sacar!");
        }

        // depositar
        account.deposit(100);
        account.deposit(50);
        account.deposit(100);

        if(!account.withDraw(200)) {
            System.out.println("Você não tem saldo suficiente para sacar!");
        }

        if(!account.withDraw(200)) {
            System.out.println("Você não tem saldo suficiente para sacar!");
        }

        // informar para o usuario as operações (saque, depósito)
        System.out.println(account);
    }
}