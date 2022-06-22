/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Junio
 */
public class ListTest {
    public static void main(String args[]){
        //List<ClienteDoBanco> lFilaDoCaixa = new ArrayList<ClienteDoBanco>();
        List<ClienteDoBanco> lFilaDoCaixa = new LinkedList<ClienteDoBanco>();
        ClienteDoBanco cbMarco = new ClienteDoBanco("Marco");        
        lFilaDoCaixa.add(cbMarco);
        ClienteDoBanco cbJoao = new ClienteDoBanco("Joao");        
        lFilaDoCaixa.add(cbJoao);
        ClienteDoBanco cbRicardo = new ClienteDoBanco("Ricardo");        
        lFilaDoCaixa.add(cbRicardo);
        ClienteDoBanco cbBruno = new ClienteDoBanco("Bruno");
        lFilaDoCaixa.add(cbBruno);

        if(lFilaDoCaixa.contains(cbBruno))
            System.out.println(cbBruno.GetNome() + " está na fila.");

        /*Maneira correta, usada para o código que efetivamente usa a fila*/
        System.out.println("-----------------Varredura com iteradores---------------------");

        Iterator<ClienteDoBanco> itCliente = lFilaDoCaixa.iterator();
        ClienteDoBanco cTemp = null;
        while(itCliente.hasNext()){
            cTemp = (ClienteDoBanco)itCliente.next();
            System.out.println("+"+cTemp.GetNome());
        }

        
        /*-------------------Varrendo o conteúdo da Fila----------------------*/
        /*Maneira errada, usada apenas para passar o conteúdo da fila
         para métodos de outras classes que requerem um array*/
        System.out.println("---------Varredura com cópia em um array auxiliar-------------");
        ClienteDoBanco[] arrayDeClientes = lFilaDoCaixa.toArray(new ClienteDoBanco[lFilaDoCaixa.size()]);
        for(int i = 0; i < arrayDeClientes.length; i++)
            System.out.println("-"+arrayDeClientes[i].GetNome());


        System.out.println("-----------------Varredura mais simples de todas---------------------");
        /*Maneira correta, usada para o código que efetivamente usa a fila
          Semelhante à opção anterior que usa iterador*/
        for(ClienteDoBanco o : lFilaDoCaixa)
            System.out.println("*" + o.GetNome());

        
        System.out.println("-----------------Ordenação---------------------");
        Collections.sort(lFilaDoCaixa);
        for(ClienteDoBanco o : lFilaDoCaixa)
            System.out.println("*" + o.GetNome());
        
        System.out.println("------Ordenação invertida com comparator-------");
        Collections.sort(lFilaDoCaixa, new ComparatorTest());
        for(ClienteDoBanco o : lFilaDoCaixa)
            System.out.println("*" + o.GetNome());
        System.exit(0);        
    }
}
