
public class Main {

	public static void main(String[] args) {
		
		Mouse mouseMultilaser = new Mouse();
		Teclado tecladoLogitik = new Teclado();
		
		tecladoLogitik.ligar();
		mouseMultilaser.ligar();
		tecladoLogitik.calibrar();
		mouseMultilaser.calibrar();
		tecladoLogitik.checarStatus();
		mouseMultilaser.checarStatus();
		tecladoLogitik.desligar();
		mouseMultilaser.desligar();
	}

}
