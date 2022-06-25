public class SistemaProxy implements SistemaConfig{

    private Sistema sistema;

    public SistemaProxy(String usuario, String senha){
        this.sistema = new Sistema(usuario, senha);
    }


    public void abreSistema() {
        if(this.sistema.sUsuario.contains("789") || this.sistema.sSenha.contains("789")){
            System.out.println("ERRO -> SISTEMA EM RISCO.");
        }else{
            System.out.println("O sistema abriu!");
            System.out.println("Vem vindo(a): "+this.sistema.sUsuario);
        }        
    }
    
}
