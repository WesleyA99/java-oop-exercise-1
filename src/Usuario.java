
public class Usuario {
    
    private String name;
    private final String CPF;
    
    public Usuario( String name, String CPF ){
        this.name = name;
        this.CPF = CPF;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        if (name == null || name.isEmpty()){
            System.out.println("Nome invalido");
        }else {
            this.name = name;
        }
    }
    public String getCpf(){
        return CPF;
    }

}
