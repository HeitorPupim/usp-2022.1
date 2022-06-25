public class Vetor {
    Integer[] conjunto1 = new Integer[3];
    Integer[] conjunto2 = new Integer[3];

    //construtor com o atributo.
    public Vetor(Integer[] conjunto1, Integer[] conjunto2) {
        this.conjunto1 = conjunto1;
        this.conjunto2 = conjunto2;
    }

    public Integer[] getConjunto1() {
        return conjunto1;
    }

    public Integer[] getConjunto2(){
        return conjunto2;
    }

    //função que vai utilizar o bridge para calcular o vetor.
    public Integer[] calculaVetor(VetorCalculo calculo) {
        return calculo.PerformCalculus(this);
    }

}