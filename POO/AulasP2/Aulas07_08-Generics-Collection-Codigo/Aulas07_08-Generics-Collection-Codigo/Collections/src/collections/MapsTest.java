/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Junio
 */
public class MapsTest {

    public static void main(String args[]){
        //Map<String,String> mMeuMapa = new HashMap<String,String>();
        //Map<String,String> mMeuMapa = new LinkedHashMap<String,String>();
        Map<String,String> mMeuMapa = new TreeMap<String,String>();
        mMeuMapa.put("Joao","Sao Carlos");
        mMeuMapa.put("Fabio","Araraquara");
        mMeuMapa.put("Ricardo","Ibate");
        mMeuMapa.put("Valter","Ibate");
        mMeuMapa.put("Leandro","Ibate");
        
        System.out.println("------------------------------------------");
        Set<String> sConjuntoDeChaves = mMeuMapa.keySet();
        System.out.print("As chaves são: ");
        for(String o: sConjuntoDeChaves)
            System.out.print(o + ", ");
        System.out.println("");

        System.out.println("------------------------------------------");
        Collection<String> sConjuntoDeValores = mMeuMapa.values();
        System.out.print("Os valores são: ");
        for(String o: sConjuntoDeValores)
            System.out.print(o + ", ");
        System.out.println("");
        
        System.out.println("------------------------------------------");
        for(String o: sConjuntoDeChaves)
            System.out.println(o + " mora em " + mMeuMapa.get(o));


    }
}
