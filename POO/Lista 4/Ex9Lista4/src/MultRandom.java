public class MultRandom extends Numero{

    public MultRandom(Numero numSucessor){
        super(numSucessor);
    }

    @Override
    public void CalculaNumero(Calcula oCalcula) {
        if ( ((oCalcula.getNum() % 2 ) != 0 ) && ((oCalcula.getNum() % 3 ) != 0 )) {
            System.out.println("Numero não é multiplo de 3 nem de 2!");
        }
        else{
            numSucessor.CalculaNumero(oCalcula);
        }
        
    }
    
}
