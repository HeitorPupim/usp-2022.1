package game.characters.attributes;

public class SuperPoder {
	
	private String nome;
	private int categoria;
	
	//construtor completo
	public SuperPoder(String nome,int categoria ) {
		this.nome = nome;
		this.categoria = categoria;
	}
	//construtor vazio:
	public SuperPoder() {
		}
	

	//getters and setters:
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	
}
