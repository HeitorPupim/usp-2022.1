package game.characters;

import game.characters.attributes.SuperPoder;

public class SuperHeroi extends Personagem {

	//construtor vazio de um Heroi:
	public SuperHeroi() {
		super();
	}
	
	//construtor simples do Heroi:
		public SuperHeroi(String nomeVidaRealHeroi) {
			super(nomeVidaRealHeroi);
		}
		
	
	//construtor completo do Super Heroi.
	public SuperHeroi(String nomeHeroi, String nomeVidaRealHeroi, int qtdeSuperPoderesHeroi) {
		super(nomeHeroi, nomeVidaRealHeroi, qtdeSuperPoderesHeroi);
		//cria um personagem com vida 100 e super poderes.
	}
	



}
