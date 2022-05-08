import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
	ArrayList<PegadaDeCarbono> pCarb = new ArrayList<PegadaDeCarbono>();

	//Predio predio1 = new Predio(20, 3);
	//Predio predio2 = new Predio(192, 15);
	Casa casa1 = new Casa(3);
	Casa casa2 = new Casa(4);
	Escola escola1 = new Escola(400, 2);
	Escola escola2 = new Escola(120);
	Bicicleta bike1 = new Bicicleta(18);
	Bicicleta bike2 = new Bicicleta(12);
	Carro carro1 = new Carro(1200);
	Carro carro2 = new Carro(1300);
	
	pCarb.add(casa1);
	pCarb.add(casa2);
	pCarb.add(escola1);
	pCarb.add(escola2);
	pCarb.add(bike1);
	pCarb.add(bike2);
	pCarb.add(carro1);
	pCarb.add(carro2);
	
	
	for (int i = 0; i < pCarb.size(); i++) {
	
		System.out.println("Pegada De Carbono do(a) "+
		pCarb.get(i).getClass()+  " = " + pCarb.get(i).getPegadaDeCarbono());
		
	}
	
	
	}

	// Quando modificada, a classe Predio abstrata não pode ser instanciada, 
	// ou seja, não podemos escrever new Predio(atributos)
	// no entanto, as classes herdeiras Casa e Escola, podem ser instanciadas normamente
	// pois herdam os atributos da classe pai Predio
}
