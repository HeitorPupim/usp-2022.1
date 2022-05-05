package game.characters;

import java.util.Arrays;

public class Vilao extends Personagem {
	//anos de prisão incrementa a vida do vilão. Quanto mais anos de prisão, mais HP terá o vilão.
	private int anosDePrisao; 
	
	
	//criar ataque:
	
	//construtor vazio:
	public Vilao() {
		super();
	}
	
	//simple constructor
	public Vilao(String nomeVidaRealVilao) {
		super(nomeVidaRealVilao);
	}
	
	//constructor
	public Vilao(String nomeVilao, String nomeVidaRealVilao, int qtdeSuperPoderesVilao, int anosDePrisaoVilao) {
		super(nomeVilao, nomeVidaRealVilao, qtdeSuperPoderesVilao);
		this.anosDePrisao = anosDePrisaoVilao;
		//anos de prisão é um atributo que deixa o vilão mais forte, logo, vamos incrementar a vida.
		super.vida += anosDePrisaoVilao;
	}
	
	//getters and setters: 
	public int getAnosDePrisao() {
		return anosDePrisao;
	}

	public void setAnosDePrisao(int anosDePrisao) {
		this.anosDePrisao = anosDePrisao;
		super.vida += anosDePrisao; //incrementando a vida do vilão;
	}

	@Override
	public String toString() {
		return "Vilao [anosDePrisao=" + anosDePrisao + ", personagemNome=" + personagemNome
				+ ", personagemNomeVidaReal=" + personagemNomeVidaReal + ", qtdeSuperPoderes=" + qtdeSuperPoderes
				+ ", vida=" + vida + ", superpoderVector=" + Arrays.toString(superpoderVector) + "]";
	}
	
	
}

	
