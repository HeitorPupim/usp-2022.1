public class App {
    public static void main(String[] args) throws Exception {

        //Sistema normal!:

        SistemaConcreto sistemaConcreto = new SistemaConcreto("Josh789", "123132");
        sistemaConcreto.LoguinSistema();

        //Sistema com filtro!:
        FilteredSistema filteredSistema = new FilteredSistema(sistemaConcreto);
        filteredSistema.LoguinSistema();



    }
}
