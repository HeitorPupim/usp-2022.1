public class SistemaConcreto extends Sistema{

    public SistemaConcreto (String usuario, String senha){
        this.senha = senha;
        this.usuario= usuario;
    }

    void LoguinSistema() {
        System.out.println("Bem vindo(a) ao sistema, " + usuario + "!");
    }

    void setUsuario(String usuario) {
        this.usuario = usuario;
        
    }

    void setSenha(String senha) {
        this.senha = senha;
        
    }

}
