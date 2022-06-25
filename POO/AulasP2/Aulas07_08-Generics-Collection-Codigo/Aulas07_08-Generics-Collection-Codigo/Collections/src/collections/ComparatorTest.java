package collections;

import java.util.Comparator;

public class ComparatorTest implements Comparator{
    public int compare(Object o1, Object o2) {
        return -((ClienteDoBanco)o1).GetNome().compareTo(((ClienteDoBanco)o2).GetNome());
    }

}
