/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bridge;

/**
 *
 * @author Junio
 */
public class Circle {
    //atributos
    private float fRadius;

    //construtor com o atributo
    Circle(float fARadius){
        fRadius = fARadius;
    }

    //get
    public float getRadius() {
        return fRadius;
    }

    //func. que utiliza circle Function.
    public float CalculeAlgumaCoisaAMeuRespeito(CircleFunction cfAFunctio){
        return cfAFunctio.PerformCalculus(this);
    }

}
