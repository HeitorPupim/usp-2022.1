public class App {
    public static void main(String[] args) throws Exception {
        
        Sistema sistema = new Sistema("John","313");
        sistema.abreSistema();
        

        System.out.println("\n");
        System.out.println("sistema proxy com risco:\n");

        SistemaProxy sistemaProxyRisco = new SistemaProxy("Edward","789");
        sistemaProxyRisco.abreSistema();
        
        System.out.println("\n");
        System.out.println("sistema proxy sem risco:");

        SistemaProxy sistemaProxy = new SistemaProxy("Ryan", "senha");
        sistemaProxy.abreSistema();

    }
}
