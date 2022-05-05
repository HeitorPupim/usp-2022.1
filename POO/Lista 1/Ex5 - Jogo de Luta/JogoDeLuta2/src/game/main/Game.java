package game.main;

import java.util.Locale;
import java.util.Scanner;

import game.characters.SuperHeroi;
import game.characters.Vilao;
import game.characters.attributes.SuperPoder;


//main class.
public class Game {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		System.out.println("Bem vido ao Jogo de Luta!");
		System.out.println("--------------------------------------");
		System.out.println("Regras:\nJogador 1 --> Heroi ");
		System.out.println("Jogador 2 --> Vil�o");
		System.out.println("--------------------------------------\n\n");
		
		//configurando o her�i!
		
		//alocando espaco pra um heroi :
		SuperHeroi heroi = new SuperHeroi();
		
		
		//registrando atributos do heroi:
		System.out.println("Insira o nome do Jogador 1: ");
		
		heroi.setPersonagemNomeVidaReal(sc.nextLine());
		
		
		System.out.println("Bem vindo(a) "+ heroi.getPersonagemNomeVidaReal() + " !");
		
		System.out.println("Insira o nome do seu SuperHeroi: ");
		heroi.setPersonagemNome(sc.nextLine());
		
		System.out.println("Configurando o SuperHeroi '"+ heroi.getPersonagemNome() +"'.....\n");
		
		System.out.println(heroi.getPersonagemNomeVidaReal() +", insira a quantidade de poderes que seu her�i " + heroi.getPersonagemNome() +" ter�: (inteiro)");
		heroi.setQtdeSuperPoderes(sc.nextInt());
		sc.nextLine(); //quebra de linha!
		
		
		//alocando os poderes do super her�i
		System.out.println("O Heroi " + heroi.getPersonagemNome() + " ter� "+ heroi.getQtdeSuperPoderes() + " superpodere(s)!");
		
		for (int i = 0; i < heroi.getQtdeSuperPoderes(); i++) {
			
			//criando um "superpoder"
			SuperPoder superpoder = new SuperPoder();
			
			System.out.println("Insira o Nome do Super Poder " + (i+1) + " :");
			superpoder.setNome(sc.nextLine());
			
			System.out.println("Insira a categoria (DMG) do SuperPoder '" + superpoder.getNome() + "' :");
			superpoder.setCategoria(sc.nextInt());
			sc.nextLine();
		
			//colocando o superpoder no vetor de superpoderes do her�i:
			heroi.setSuperpoder(i, superpoder);
			superpoder = null; //limpando mem�ria;
		}
		
		//Cria��o do her�i finalizada.
		
		System.out.println("\n\n"); //quebra de linha 2x;
		
		//criando um vilao: 
		Vilao vilao = new Vilao();
		//registrando atributos do vilao:
		
		System.out.println("Insira o nome do Jogador 2: ");
		vilao.setPersonagemNomeVidaReal(sc.nextLine());
		
		System.out.println("Bem vindo(a) "+ vilao.getPersonagemNomeVidaReal() + " !");
		System.out.println("Insira o nome do seu Vilao: ");
		vilao.setPersonagemNome(sc.nextLine());
		System.out.println("Configurando o Vilao '"+ vilao.getPersonagemNome() +"'.....\n");
		System.out.println("Quantos anos o vilao " +vilao.getPersonagemNome() +" passou na cadeia?");
		vilao.setAnosDePrisao(sc.nextInt());
		sc.nextLine();
		System.out.println(vilao.getPersonagemNomeVidaReal() +", insira a quantidade de poderes que seu vil�o " + vilao.getPersonagemNome() +" ter�: (inteiro)");
		vilao.setQtdeSuperPoderes(sc.nextInt());
		sc.nextLine(); //quebra de linha!

		//alocando os poderes do  vil�o
		System.out.println("O Vilao " + vilao.getPersonagemNome() + " ter� "+ vilao.getQtdeSuperPoderes() + " superpodere(s)!");
		
		for (int i = 0; i < vilao.getQtdeSuperPoderes(); i++) {
			
			//criando um "superpoder"
			SuperPoder superpoder = new SuperPoder();
			
			System.out.println("Insira o Nome do Super Poder " + (i+1) + " :");
			superpoder.setNome(sc.nextLine());
			
			System.out.println("Insira a categoria (DMG) do SuperPoder '" + superpoder.getNome() + "' :");
			superpoder.setCategoria(sc.nextInt());
			sc.nextLine();
		
			//colocando o superpoder no vetor de superpoderes do her�i:
			vilao.setSuperpoder(i, superpoder);
			superpoder = null; //limpando mem�ria;
		}	
		//criacao do vilao finalizada;
		
		//atacando o vilao:
		//enquanto a vida do vilao for positiva, vamos atacar
		
		int roundNumber = 1;
		while ((vilao.getVida() >= 0) && (heroi.getVida() >=0 )) {
			System.out.println("-------------ROUND "+ (roundNumber++) +"------------\n");
			System.out.println("-------------PLAYER1-------------\n");
			
			//primeiro a atacar � o her�i:
			System.out.println(heroi.getPersonagemNomeVidaReal()+": Ataque o Vilao " + vilao.getPersonagemNome());
			System.out.println("HP do vilao = " + vilao.getVida() + "\n");
			
			
			System.out.println("Atacando o vilao...");
			System.out.println("Super Heroi '" + heroi.getPersonagemNome() + "' qual ataque deseja utilizar?");
			
			//escolhendo o poder do heroi para atacar
			for (int i = 0; i < heroi.getQtdeSuperPoderes(); i++) {
				System.out.println("Insira "+ i + " para escolher o poder: " + heroi.superpoderVector[i].getNome() + " --- DMG: " + heroi.superpoderVector[i].getCategoria());
			}
			
			int poderEscolhido = sc.nextInt();
			sc.nextLine();
			System.out.println("Escolha a intensidade do ataque do poder '" +heroi.superpoderVector[poderEscolhido].getNome()+ "'");
			int intensidadeAtaque = sc.nextInt();
			
			sc.nextLine();
			heroi.ataquePersonagem(vilao, intensidadeAtaque, heroi.superpoderVector[poderEscolhido]);
			System.out.println("HP do vilao apas o ataque = " + vilao.getVida());
			
			
			System.out.println("-----------------------------------------\n");
			
			//verificando se a vida do vil�o ainda est� cheia:
			//se estiver menor ou igual a zero, o player 1 ganhou!
			if (vilao.getVida() <= 0 ) {
				System.out.println("Vitoria do SuperHeroi "
						+ heroi.getPersonagemNome()
						+ "Parabens, "
						+ heroi.getPersonagemNomeVidaReal());
				System.out.println("-----------------------------------------\n");
				System.out.println("-----------------------------------------\n");
				break; //finaliza os ataques!
			}
			System.out.println("-------------PLAYER2-------------\n");
			
			//agora o vilao ataca:
			System.out.println(vilao.getPersonagemNomeVidaReal()+": Ataque o Heroi " + heroi.getPersonagemNome());
			System.out.println("HP do Heroi = " + heroi.getVida() + "\n");
			
			System.out.println("Atacando o heroi...");
			System.out.println("Vilao '" + vilao.getPersonagemNome() + "' qual ataque deseja utilizar?");
			
			//escolhendo o poder do heroi para atacar
			for (int i = 0; i < vilao.getQtdeSuperPoderes(); i++) {
				System.out.println("Insira "+ i + " para escolher o poder: " + vilao.superpoderVector[i].getNome() + " --- DMG: " + vilao.superpoderVector[i].getCategoria());
			}
			
			poderEscolhido = sc.nextInt();
			sc.nextLine();
			System.out.println("Escolha a intensidade do ataque do poder '" +vilao.superpoderVector[poderEscolhido].getNome()+ "'");
			intensidadeAtaque = sc.nextInt();
			
			sc.nextLine();
			vilao.ataquePersonagem(heroi, intensidadeAtaque, vilao.superpoderVector[poderEscolhido]);
			System.out.println("HP do Heroi ap�s o ataque = " + heroi.getVida());
			
			if (heroi.getVida() <= 0 ) {
				System.out.println("Vitoria do Vilao "
						+ vilao.getPersonagemNome()
						+ "Parabens, "
						+ vilao.getPersonagemNomeVidaReal());
				System.out.println("-----------------------------------------\n");
				break; //finaliza os ataques!
			}
			
			System.out.println("-----------------------------------------\n");
		}
		
		//printa o fim do jogo.
		System.out.println("--------- FIM DO JOGO ---------------");
		sc.close();

	}//WHILE 

}
