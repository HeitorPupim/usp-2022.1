import java.util.ArrayList;
import java.util.List;

public class VetorCalculoDiferenca implements VetorCalculo{

    @Override
    public Integer[] PerformCalculus(Vetor vetor) {
        
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            if (vetor.conjunto1[i] != vetor.conjunto2[i]){
                list.add(vetor.conjunto1[i]);
                list.add(vetor.conjunto2[i]);
            }
        }
        
        Integer[] diferenca = {};
        diferenca = list.toArray(diferenca);

        return diferenca;
    }

}