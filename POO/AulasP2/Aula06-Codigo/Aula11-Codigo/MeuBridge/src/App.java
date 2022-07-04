public class App {
    public static void main(String[] args) throws Exception {
        
        Quadrado square = new Quadrado(10);

        double perim = square.QuadradoCalcular(new QuadradoPerimetro());

        System.out.println("Perimetro do quadrado = " + perim);

        double area = square.QuadradoCalcular(new QuadradoArea());
        
        System.out.println("Area do quadrado = " + area);
    }
}
