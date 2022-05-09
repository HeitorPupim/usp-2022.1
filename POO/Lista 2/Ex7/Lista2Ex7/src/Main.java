import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<TimeDeFutebol> times = new ArrayList<TimeDeFutebol>();
		
		//time campeao
		//time:"nome",Vitoria, Empate, Derrota,GPro, GContra, Verm, Amare.
		times.add(new TimeDeFutebol("Sao Paulo", 8, 3, 4, 28, 15, 3, 2));
		//time perdedor
		times.add(new TimeDeFutebol("Linense", 1, 3, 5, 29, 15, 3, 2));
		//time mediano
		times.add(new TimeDeFutebol("Palmeiras", 8, 3, 5, 27, 15, 3, 2));
		Collections.sort(times); 
		
		for(TimeDeFutebol time:times) {
			
			System.out.println(time.nomeDoTime + " " + time.pontuacao);
		}
		
	}

}
