
public abstract class CafeDecorator extends Cafe{
    
    //aqui pegamos a classe abstrata, que é a classe que estamos decorando
    Cafe cCafeASerDecorado;

    //construtor simples, que vai receber o objeto a ser decorado
    protected CafeDecorator(Cafe cACafeASerDecorado){
        this.cCafeASerDecorado = cACafeASerDecorado;
    }
}