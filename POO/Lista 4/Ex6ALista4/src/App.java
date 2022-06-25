import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Vetor, VetorCalculo 

        Vetor meusVetores = new Vetor(new Integer[]{1,2,3}, new Integer[]{1,4,5});
        
        Integer [] intersec = meusVetores.calculaVetor(new VetorCalculoIntersec());
        System.out.println("interseção: " + Arrays.toString(intersec));
        
        Integer [] uniao = meusVetores.calculaVetor(new VetorCalculoUniao());
        System.out.println("união: " + Arrays.toString(uniao));

        Integer[] diferenca = meusVetores.calculaVetor(new VetorCalculoDiferenca());
        System.out.println("diferença: " + Arrays.toString(diferenca));


    }
}
