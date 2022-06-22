
package bridge;

public class CircleFunctionArea implements CircleFunction{
    // implementa a interface e fala oq tem q retornar

    public float PerformCalculus(Circle fACircle) {
        //faz a conta
        return (float) (Math.PI * Math.pow(fACircle.getRadius(), 2));
    }

}
