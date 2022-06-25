public class FilteredSistema extends SistemaDecorator {

    protected FilteredSistema(Sistema sistemaDecorado) {
        super(sistemaDecorado);
    }

    public void LoguinSistema(){
        if (sistemaASerDecorado.usuario.contains("789") || sistemaASerDecorado.senha.contains("789")) {
            System.out.println("Caractere proibido detectado. Substituindo..."); 
            sistemaASerDecorado.usuario = sistemaASerDecorado.usuario.replace("789", "987");
            sistemaASerDecorado.senha = sistemaASerDecorado.senha.replace("789", "987");
        }
        System.out.println("Bem vindo(a) ao sistema, " + sistemaASerDecorado.usuario + "!");
    }
    
}
