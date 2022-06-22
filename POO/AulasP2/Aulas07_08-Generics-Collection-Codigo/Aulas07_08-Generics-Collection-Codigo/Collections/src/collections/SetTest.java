/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Junio
 */
public class SetTest {

    public static void main(String args[]){
        /*Neste exemplo, cada uma das implementações imprimirá uma ordem diferente*/

        /*Ordem dos elementos imprevisível*/
        Set<ClienteDoBanco> sMeuSet = new HashSet<ClienteDoBanco>();
        /*Ordem dos elementos de acordo com a ordem de entrada*/
        //Set<ClienteDoBanco> sMeuSet = new LinkedHashSet<ClienteDoBanco>();
        /*Ordem pelo valor dos elementos de acordo com a interface Comparable*/
        //Set<ClienteDoBanco> sMeuSet = new TreeSet<ClienteDoBanco>();

        System.out.println(sMeuSet.add(new ClienteDoBanco("joao")));
        System.out.println(sMeuSet.add(new ClienteDoBanco("jose")));
        System.out.println(sMeuSet.add(new ClienteDoBanco("maria")));
        System.out.println(sMeuSet.add(new ClienteDoBanco("marcia")));
        System.out.println(sMeuSet.add(new ClienteDoBanco("jose")));
        System.out.println(sMeuSet.add(new ClienteDoBanco("claudia")));        

        System.out.println("------------------------------");
        	for(ClienteDoBanco o : sMeuSet)
            		System.out.println(o.GetNome());



//System.exit(0);
        
        /*Vamos criar outro conjunto*/
        Set<ClienteDoBanco> sMeuOutroSet = new HashSet<ClienteDoBanco>();
        sMeuOutroSet.add(new ClienteDoBanco("maria"));
        sMeuOutroSet.add(new ClienteDoBanco("Joaquim"));
        sMeuOutroSet.add(new ClienteDoBanco("Roberto"));
        System.out.println("------------------------------");
        	for(ClienteDoBanco o : sMeuOutroSet)
            		System.out.println(o.GetNome());        
        System.out.println("------------------------------");
        System.out.println("O conjunto sMeuOutroSet é subconjunto de sMeuSet: " +
                                           sMeuSet.containsAll(sMeuOutroSet));


        System.out.println("------------------------------");
        Set<ClienteDoBanco> sUnion = new HashSet<ClienteDoBanco>();
        sUnion.addAll(sMeuSet);
        sUnion.addAll(sMeuOutroSet);
        System.out.println("A união entre sMeuSet e sMeuOutroSet é: ");
        for(ClienteDoBanco o : sUnion)
            System.out.println(o.GetNome());



        System.out.println("------------------------------");
        sMeuSet.retainAll(sMeuOutroSet);

        System.out.println("A intersecção entre sMeuSet e sMeuOutroSet é: ");
        for(ClienteDoBanco o : sMeuSet)
            System.out.println(o.GetNome());
    }
}
