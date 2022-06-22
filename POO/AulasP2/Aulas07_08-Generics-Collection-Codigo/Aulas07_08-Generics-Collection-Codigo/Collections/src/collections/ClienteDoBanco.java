/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

/**
 *
 * @author Junio
 */
class ClienteDoBanco implements Comparable{

    private final String sNome;

    ClienteDoBanco(String sANome) {
        sNome = sANome;
        Object o;
    }
    String GetNome(){
        return sNome;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Comparing elements");
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ClienteDoBanco other = (ClienteDoBanco) obj;
        return (this.GetNome().compareTo(other.GetNome()) == 0);
    }

    @Override
    public int hashCode() {
        /*Solução apenas para teste, pois isto transforma o hash em uma lista.
          É necessária uma função mais elaborada.*/        
        return sNome.hashCode();
    }

    public int compareTo(Object o) {
        ClienteDoBanco other = (ClienteDoBanco) o;
        return this.GetNome().compareTo(other.GetNome());
    }

}
