package game.characters;

import java.util.Random;

import game.characters.attributes.SuperPoder;

public class Personagem {
	protected String personagemNome, personagemNomeVidaReal;
	protected int qtdeSuperPoderes;
	protected int vida = 100; //HP do personagem.
	public SuperPoder[] superpoderVector;
	
	//construtor vazio:
	public Personagem(){
		super();
	}
	
	//construtor simples.
	public Personagem(String personagemNomeVidaReal) {
		this.personagemNomeVidaReal = personagemNomeVidaReal;
	}
	
	//construtor completo:
	public Personagem(String personagemNome, String personagemNomeVidaReal, int qtdeSuperPoderes) {
		this.personagemNome = personagemNome;
		this.personagemNomeVidaReal = personagemNomeVidaReal;
		this.qtdeSuperPoderes = qtdeSuperPoderes;
		this.superpoderVector = new SuperPoder[qtdeSuperPoderes];
	}

	//getters and setters.
	public int getQtdeSuperPoderes() {
		return qtdeSuperPoderes;
	}


	public void setQtdeSuperPoderes(int qtdeSuperPoderes) {
		this.qtdeSuperPoderes = qtdeSuperPoderes;
		this.superpoderVector = new SuperPoder[qtdeSuperPoderes];
	}


	public SuperPoder[] getSuperpoder() {
		return superpoderVector;
	}


	public void setSuperpoder(int index, SuperPoder superpoder) {
		this.superpoderVector[index] = superpoder;
	}

	public String getPersonagemNome() {
		return personagemNome;
	}
	
	public void setPersonagemNome(String personagemNome) {
		this.personagemNome = personagemNome;
	}

	public String getPersonagemNomeVidaReal() {
		return personagemNomeVidaReal;
	}

	public void setPersonagemNomeVidaReal(String personagemNomeVidaReal) {
		this.personagemNomeVidaReal = personagemNomeVidaReal;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}	
	
	
	//ataque:
	public void ataquePersonagem(Personagem personagem, int intensidadeDoAtaque, SuperPoder superpoder){
		
		Random rand = new Random();
		double doubleRand =  rand.nextDouble();
		
		if (doubleRand >= 0.5) {//ataca
			int ataque = intensidadeDoAtaque*superpoder.getCategoria();
			personagem.vida -= ataque;
			System.out.println("Ataque com intensidade = " +intensidadeDoAtaque + " com multipliciadade de " + superpoder.getNome());
			System.out.println("Ataque total = " + intensidadeDoAtaque*superpoder.getCategoria());
		}
		else { //não ataca
			System.out.println(personagem.personagemNome + " defendeu seu ataque!!!\n");
		}
		
	}
	
	//toString
	
	
	
	
	
}
