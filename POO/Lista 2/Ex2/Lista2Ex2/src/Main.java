import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Produto> p = new ArrayList<Produto>();
		
		p.add(new Mouse("Saida USB, 1.800 dpi"));
		p.add(new Livro("Memorias Postumas de Bas Cubas"));
		p.add(new Livro("Dom Casmurro"));
		p.add(new Mouse("Razer Basilisk V3"));
		p.add(new Livro("Senhora"));

		for (int i = 0; i < p.size(); i++) {
			
			System.out.println(p.get(i).getDescricao());
		}
	}

}
