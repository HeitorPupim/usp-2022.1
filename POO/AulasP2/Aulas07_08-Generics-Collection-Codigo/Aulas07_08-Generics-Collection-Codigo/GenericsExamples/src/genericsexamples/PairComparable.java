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
public class PairComparable<T extends Comparable> {

    private T first;
    private T second;

    public PairComparable() {
        first = null;
        second = null;
    }

    public PairComparable(T first, T second) {
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
            PairComparable<T> otherPair = (PairComparable<T>)otherObject;
            return ((this.first.equals(otherPair.first)) &&
                    (this.second.equals(otherPair.second)));
        }
    }
    public T GetMax(){
        if(first.compareTo(second) >= 0)
            return first;
        return second;
    }

    public <U> void MetodoGenerico(U a){
        System.out.println(a.toString());
    }
    
    public static void main(String args[]){
        PairComparable<MinhaClasse> meuPar = new PairComparable<MinhaClasse>(new MinhaClasse(20),new MinhaClasse(25));
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite duas palavras:");
        int palavra1 = teclado.nextInt();
        int palavra2 = teclado.nextInt();

        PairComparable<MinhaClasse> outroPar = new PairComparable<MinhaClasse>(new MinhaClasse(palavra1),new MinhaClasse(palavra2));

        if(outroPar.equals(meuPar)){
            System.out.println("Os pares são iguais");
        }else{
            System.out.println("Os pares são diferentes");
            System.out.println(meuPar);
            System.out.println(outroPar);
        }

        System.out.println("O maior valor digitado é: " + outroPar.GetMax());
        outroPar.<Double>MetodoGenerico(new Double(2.3));
    }
}
