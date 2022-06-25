public class VetorFactory {
    
    public static Vetor getCalculo(String calculo){
        
        if (calculo.equals("uniao")){
            return new VetorUniao();
        } else if (calculo.equals("interseccao")){
            return new VetorInterseccao();
        } else if (calculo.equals("diferenca")){
            return new VetorDiferenca();
        }
        throw new IllegalArgumentException("Nao existe esse calculo!");
    }
}
