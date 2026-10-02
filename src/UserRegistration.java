
import java.util.Scanner;

public class UserRegistration {

    public static Usuario criar(Scanner scanner) {

        String name;
        String cpf;

        do {
            name = lerNome(scanner);
            cpf = lerCpf(scanner);
        } while (!confirmar(scanner, name, cpf));

        return new Usuario(name, cpf);

    }

    private static String lerNome(Scanner scanner) {

        String name;
        do {
            System.out.print("Digite seu nome: ");
            name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.println("Nome invalido");
            } else {
                System.out.println("Usario | " + name + " | atribuido");
            }
        } while (name == null || name.isEmpty());

        return name;

    }

    private static String lerCpf(Scanner scanner) {
        String cpf;
        do {
            System.out.println("Digite o seu Cpf para a criação da sua conta.");
            System.out.print("CPF: ");
            cpf = scanner.nextLine();
            if (cpf.isEmpty() || !ValidateCPF.validate(cpf)) {
                System.out.println("CPF Invalido");
            } else {
                System.out.println("Cpf " + cpf + " Atribuido com sucesso");
            }
        } while (!ValidateCPF.validate(cpf));
        return cpf;

    }

    private static boolean confirmar(Scanner scanner, String name, String cpf) {

        System.out.println("\nO nome e o CPF estão corretos?");
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.print("Deseja alterar? (s/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("n")) {

            return true; // true = confirmado.
        } else {
            System.out.println("Vamos voltar do incio");
            return false; // false = quero alterar.
        }

    }
}