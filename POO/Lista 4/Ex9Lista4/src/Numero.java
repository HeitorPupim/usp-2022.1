public abstract class Numero {

    //cria um objeto para ser encadeado.
    protected Numero numSucessor;
    
    //construtor:
    public Numero (Numero oNumSucessor){
        this.numSucessor = oNumSucessor;
    }

    public abstract void CalculaNumero(Calcula oCalcula);
}
