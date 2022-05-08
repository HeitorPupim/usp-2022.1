
public class Bicicleta implements PegadaDeCarbono {

	int aroDaBike;
	
	public void empinaBike() {
		System.out.println(":hang loose: empinando a bike!");
	}
	public Bicicleta(int aroDaBike) {
		this.aroDaBike = aroDaBike;
	}
	public int getPegadaDeCarbono() {
		return aroDaBike*0;	
	}
	
	}
