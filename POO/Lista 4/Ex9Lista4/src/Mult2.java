public class Mult2 extends Numero{

    public Mult2(Numero numSucessor){
        super(numSucessor);
    }

    @Override
    public void CalculaNumero(Calcula oCalcula) {
        if ((oCalcula.getNum() % 2 ) == 0){
            System.out.println("Numero é multiplo de 2!");
        }
        else{
            numSucessor.CalculaNumero(oCalcula);
        }
        
    }
    
}
