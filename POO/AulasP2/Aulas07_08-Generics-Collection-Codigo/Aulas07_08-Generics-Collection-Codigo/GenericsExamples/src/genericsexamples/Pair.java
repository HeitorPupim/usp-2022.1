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
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
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
            Pair<T> otherPair = (Pair<T>)otherObject;
            return ((this.first.equals(otherPair.first)) &&
                    (this.second.equals(otherPair.second)));
        }
    }

    public static void main(String args[]){
        Pair<String> meuPar = new Pair<String>("joao","jose");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite duas palavras:");
        String palavra1 = teclado.next();
        String palavra2 = teclado.next();

        Pair<String> outroPar = new Pair<String>(palavra1,palavra2);
        if(outroPar.equals(meuPar)){
            System.out.println("Os pares são iguais");
        }else{
            System.out.println("Os pares são diferentes");
            System.out.println(meuPar);
            System.out.println(outroPar);
        }

    }
}
