/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio3;

import java.util.Random;

/**
 *
 * @author junio
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //ArrayCompare array[] = new ArrayCompare[10];
         Random rand = new Random();
         Integer[] arrayDeInt = new Integer[10];
         for(int j=0; j<arrayDeInt.length; j++){
             arrayDeInt[j] = new Integer(rand.nextInt(1000));
             System.out.println("\t"+arrayDeInt[j].toString());             
         }
         (new InsertionSortGenerico()).<Integer>sort(arrayDeInt);
         System.out.println("--------------------------");
         for(int j=0; j<arrayDeInt.length; j++){             
             System.out.println("\t"+arrayDeInt[j].toString());
         }
         
         System.out.println("--------------------------");         
         Float[] arrayDeFloat = new Float[10];
         for(int j=0; j<arrayDeFloat.length; j++){
             arrayDeFloat[j] = new Float(rand.nextFloat());
             System.out.println("\t"+arrayDeFloat[j].toString());             
         } 
         (new InsertionSortGenerico()).<Float>sort(arrayDeFloat);
         System.out.println("--------------------------");
         for(int j=0; j<arrayDeFloat.length; j++){             
             System.out.println("\t"+arrayDeFloat[j].toString());
         }
         
         System.out.println("--------------------------");         
         TwoAttributesComparable[] arrayTwo = new TwoAttributesComparable[10];
         for(int j=0; j<arrayTwo.length; j++){
             arrayTwo[j] = new TwoAttributesComparable(rand.nextInt(),new Long(rand.nextLong()).toString());
             System.out.println("\t"+arrayTwo[j].toString());             
         } 
         (new InsertionSortGenerico()).<TwoAttributesComparable>sort(arrayTwo);
         System.out.println("--------------------------");
         for(int j=0; j<arrayTwo.length; j++){             
             System.out.println("\t"+arrayTwo[j].toString());
         }               

         
    }
    
}
