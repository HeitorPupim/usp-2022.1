public class Sistema implements SistemaConfig {
    
    //atributos:
    String sUsuario, sSenha;

    //construtor

    public Sistema(String usuario, String senha){
        this.sUsuario = usuario;
        this.sSenha = senha;
    
    }


    public void abreSistema(){
        System.out.println("O sistema abriu!");
        System.out.println("Vem vindo(a): "+this.sUsuario);
    }
}
