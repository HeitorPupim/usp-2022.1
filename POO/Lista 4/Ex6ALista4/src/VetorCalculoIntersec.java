public class VetorCalculoIntersec implements VetorCalculo {

    //implementa a interface e faz algo a mais...
    public Integer[] PerformCalculus(Vetor vetor) {
        Integer[] intersec = new Integer[3];
        
        for (int i = 0; i < 3; i++) {
            
            for (int j  = 0; j < 3; j++){
                if (vetor.conjunto1[i] == vetor.conjunto2[j]){
                    intersec[i] = vetor.conjunto1[i];
                }
            }
        }
        return intersec;
    }
    
    
}
