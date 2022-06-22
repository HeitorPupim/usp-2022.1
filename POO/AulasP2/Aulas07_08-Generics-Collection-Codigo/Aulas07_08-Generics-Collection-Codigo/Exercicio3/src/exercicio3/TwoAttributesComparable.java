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
public class TwoAttributesComparable implements Comparable {

    int iValue;
    String sValue;

    public TwoAttributesComparable(int iAValue, String sAValue) {
        iValue = iAValue;
        sValue = sAValue;
    }

    @Override
    public String toString() {
        return new Integer(iValue).toString() + ":" + sValue;
    }

    @Override
    public int compareTo(Object o) {
        TwoAttributesComparable t = (TwoAttributesComparable) o;

        if (this.iValue >= t.iValue) {
            if(this.sValue.compareTo(t.sValue) < 0){
                return 1;
            }else{
                return -1;
            }                
        } else {
            if(this.sValue.compareTo(t.sValue) > 0){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
