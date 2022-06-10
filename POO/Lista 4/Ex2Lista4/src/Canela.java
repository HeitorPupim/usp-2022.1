
public class Canela extends CafeDecorator{
    public Canela(Cafe cACafeASerDecorado) {
        super(cACafeASerDecorado);
    }
    public String getDescricao() {
        return cCafeASerDecorado.getDescricao() + " mais canela";
    }

    public float getPreco() {
        return cCafeASerDecorado.getPreco() + 0.2f;
    }
}
