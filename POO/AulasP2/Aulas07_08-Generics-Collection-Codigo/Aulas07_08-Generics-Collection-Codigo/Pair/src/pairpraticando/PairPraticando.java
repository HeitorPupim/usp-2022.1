package pairpraticando;

/**
 *
 * @author junio
 */
public class PairPraticando<F, G> {

    private F dado1;
    private G dado2;

    public F getDado1() {
        return dado1;
    }

    public G getDado2() {
        return dado2;
    }

    public void setDado1(F dado1) {
        this.dado1 = dado1;
    }

    public void setDado2(G dado2) {
        this.dado2 = dado2;
    }

    public String toString() {
        return "Primeiro: " + this.dado1.toString() + "-"
                + "Segundo: " + this.dado2.toString();
    }

    public boolean equals(PairPraticando<F, G> umPar) {
        if (umPar == null) {
            return false;
        } else if (this.dado1.getClass() != umPar.dado1.getClass()
                || this.dado2.getClass() != umPar.dado2.getClass()) {
            return false;
        } else {
            return (this.dado1.equals(umPar.dado1)
                    && this.dado2.equals(umPar.dado2));
        }
    }

    public static void main(String[] args) {
        PairPraticando<String, Double> p1 = new PairPraticando<String, Double>();
        p1.setDado1("Steve");
        p1.setDado2(50d);

        PairPraticando<String, Integer> p2 = new PairPraticando<String, Integer>();
        p2.setDado1("Steve");
        p2.setDado2(50);

        if (p1.equals(p2))
            System.out.println("São iguais");        
        else 
            System.out.println("São diferentes");        
    }
}
