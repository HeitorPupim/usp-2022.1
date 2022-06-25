public class Mult3 extends Numero{
    
    public Mult3(Numero numSucessor){
        super(numSucessor);
    }

    @Override
    public void CalculaNumero(Calcula oCalcula) {
        if ((oCalcula.getNum() % 3 ) == 0){
            System.out.println("Numero é multiplo de 3!");
        }
        else{
            numSucessor.CalculaNumero(oCalcula);
        }
    }

}
