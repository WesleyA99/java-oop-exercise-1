package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Bem vindo Banco X");
        System.out.println("Vamos iniciar sua abertura de conta");
        BankAccountMenu.iniciar(scanner);
    }
}