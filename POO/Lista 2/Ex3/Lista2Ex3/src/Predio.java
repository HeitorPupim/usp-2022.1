
abstract class Predio implements PegadaDeCarbono {

	int qtdePessoas, qtdeAndares = 1;

	
	public Predio(int qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}

	public Predio(int qtdeMoradores, int qtdeAndares) {
		this.qtdePessoas = qtdeMoradores;
		this.qtdeAndares = qtdeAndares;
	}
	
	public void tamanhoDoPredio() {
		System.out.println("O prédio possui " + this.qtdeAndares + " andares!");
	}
	@Override
	public int getPegadaDeCarbono(){
		return this.qtdeAndares*5 + this.qtdePessoas*10;
	}	
	
	
}
