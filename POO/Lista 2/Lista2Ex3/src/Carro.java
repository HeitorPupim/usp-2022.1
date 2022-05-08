
public class Carro implements PegadaDeCarbono{

	int potenciaCarro;

	public Carro(int potenciaCarro) {
		this.potenciaCarro = potenciaCarro;
	}
	
	public void freiaCarro() {
		System.out.println("PRrRrRrR... Freiando o carro !");
	}
	
	@Override
	public int getPegadaDeCarbono() {
		return potenciaCarro*500;
		
	}
}
