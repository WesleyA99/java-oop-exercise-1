
public class ValidateCPF {

    public static boolean validate(String cpf){
        return cpf.matches("\\d{11}");
    }
}