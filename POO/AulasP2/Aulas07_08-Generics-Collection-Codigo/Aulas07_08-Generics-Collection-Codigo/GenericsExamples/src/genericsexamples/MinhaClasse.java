/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genericsexamples;

/**
 *
 * @author junio
 */
public class MinhaClasse implements Comparable{
    int iValue;
    public MinhaClasse(int iAValue){
        iValue = iAValue;
    }
    public String toString(){
        return new Integer(iValue).toString();
    }
    public int compareTo(Object o){
        if(this.iValue <= ((MinhaClasse)o).iValue)
            return 1;
        else return -1;
    }
}