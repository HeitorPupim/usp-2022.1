import java.util.Arrays;
import java.util.HashSet;

public class VetorCalculoUniao implements VetorCalculo {

    
    public Integer[] PerformCalculus(Vetor vetor) {
        
        HashSet<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(vetor.conjunto1));
        set.addAll(Arrays.asList(vetor.conjunto2));
        Integer[] uniao = {};
        uniao = set.toArray(uniao);

        return uniao;
    }
    
}
