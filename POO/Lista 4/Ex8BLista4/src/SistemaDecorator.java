public class SistemaDecorator extends Sistema {

    Sistema sistemaASerDecorado;

    protected SistemaDecorator(Sistema sistemaDecorado){
        this.sistemaASerDecorado = sistemaDecorado;
    }

    @Override
    void LoguinSistema() {
        System.out.println("TESTE!!!!!");
    }
    
}
