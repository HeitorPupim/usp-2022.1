/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio3;

/**
 *
 * @author junio
 */
public class InsertionSortGenerico <TIPO extends Comparable> {
    public void sort(TIPO[] array){
        int i, j;
        for(j=1; j<array.length; j++){
            TIPO temp = array[j];
            i = j - 1;
            while(i >= 0 && (array[i].compareTo(temp) <= 0)){
               array[i+1] = array[i];
               i--;
            }
            array[i + 1] = temp;
        }        
    }
}
