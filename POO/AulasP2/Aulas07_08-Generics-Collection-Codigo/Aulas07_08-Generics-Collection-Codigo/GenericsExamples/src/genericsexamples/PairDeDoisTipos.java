/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genericsexamples;

import java.util.Scanner;

/**
 *
 * @author junio
 */
public class PairDeDoisTipos<T1, T2> {

    private T1 first;
    private T2 second;

    public PairDeDoisTipos() {
        first = null;
        second = null;
    }

    public PairDeDoisTipos(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T1 newValue) {
        first = newValue;
    }

    public void setSecond(T2 newValue) {
        second = newValue;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public String toString(){
        return ("First: "+first.toString()+"\n Second: " + second.toString());
    }

    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(this.getClass() != otherObject.getClass()){
            return false;
        }else{
            PairDeDoisTipos<T1, T2> otherPair = (PairDeDoisTipos<T1, T2>)otherObject;
            return ((this.first.equals(otherPair.first)) &&
                    (this.second.equals(otherPair.second)));
        }
    }

    public static void main(String args[]){
        PairDeDoisTipos<String, Integer> meuPar = new PairDeDoisTipos<String, Integer>("joao",25);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite duas palavras:");
        String palavra1 = teclado.next();
        int palavra2 = teclado.nextInt();

        PairDeDoisTipos<String, Integer> outroPar = new PairDeDoisTipos<String, Integer>(palavra1,palavra2);
        if(outroPar.equals(meuPar)){
            System.out.println("Os pares são iguais");
        }else{
            System.out.println("Os pares são diferentes");
            System.out.println(meuPar);
            System.out.println(outroPar);
        }
    }
}