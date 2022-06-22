package bridge;

// no decorator é uma abstract class, no bridge é uma interface.
public interface CircleFunction {
    //metodo da interface q passa como parâmetro o objeto q vamos calcular
    public abstract float PerformCalculus(Circle fACircle);
}
