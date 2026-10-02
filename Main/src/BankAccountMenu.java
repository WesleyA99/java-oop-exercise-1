package src;
import java.util.Scanner;

public class BankAccountMenu {

    public static void iniciar(Scanner scanner) {

        Usuario usuario = UserRegistration.criar(scanner);

        System.out.println("Ola Bem vindo " + usuario.getName());
        System.out.println("Para iniciar finalizar a criação, precisa depositar um valor. Digite o valor do Deposito");
        double initDeposit = Double.parseDouble(scanner.nextLine());

        BankAccount account = new BankAccount(initDeposit);
        System.out.println("Valor de R$"+ initDeposit + " recebido");

        boolean goOn = true;

        while (goOn) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar se está usando cheque especial");
            System.out.println("7 - Consultar dados (nome/cpf)");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Seu Saldo atual é de:");
                    System.out.println("R$" + account.getBalance() + " reais");
                    break;

                case 2:
                    System.out.println("Seu limite de cheque especial é de:");
                    System.out.println("R$" + account.getLimitCheck() + " reais");
                    break;

                case 3:
                    System.out.println("Qual o valor a depositar?");
                    double value = Double.parseDouble(scanner.nextLine());
                    try {
                        account.deposit(value);
                        System.out.println("Depósito realizado! Saldo atual: R$" + account.getBalance());
                    } catch (IllegalArgumentException erro) {
                        System.out.println("ERRO" + erro.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Qual o valor de saque?");
                    double valueWithdraw = Double.parseDouble(scanner.nextLine());
                    try{
                    account.withdraw(valueWithdraw);
                    System.out.println("Saque no valor de: R$" + valueWithdraw + " realizado com sucesso");
                    }catch(IllegalArgumentException erro){
                        System.out.println("ERRO:" + erro.getMessage());

                    }
                    break;

                case 5:
                    System.out.println("Qual o valor do boleto?");
                    double valueBill = Double.parseDouble(scanner.nextLine());
                    try{
                    account.payBill(valueBill);
                    System.out.println("Boleto pago com sucesso");
                    }catch(IllegalArgumentException erro){
                        System.out.println("ERRO: " + erro.getMessage());
                    }
                    break;

                case 6:
                    if (account.isUsingSpecialCheck()) {
                        System.out.println("Sim, você está usando o cheque especial");
                    } else {
                        System.out.println("Não, você não está usando o cheque especial");
                    }
                    break;

                case 7:
                    System.out.println("Seu nome: " + usuario.getName() + ", seu CPF: " + usuario.getCpf());
                    break;

                case 8:
                    goOn = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}