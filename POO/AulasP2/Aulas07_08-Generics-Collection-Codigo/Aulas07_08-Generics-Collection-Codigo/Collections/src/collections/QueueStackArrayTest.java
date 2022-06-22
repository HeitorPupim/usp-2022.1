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
import java.util.Stack;

/**
 *
 * @author Junio
 */
public class QueueStackArrayTest {

    public static void main(String args[]) {
        ArrayDeque<ClienteDoBanco> dadosArrayDeque = new ArrayDeque<ClienteDoBanco>();

        dadosArrayDeque.add(new ClienteDoBanco("1-Marco"));
        dadosArrayDeque.add(new ClienteDoBanco("2-João"));
        dadosArrayDeque.add(new ClienteDoBanco("3-Ricardo"));
        dadosArrayDeque.add(new ClienteDoBanco("4-Bruno"));

        /*ArrayDeque usado como FIFO (fila)*/
        System.out.println("****************************************************");
        System.out.println("FIFO ArrayDeque - primeiro a entrar, primeiro a sair");
        System.out.println("---------------------");
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        dadosArrayDeque.remove();
        System.out.println("---------------------");
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        dadosArrayDeque.remove();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        dadosArrayDeque.remove();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        dadosArrayDeque.remove();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }

        System.out.println("---------------------");
        System.out.println("**************************************************");
        System.out.println("LIFO (pilha) ArrayDeque - último a entrar, primeiro a sair");

        dadosArrayDeque.push(new ClienteDoBanco("1-Marco"));
        dadosArrayDeque.push(new ClienteDoBanco("2-João"));
        dadosArrayDeque.push(new ClienteDoBanco("3-Ricardo"));
        dadosArrayDeque.push(new ClienteDoBanco("4-Bruno"));

        System.out.println("---------------------");
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        dadosArrayDeque.pop();
        System.out.println("---------------------");
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        dadosArrayDeque.pop();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        dadosArrayDeque.pop();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        dadosArrayDeque.pop();
        for (ClienteDoBanco o : dadosArrayDeque) {
            System.out.println("*" + o.GetNome());
        }
        System.out.println("---------------------");
        System.out.println("A documentação do Java recomenda usar a classe ArrayDeque como fila ou como pilha ao inves das classes LinkedList (como fila - add/remove) e Stack<E>");
    }
}
