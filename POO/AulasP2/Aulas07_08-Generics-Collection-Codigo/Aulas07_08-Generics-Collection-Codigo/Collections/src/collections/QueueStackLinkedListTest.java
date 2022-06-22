/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Junio
 */
public class QueueStackLinkedListTest {
    public static void main(String args[]){
        //LinkedList<ClienteDoBanco> dadosLinkedList = new LinkedList<ClienteDoBanco>();
        ArrayDeque<ClienteDoBanco> dadosLinkedList = new ArrayDeque<ClienteDoBanco>();
        dadosLinkedList.add(new ClienteDoBanco("1-Marco"));
        dadosLinkedList.add(new ClienteDoBanco("2-João"));
        dadosLinkedList.add(new ClienteDoBanco("3-Ricardo"));
        dadosLinkedList.add(new ClienteDoBanco("4-Bruno"));

        /*ArrayDeque usado como FIFO*/
        System.out.println("****************************************************");
        System.out.println("FIFO ArrayDeque - primeiro a entrar, primeiro a sair");
        System.out.println("---------------------");
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
    dadosLinkedList.remove();
        System.out.println("---------------------");
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    dadosLinkedList.remove();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    dadosLinkedList.remove();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
    dadosLinkedList.remove();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());

        System.out.println("---------------------");
        System.out.println("**************************************************");
        System.out.println("LIFO ArrayDeque - último a entrar, primeiro a sair");

        dadosLinkedList.push(new ClienteDoBanco("1-Marco"));
        dadosLinkedList.push(new ClienteDoBanco("2-João"));
        dadosLinkedList.push(new ClienteDoBanco("3-Ricardo"));
        dadosLinkedList.push(new ClienteDoBanco("4-Bruno"));

        System.out.println("---------------------");
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
    dadosLinkedList.pop();
        System.out.println("---------------------");
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    dadosLinkedList.pop();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    dadosLinkedList.pop();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    dadosLinkedList.pop();
        for(ClienteDoBanco o : dadosLinkedList)
            System.out.println("*" + o.GetNome());
        System.out.println("---------------------");
    }
}
