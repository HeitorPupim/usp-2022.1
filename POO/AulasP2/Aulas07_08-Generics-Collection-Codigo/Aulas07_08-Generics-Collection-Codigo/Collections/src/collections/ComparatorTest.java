/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

import java.util.Comparator;

/**
 *
 * @author Junio
 */
public class ComparatorTest implements Comparator{
    public int compare(Object o1, Object o2) {
        return -((ClienteDoBanco)o1).GetNome().compareTo(((ClienteDoBanco)o2).GetNome());
    }

}
