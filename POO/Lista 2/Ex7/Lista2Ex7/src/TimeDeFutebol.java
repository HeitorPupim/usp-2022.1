import java.lang.Math;

public class TimeDeFutebol implements Comparable<TimeDeFutebol> {
	
	String nomeDoTime;
	int nVitorias, nDerrotas, nEmpates, 
		nGMarcados, nGSofridos, nCVermelho,nCAmarelo,
		pontuacao;
	
	
	

	public TimeDeFutebol(String nomeDoTime, int nVitorias, int nEmpates, int nDerrotas,  int nGMarcados, int nGSofridos,
			 int nCVermelho, int nCAmarelo) {
		this.nomeDoTime = nomeDoTime;
		this.nVitorias = nVitorias;
		this.nEmpates = nEmpates;
		this.nDerrotas = nDerrotas;
		this.nGMarcados = nGMarcados;
		this.nGSofridos = nGSofridos;
		this.nCVermelho = nCVermelho;
		this.nCAmarelo = nCAmarelo;
		this.pontuacao = pontosDoTime();
	}

	public int pontosDoTime() {
		System.out.println("Pontuação final "+this.nomeDoTime +" :" + ((nVitorias* 3) + (nEmpates)));
		return (nVitorias* 3) + (nEmpates);
	}

	public int compareTo(TimeDeFutebol time){
		
		if (pontuacao == time.pontuacao){ //empate
			System.out.println("Empate!");
			// 1. comparando pelo numero de vitorias
			if (nVitorias < time.nVitorias) {
				return 9;
			}
			// 2. comparando saldo de gols
			else if ((nGMarcados - nGSofridos) < (time.nGMarcados - nGSofridos)){
				return 8;
			}
			// 3. comparando pelos gols marcados
			else if (nGMarcados < time.nGMarcados) {
				return 7;
			}
			// 4. comparando numero de Cartoes Vermelhos
			else if (nCVermelho < this.nCVermelho) {
				return 6;
			}
			// 5. comparando num. de Cartoes Amarelos
			else if (nCAmarelo < time.nCAmarelo){
				return 5;
			}
			// 6. Sorteando o time. 50% de chance de um sair na frente
			else {
				double rand = Math.random();
				if (rand > 0.5){
					return 4;
				}
				else return 3;
			}
		}
		else if(pontuacao < time.pontuacao) { //time na frente
			return 10;
		}
		else return -1; //time atrás
		
		
	}
}
