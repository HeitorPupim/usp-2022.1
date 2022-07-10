/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import Controler.Tela;
import Modelo.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Augusto
 */
public class Fases {
    public static int fase = 0;
    public static String backgroundImg;
    public static ArrayList<String> transicoes;
    
    public static void proximaFase(ArrayList<Elemento> eElementos) {
        if(fase == 0){
            Fases.criaTransicoes();
        }
        eElementos.clear();
        Fases.transicaoDeFase(eElementos, transicoes.get(fase));
        fase++;
    }
    
    public static void resetaFase(ArrayList<Elemento> eElementos){
        eElementos.clear();
        Fases.iniciaFase(fase, eElementos);
    }
    
    public static void gameOver(ArrayList<Elemento> eElementos) {
        eElementos.clear();
        backgroundImg = "gameOver.png";
        
        Hero dummyHero = new Hero("");
        eElementos.add(dummyHero);
        
        Tela.getTela().setEsperandoTecla(true);
        Tela.getTela().pausaMusica();

        /*Cria um timer pra que a primeira fase seja exibida em "delay" ms*/
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                fase = 0;
                Fases.proximaFase(eElementos);
            }
        }, 5000);
    }
    
    private static void iniciaFase(int numFase, ArrayList<Elemento> faseAtual){
        /*Eh possivel adicionar as fases num array ArrayList<Elemento>[] fases,
        mas por enquanto, com poucas fases, isso nao eh absolutamente necessario*/
        if(numFase == 1)
            faseAtual.addAll(primeiraFase());
        if(numFase == 2)
            faseAtual.addAll(segundaFase());
        if(numFase == 3)
            faseAtual.addAll(terceiraFase());
        if(numFase == 4)
            faseAtual.addAll(quartaFase());
    }
    
    private static void criaTransicoes(){
        transicoes = new ArrayList<>();
        transicoes.add("startMenu.png");
        transicoes.add("transicaoJacare.png");
        transicoes.add("transicaoICMC.png");
        transicoes.add("transicaoGoto.png");
        transicoes.add("youWin.png");
    }
    
    //Cria uma fase vazia e sem musica so com o background de transicao
    private static void transicaoDeFase(ArrayList<Elemento> eElementos, String telaTransicao){
        backgroundImg = telaTransicao;
        int delay;
        
        Hero dummyHero = new Hero("");
        eElementos.add(dummyHero);
        
        if(fase > 0){
            Tela.getTela().pausaMusica();
            Tela.getTela().setLoading(true);
            delay = 3000;
            
            if(fase == 4){
                delay += 5000;
            }

            /*Cria um timer para que a proxima fase seja exibida em "delay" ms*/
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                public void run(){
                    if(fase == 5){
                        System.exit(0);
                    }else{
                        eElementos.clear();
                        Fases.iniciaFase(fase, eElementos);
                        Tela.getTela().setLoading(false);
                        Tela.getTela().reiniciaFase();
                        Tela.getTela().playMusica();
                    }
                }
            }, delay);
        }
    }
    
    //Cada fase é composta de um array com elementos que é copiado para trocar
    private static ArrayList<Elemento> primeiraFase() {
        backgroundImg = "background1.png";

        ArrayList<Elemento> fase1 = new ArrayList<>();
        
        // HEROI
        Hero hHero = new Hero("skooter.png");
        hHero.setPosicao(4, 4);
        fase1.add(hHero);
        
        // ROBOS
        RoboRosa roboRosa1 = new RoboRosa("roboRosa.png", hHero);
        roboRosa1.setPosicao(10, 1);
        fase1.add(roboRosa1);

        RoboRosa roboRosa2 = new RoboRosa("roboRosa.png", hHero);
        roboRosa2.setPosicao(0, 9);
        fase1.add(roboRosa2);

        RoboAzul roboAzul = new RoboAzul("roboAzul.png", hHero);
        roboAzul.setPosicao(2, 0);
        fase1.add(roboAzul);

        RoboAmarelo roboAmarelo = new RoboAmarelo("roboAmarelo.png", hHero);
        roboAmarelo.setPosicao(10, 9);
        fase1.add(roboAmarelo);

        // BLOCOS ESTATICOS
        
        Bloco blocoImovel1 = BlocoFactory.criaBloco("vermelho");
        blocoImovel1.setPosicao(1, 1);
        fase1.add(blocoImovel1);

        Bloco blocoImovel2 = BlocoFactory.criaBloco("vermelho");
        blocoImovel2.setPosicao(1, 3);
        fase1.add(blocoImovel2);

        Bloco blocoImovel3 = BlocoFactory.criaBloco("vermelho");
        blocoImovel3.setPosicao(1, 5);
        fase1.add(blocoImovel3);

        Bloco blocoImovel4 = BlocoFactory.criaBloco("vermelho");
        blocoImovel4.setPosicao(1, 7);
        fase1.add(blocoImovel4);

        Bloco blocoImovel5 = BlocoFactory.criaBloco("vermelho");
        blocoImovel5.setPosicao(1, 9);
        fase1.add(blocoImovel5);

        Bloco blocoImovel6 = BlocoFactory.criaBloco("vermelho");
        blocoImovel6.setPosicao(3, 1);
        fase1.add(blocoImovel6);

        Bloco blocoImovel7 = BlocoFactory.criaBloco("vermelho");
        blocoImovel7.setPosicao(3, 3);
        fase1.add(blocoImovel7);

        Bloco blocoImovel8 = BlocoFactory.criaBloco("vermelho");
        blocoImovel8.setPosicao(3, 5);
        fase1.add(blocoImovel8);

        Bloco blocoImovel9 = BlocoFactory.criaBloco("vermelho");
        blocoImovel9.setPosicao(3, 7);
        fase1.add(blocoImovel9);

        Bloco blocoImovel10 = BlocoFactory.criaBloco("vermelho");
        blocoImovel10.setPosicao(3, 9);
        fase1.add(blocoImovel10);

        Bloco blocoImovel11 = BlocoFactory.criaBloco("vermelho");
        blocoImovel11.setPosicao(5, 1);
        fase1.add(blocoImovel11);

        Bloco blocoImovel12 = BlocoFactory.criaBloco("vermelho");
        blocoImovel12.setPosicao(5, 3);
        fase1.add(blocoImovel12);

        Bloco blocoImovel13 = BlocoFactory.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 5);
        fase1.add(blocoImovel13);

        Bloco blocoImovel14 = BlocoFactory.criaBloco("vermelho");
        blocoImovel14.setPosicao(5, 7);
        fase1.add(blocoImovel14);

        Bloco blocoImovel15 = BlocoFactory.criaBloco("vermelho");
        blocoImovel15.setPosicao(5, 9);
        fase1.add(blocoImovel15);

        Bloco blocoImovel16 = BlocoFactory.criaBloco("vermelho");
        blocoImovel16.setPosicao(7, 1);
        fase1.add(blocoImovel16);

        Bloco blocoImovel17 = BlocoFactory.criaBloco("vermelho");
        blocoImovel17.setPosicao(7, 3);
        fase1.add(blocoImovel17);

        Bloco blocoImovel18 = BlocoFactory.criaBloco("vermelho");
        blocoImovel18.setPosicao(7, 5);
        fase1.add(blocoImovel18);

        Bloco blocoImovel19 = BlocoFactory.criaBloco("vermelho");
        blocoImovel19.setPosicao(7, 9);
        fase1.add(blocoImovel19);

        Bloco blocoImovel20 = BlocoFactory.criaBloco("vermelho");
        blocoImovel20.setPosicao(9, 1);
        fase1.add(blocoImovel20);

        Bloco blocoImovel21 = BlocoFactory.criaBloco("vermelho");
        blocoImovel21.setPosicao(9, 3);
        fase1.add(blocoImovel21);

        Bloco blocoImovel22 = BlocoFactory.criaBloco("vermelho");
        blocoImovel22.setPosicao(9, 5);
        fase1.add(blocoImovel22);

        Bloco blocoImovel23 = BlocoFactory.criaBloco("vermelho");
        blocoImovel23.setPosicao(9, 7);
        fase1.add(blocoImovel23);

        Bloco blocoImovel24 = BlocoFactory.criaBloco("vermelho");
        blocoImovel24.setPosicao(9, 9);
        fase1.add(blocoImovel24);

        Bloco blocoImovel25 = BlocoFactory.criaBloco("vermelho");
        blocoImovel25.setPosicao(7, 7);
        fase1.add(blocoImovel25);

        // BLOCOS MOVEIS
        Bloco blocoMovel1 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel1.setPosicao(3, 0);
        fase1.add(blocoMovel1);

        Bloco blocoMovel2 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel2.setPosicao(9, 0);
        fase1.add(blocoMovel2);

        Bloco blocoMovel3 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel3.setPosicao(0, 1);
        fase1.add(blocoMovel3);

        Bloco blocoMovel4 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel4.setPosicao(2, 1);
        fase1.add(blocoMovel4);

        Bloco blocoMovel5 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel5.setPosicao(4, 1);
        fase1.add(blocoMovel5);

        Bloco blocoMovel6 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel6.setPosicao(8, 3);
        fase1.add(blocoMovel6);

        Bloco blocoMovel7 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel7.setPosicao(1, 2);
        fase1.add(blocoMovel7);

        Bloco blocoMovel8 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel8.setPosicao(5, 2);
        fase1.add(blocoMovel8);

        Bloco blocoMovel9 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel9.setPosicao(9, 2);
        fase1.add(blocoMovel9);

        Bloco blocoMovel10 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel10.setPosicao(0, 5);
        fase1.add(blocoMovel10);

        Bloco blocoMovel11 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel11.setPosicao(2, 5);
        fase1.add(blocoMovel11);

        Bloco blocoMovel13 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel13.setPosicao(6, 5);
        fase1.add(blocoMovel13);

        Bloco blocoMovel14 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel14.setPosicao(9, 6);
        fase1.add(blocoMovel14);

        Bloco blocoMovel15 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel15.setPosicao(1, 10);
        fase1.add(blocoMovel15);

        Bloco blocoMovel16 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel16.setPosicao(7, 10);
        fase1.add(blocoMovel16);

        Bloco blocoMovel17 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel17.setPosicao(4, 9);
        fase1.add(blocoMovel17);

        Bloco blocoMovel18 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel18.setPosicao(9, 8);
        fase1.add(blocoMovel18);

        Bloco blocoMovel19 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel19.setPosicao(6, 7);
        fase1.add(blocoMovel19);

        Bloco blocoMovel21 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel21.setPosicao(8, 9);
        fase1.add(blocoMovel21);

        Bloco blocoMovel22 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel22.setPosicao(10, 7);
        fase1.add(blocoMovel22);

        Bloco blocoMovel23 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel23.setPosicao(5, 6);
        fase1.add(blocoMovel23);

        Bloco blocoMovel24 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel24.setPosicao(7, 8);
        fase1.add(blocoMovel24);

        Bloco blocoMovel25 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel25.setPosicao(3, 8);
        fase1.add(blocoMovel25);

        Bloco blocoMovel26 = BlocoFactory.criaBloco("verdeMovel");
        blocoMovel26.setPosicao(1, 8);
        fase1.add(blocoMovel26);

        // FRUTAS
        Item cereja = new Item("cereja.png");
        cereja.setPosicao(10, 10);
        fase1.add(cereja);

        Item limao = new Item("limao.png");
        limao.setPosicao(0, 10);
        fase1.add(limao);

        Item morango = new Item("morango.png");
        morango.setPosicao(10, 0);
        fase1.add(morango);

        Item uva = new Item("uva.png");
        uva.setPosicao(0, 0);
        fase1.add(uva);

        return fase1;
    }
    
    public static ArrayList<Elemento> segundaFase() {
        backgroundImg = "background2.png";

        ArrayList<Elemento> fase2 = new ArrayList<>();
        
        // HEROI
        Hero hHero = new Hero("skooter.png");
        hHero.setPosicao(5, 5);
        fase2.add(hHero);

        // ROBÔS
        RoboVerde roboVerde1 = new RoboVerde("roboVerde.png");
        roboVerde1.setPosicao(1, 1);
        fase2.add(roboVerde1);

        RoboAmarelo roboAmarelo = new RoboAmarelo("roboAmarelo.png", hHero);
        roboAmarelo.setPosicao(1, 9);
        fase2.add(roboAmarelo);

        RoboAzul roboAzul = new RoboAzul("roboAzul.png", hHero);
        roboAzul.setPosicao(9, 9);
        fase2.add(roboAzul);

        RoboRosa roboRosa = new RoboRosa("roboRosa.png", hHero);
        roboRosa.setPosicao(9, 1);
        fase2.add(roboRosa);

        // SETAS PARA CIMA
        Seta setaCima1 = new Seta("setacima.png", 'U');
        setaCima1.setPosicao(3, 0);
        fase2.add(setaCima1);

        Seta setaCima2 = new Seta("setacima.png", 'U');
        setaCima2.setPosicao(4, 0);
        fase2.add(setaCima2);

        Seta setaCima3 = new Seta("setacima.png", 'U');
        setaCima3.setPosicao(5, 0);
        fase2.add(setaCima3);

        Seta setaCima4 = new Seta("setacima.png", 'U');
        setaCima4.setPosicao(6, 0);
        fase2.add(setaCima4);

        Seta setaCima5 = new Seta("setacima.png", 'U');
        setaCima5.setPosicao(7, 0);
        fase2.add(setaCima5);

        Seta setaCima6 = new Seta("setacima.png", 'U');
        setaCima6.setPosicao(3, 8);
        fase2.add(setaCima6);

        Seta setaCima7 = new Seta("setacima.png", 'U');
        setaCima7.setPosicao(4, 8);
        fase2.add(setaCima7);

        Seta setaCima8 = new Seta("setacima.png", 'U');
        setaCima8.setPosicao(3, 6);
        fase2.add(setaCima8);

        Seta setaCima9 = new Seta("setacima.png", 'U');
        setaCima9.setPosicao(7, 6);
        fase2.add(setaCima9);

        Seta setaCima10 = new Seta("setacima.png", 'U');
        setaCima10.setPosicao(7, 8);
        fase2.add(setaCima10);

        Seta setaCima11 = new Seta("setacima.png", 'U');
        setaCima11.setPosicao(7, 10);
        fase2.add(setaCima11);

        // SETAS PARA BAIXO
        Seta setaBaixo1 = new Seta("setabaixo.png", 'D');
        setaBaixo1.setPosicao(3, 2);
        fase2.add(setaBaixo1);

        Seta setaBaixo2 = new Seta("setabaixo.png", 'D');
        setaBaixo2.setPosicao(7, 2);
        fase2.add(setaBaixo2);

        Seta setaBaixo3 = new Seta("setabaixo.png", 'D');
        setaBaixo3.setPosicao(3, 10);
        fase2.add(setaBaixo3);

        Seta setaBaixo4 = new Seta("setabaixo.png", 'D');
        setaBaixo4.setPosicao(3, 4);
        fase2.add(setaBaixo4);

        Seta setaBaixo5 = new Seta("setabaixo.png", 'D');
        setaBaixo5.setPosicao(7, 4);
        fase2.add(setaBaixo5);

        Seta setaBaixo6 = new Seta("setabaixo.png", 'D');
        setaBaixo6.setPosicao(2, 4);
        fase2.add(setaBaixo6);

        // SETAS PARA DIREITA
        Seta setaDireita1 = new Seta("setadireita.png", 'R');
        setaDireita1.setPosicao(0, 3);
        fase2.add(setaDireita1);

        Seta setaDireita2 = new Seta("setadireita.png", 'R');
        setaDireita2.setPosicao(2, 3);
        fase2.add(setaDireita2);

        Seta setaDireita3 = new Seta("setadireita.png", 'R');
        setaDireita3.setPosicao(4, 3);
        fase2.add(setaDireita3);

        Seta setaDireita4 = new Seta("setadireita.png", 'R');
        setaDireita4.setPosicao(6, 3);
        fase2.add(setaDireita4);

        Seta setaDireita5 = new Seta("setadireita.png", 'R');
        setaDireita5.setPosicao(8, 3);
        fase2.add(setaDireita5);

        Seta setaDireita6 = new Seta("setadireita.png", 'R');
        setaDireita6.setPosicao(0, 7);
        fase2.add(setaDireita6);

        Seta setaDireita7 = new Seta("setadireita.png", 'R');
        setaDireita7.setPosicao(4, 7);
        fase2.add(setaDireita7);

        Seta setaDireita8 = new Seta("setadireita.png", 'R');
        setaDireita8.setPosicao(8, 7);
        fase2.add(setaDireita8);

        Seta setaDireita9 = new Seta("setadireita.png", 'R');
        setaDireita9.setPosicao(10, 7);
        fase2.add(setaDireita9);

        // SETAS PARA ESQUERDA
        Seta setaEsquerda1 = new Seta("setaesquerda.png", 'L');
        setaEsquerda1.setPosicao(10, 3);
        fase2.add(setaEsquerda1);

        Seta setaEsquerda2 = new Seta("setaesquerda.png", 'L');
        setaEsquerda2.setPosicao(2, 7);
        fase2.add(setaEsquerda2);

        Seta setaEsquerda3 = new Seta("setaesquerda.png", 'L');
        setaEsquerda3.setPosicao(6, 7);
        fase2.add(setaEsquerda3);

        Seta setaEsquerda4 = new Seta("setaesquerda.png", 'L');
        setaEsquerda4.setPosicao(4, 9);
        fase2.add(setaEsquerda4);

        Seta setaEsquerda5 = new Seta("setaesquerda.png", 'L');
        setaEsquerda5.setPosicao(4, 10);
        fase2.add(setaEsquerda5);

        Seta setaEsquerda6 = new Seta("setaesquerda.png", 'L');
        setaEsquerda6.setPosicao(2, 5);
        fase2.add(setaEsquerda6);

        Seta setaEsquerda7 = new Seta("setaesquerda.png", 'L');
        setaEsquerda7.setPosicao(2, 6);
        fase2.add(setaEsquerda7);
        
        // BLOCOS ESTATICOS
        Bloco blocoImovel1 = BlocoFactory.criaBloco("vermelho");
        blocoImovel1.setPosicao(3, 1);
        fase2.add(blocoImovel1);

        Bloco blocoImovel2 = BlocoFactory.criaBloco("vermelho");
        blocoImovel2.setPosicao(7, 1);
        fase2.add(blocoImovel2);

        Bloco blocoImovel3 = BlocoFactory.criaBloco("vermelho");
        blocoImovel3.setPosicao(3, 5);
        fase2.add(blocoImovel3);

        Bloco blocoImovel4 = BlocoFactory.criaBloco("vermelho");
        blocoImovel4.setPosicao(7, 5);
        fase2.add(blocoImovel4);

        Bloco blocoImovel5 = BlocoFactory.criaBloco("vermelho");
        blocoImovel5.setPosicao(3, 9);
        fase2.add(blocoImovel5);

        Bloco blocoImovel6 = BlocoFactory.criaBloco("vermelho");
        blocoImovel6.setPosicao(7, 9);
        fase2.add(blocoImovel6);

        Bloco blocoImovel7 = BlocoFactory.criaBloco("vermelho");
        blocoImovel7.setPosicao(1, 3);
        fase2.add(blocoImovel7);

        Bloco blocoImovel8 = BlocoFactory.criaBloco("vermelho");
        blocoImovel8.setPosicao(3, 3);
        fase2.add(blocoImovel8);

        Bloco blocoImovel9 = BlocoFactory.criaBloco("vermelho");
        blocoImovel9.setPosicao(5, 3);
        fase2.add(blocoImovel9);

        Bloco blocoImovel9_ = BlocoFactory.criaBloco("vermelho");
        blocoImovel9_.setPosicao(7, 3);
        fase2.add(blocoImovel9_);

        Bloco blocoImovel10 = BlocoFactory.criaBloco("vermelho");
        blocoImovel10.setPosicao(9, 3);
        fase2.add(blocoImovel10);

        Bloco blocoImovel11 = BlocoFactory.criaBloco("vermelho");
        blocoImovel11.setPosicao(1, 7);
        fase2.add(blocoImovel11);

        Bloco blocoImovel12 = BlocoFactory.criaBloco("vermelho");
        blocoImovel12.setPosicao(3, 7);
        fase2.add(blocoImovel12);

        Bloco blocoImovel13 = BlocoFactory.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 7);
        fase2.add(blocoImovel13);

        Bloco blocoImovel14 = BlocoFactory.criaBloco("vermelho");
        blocoImovel14.setPosicao(7, 7);
        fase2.add(blocoImovel14);

        Bloco blocoImovel15 = BlocoFactory.criaBloco("vermelho");
        blocoImovel15.setPosicao(9, 7);
        fase2.add(blocoImovel15);

        // FRUTAS
        Item cereja = new Item("cereja.png");
        cereja.setPosicao(9, 5);
        fase2.add(cereja);

        Item morango = new Item("morango.png");
        morango.setPosicao(5, 9);
        fase2.add(morango);

        Item uva = new Item("uva.png");
        uva.setPosicao(1, 5);
        fase2.add(uva);

        Item limao = new Item("limao.png");
        limao.setPosicao(5, 1);
        fase2.add(limao);

        return fase2;
    }

    public static ArrayList<Elemento> terceiraFase() {
        backgroundImg = "background3.png";
        
        ArrayList<Elemento> fase3 = new ArrayList<>();
        
        // HERÓI
        Hero hHero = new Hero("skooter.png");
        hHero.setPosicao(5, 5);
        fase3.add(hHero);
        
        // BLOCOS VERMELHOS MÓVEIS
        Bloco bvm1 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm1.setPosicao(1, 1);
        fase3.add(bvm1);
        
        Bloco bvm2 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm2.setPosicao(1, 2);
        fase3.add(bvm2);
        
        Bloco bvm3 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm3.setPosicao(1, 3);
        fase3.add(bvm3);
        
        Bloco bvm4 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm4.setPosicao(1, 4);
        fase3.add(bvm4);
        
        Bloco bvm5 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm5.setPosicao(1, 5);
        fase3.add(bvm5);
        
        Bloco bvm6 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm6.setPosicao(1, 6);
        fase3.add(bvm6);
        
        Bloco bvm7 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm7.setPosicao(1, 7);
        fase3.add(bvm7);
        
        Bloco bvm8 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm8.setPosicao(1, 8);
        fase3.add(bvm8);
        
        Bloco bvm9 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm9.setPosicao(1, 9);
        fase3.add(bvm9);
        
        Bloco bvm10 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm10.setPosicao(2, 1);
        fase3.add(bvm10);
        
        Bloco bvm12 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm12.setPosicao(3, 1);
        fase3.add(bvm12);
        
        Bloco bvm13 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm13.setPosicao(4, 1);
        fase3.add(bvm13);
        
        Bloco bvm14 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm14.setPosicao(5, 1);
        fase3.add(bvm14);
        
        Bloco bvm15 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm15.setPosicao(6, 1);
        fase3.add(bvm15);
        
        Bloco bvm16 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm16.setPosicao(7, 1);
        fase3.add(bvm16);
        
        Bloco bvm17 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm17.setPosicao(8, 1);
        fase3.add(bvm17);
        
        Bloco bvm18 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm18.setPosicao(9, 1);
        fase3.add(bvm18);
        
        Bloco bvm19 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm19.setPosicao(9, 2);
        fase3.add(bvm19);
        
        Bloco bvm20 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm20.setPosicao(9, 3);
        fase3.add(bvm20);
        
        Bloco bvm21 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm21.setPosicao(9, 4);
        fase3.add(bvm21);
        
        Bloco bvm22 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm22.setPosicao(9, 5);
        fase3.add(bvm22);
        
        Bloco bvm23 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm23.setPosicao(9, 6);
        fase3.add(bvm23);
        
        Bloco bvm24 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm24.setPosicao(9, 7);
        fase3.add(bvm24);
        
        Bloco bvm25 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm25.setPosicao(9, 8);
        fase3.add(bvm25);
        
        Bloco bvm26 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm26.setPosicao(9, 9);
        fase3.add(bvm26);
        
        Bloco bvm28 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm28.setPosicao(2, 9);
        fase3.add(bvm28);
        
        Bloco bvm29 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm29.setPosicao(3, 9);
        fase3.add(bvm29);
        
        Bloco bvm30 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm30.setPosicao(4, 9);
        fase3.add(bvm30);
        
        Bloco bvm31 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm31.setPosicao(5, 9);
        fase3.add(bvm31);
        
        Bloco bvm32 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm32.setPosicao(6, 9);
        fase3.add(bvm32);
        
        Bloco bvm33 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm33.setPosicao(7, 9);
        fase3.add(bvm33);
        
        Bloco bvm34 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm34.setPosicao(8, 9);
        fase3.add(bvm34);
        
        Bloco bvm35 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm35.setPosicao(3, 3);
        fase3.add(bvm35);
        
        Bloco bvm36 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm36.setPosicao(3, 4);
        fase3.add(bvm36);
        
        Bloco bvm37 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm37.setPosicao(3, 5);
        fase3.add(bvm37);
        
        Bloco bvm38 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm38.setPosicao(3, 6);
        fase3.add(bvm38);
        
        Bloco bvm39 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm39.setPosicao(3, 7);
        fase3.add(bvm39);
                
        Bloco bvm40 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm40.setPosicao(4, 7);
        fase3.add(bvm40);
        
        Bloco bvm41 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm41.setPosicao(5, 7);
        fase3.add(bvm41);
        
        Bloco bvm42 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm42.setPosicao(6, 7);
        fase3.add(bvm42);
        
        Bloco bvm43 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm43.setPosicao(7, 7);
        fase3.add(bvm43);
        
        Bloco bvm44 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm44.setPosicao(7, 6);
        fase3.add(bvm44);
        
        Bloco bvm45 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm45.setPosicao(7, 5);
        fase3.add(bvm45);
        
        Bloco bvm46 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm46.setPosicao(7, 4);
        fase3.add(bvm46);
        
        Bloco bvm47 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm47.setPosicao(7, 3);
        fase3.add(bvm47);
        
        Bloco bvm48 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm48.setPosicao(6, 3);
        fase3.add(bvm48);
        
        Bloco bvm49 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm49.setPosicao(5, 3);
        fase3.add(bvm49);
        
        Bloco bvm50 = BlocoFactory.criaBloco("vermelhoMovel");
        bvm50.setPosicao(4, 3);
        fase3.add(bvm50);
        
        Item bvm51 = new Item("lampada.png");
        bvm51.setPosicao(5, 8);
        fase3.add(bvm51);
        
        Item bvm52 = new Item("lanterna.png");
        bvm52.setPosicao(5, 10);
        fase3.add(bvm52);
        
        Item bvm53 = new Item("sol.png");
        bvm53.setPosicao(5, 0);
        fase3.add(bvm53);
        
        Item bvm54 = new Item("vela.png");
        bvm54.setPosicao(5, 2);
        fase3.add(bvm54);
        
        RoboRosa roboRosa1 = new RoboRosa("roboRosa.png", hHero);
        roboRosa1.setPosicao(2, 5);
        fase3.add(roboRosa1);
        
        RoboRosa roboRosa2 = new RoboRosa("roboRosa.png", hHero);
        roboRosa2.setPosicao(8, 5);
        fase3.add(roboRosa2);
        
        RoboAzul roboAzul2 = new RoboAzul("roboAzul.png", hHero);
        roboAzul2.setPosicao(0, 5);
        fase3.add(roboAzul2);
        
        RoboAzul roboAzul3 = new RoboAzul("roboAzul.png", hHero);
        roboAzul3.setPosicao(10, 5);
        fase3.add(roboAzul3);
        
        
        return fase3;
    }

    public static ArrayList<Elemento> quartaFase() {
        backgroundImg = "background4.png";
        
        ArrayList<Elemento> fase4 = new ArrayList<>();
        
        Hero hHero = new Hero("skooter.png");
        hHero.setPosicao(4, 5);
        fase4.add(hHero);

        Bloco blocoImovel1 = BlocoFactory.criaBloco("vermelho");
        blocoImovel1.setPosicao(1, 0);
        fase4.add(blocoImovel1);
        
        Bloco blocoImovel2 = BlocoFactory.criaBloco("vermelho");
        blocoImovel2.setPosicao(7, 0);
        fase4.add(blocoImovel2);

        Bloco blocoImovel3 = BlocoFactory.criaBloco("vermelho");
        blocoImovel3.setPosicao(8, 1);
        fase4.add(blocoImovel3);
        
        Bloco blocoImovel4 = BlocoFactory.criaBloco("vermelho");
        blocoImovel4.setPosicao(10, 1);
        fase4.add(blocoImovel4);

        Bloco blocoImovel5 = BlocoFactory.criaBloco("vermelho");
        blocoImovel5.setPosicao(3, 2);
        fase4.add(blocoImovel5);
        
        Bloco blocoImovel6 = BlocoFactory.criaBloco("vermelho");
        blocoImovel6.setPosicao(5, 2);
        fase4.add(blocoImovel6);

        Bloco blocoImovel7 = BlocoFactory.criaBloco("vermelho");
        blocoImovel7.setPosicao(0, 3);
        fase4.add(blocoImovel7);
        
        Bloco blocoImovel8 = BlocoFactory.criaBloco("vermelho");
        blocoImovel8.setPosicao(6, 3);
        fase4.add(blocoImovel8);

        Bloco blocoImovel9 = BlocoFactory.criaBloco("vermelho");
        blocoImovel9.setPosicao(2, 5);
        fase4.add(blocoImovel9);
        
        Bloco blocoImovel10 = BlocoFactory.criaBloco("vermelho");
        blocoImovel10.setPosicao(0, 7);
        fase4.add(blocoImovel10);

        Bloco blocoImovel11 = BlocoFactory.criaBloco("vermelho");
        blocoImovel11.setPosicao(8, 7);
        fase4.add(blocoImovel11);
        
        Bloco blocoImovel12 = BlocoFactory.criaBloco("vermelho");
        blocoImovel12.setPosicao(1, 8);
        fase4.add(blocoImovel12);

        Bloco blocoImovel13 = BlocoFactory.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 8);
        fase4.add(blocoImovel13);
        
        Bloco blocoImovel14 = BlocoFactory.criaBloco("vermelho");
        blocoImovel14.setPosicao(3, 10);
        fase4.add(blocoImovel14);
        
        Bloco blocoImovel15 = BlocoFactory.criaBloco("vermelho");
        blocoImovel15.setPosicao(8, 10);
        fase4.add(blocoImovel15);
        
        Bloco blocoVerde1 = BlocoFactory.criaBloco("verde");
        blocoVerde1.setPosicao(1, 1);
        fase4.add(blocoVerde1);
        
        Bloco blocoVerde2 = BlocoFactory.criaBloco("verde");
        blocoVerde2.setPosicao(3, 1);
        fase4.add(blocoVerde2);

        Bloco blocoVerde3 = BlocoFactory.criaBloco("verde");
        blocoVerde3.setPosicao(5, 1);
        fase4.add(blocoVerde3);

        Bloco blocoVerde4 = BlocoFactory.criaBloco("verde");
        blocoVerde4.setPosicao(7, 1);
        fase4.add(blocoVerde4);

        Bloco blocoVerde5 = BlocoFactory.criaBloco("verde");
        blocoVerde5.setPosicao(9, 1);
        fase4.add(blocoVerde5);

        Bloco blocoVerde6 = BlocoFactory.criaBloco("verde");
        blocoVerde6.setPosicao(2,2 );
        fase4.add(blocoVerde6);

        Bloco blocoVerde7 = BlocoFactory.criaBloco("verde");
        blocoVerde7.setPosicao(4, 2);
        fase4.add(blocoVerde7);

        Bloco blocoVerde8 = BlocoFactory.criaBloco("verde");
        blocoVerde8.setPosicao(6, 2);
        fase4.add(blocoVerde8);

        Bloco blocoVerde9 = BlocoFactory.criaBloco("verde");
        blocoVerde9.setPosicao(8, 2);
        fase4.add(blocoVerde9);

        Bloco blocoVerde10 = BlocoFactory.criaBloco("verde");
        blocoVerde10.setPosicao(1, 3);
        fase4.add(blocoVerde10);

        Bloco blocoVerde11 = BlocoFactory.criaBloco("verde");
        blocoVerde11.setPosicao(3, 3);
        fase4.add(blocoVerde11);

        Bloco blocoVerde12 = BlocoFactory.criaBloco("verde");
        blocoVerde12.setPosicao(5, 3);
        fase4.add(blocoVerde12);

        Bloco blocoVerde13 = BlocoFactory.criaBloco("verde");
        blocoVerde13.setPosicao(7, 3);
        fase4.add(blocoVerde13);

        Bloco blocoVerde14 = BlocoFactory.criaBloco("verde");
        blocoVerde14.setPosicao(9, 3);
        fase4.add(blocoVerde14);

        Bloco blocoVerde15 = BlocoFactory.criaBloco("verde");
        blocoVerde15.setPosicao(2, 4);
        fase4.add(blocoVerde15);

        Bloco blocoVerde16 = BlocoFactory.criaBloco("verde");
        blocoVerde16.setPosicao(4, 4);
        fase4.add(blocoVerde16);

        Bloco blocoVerde17 = BlocoFactory.criaBloco("verde");
        blocoVerde17.setPosicao(6, 4);
        fase4.add(blocoVerde17);

        Bloco blocoVerde18 = BlocoFactory.criaBloco("verde");
        blocoVerde18.setPosicao(8, 4);
        fase4.add(blocoVerde18);

        Bloco blocoVerde19 = BlocoFactory.criaBloco("verde");
        blocoVerde19.setPosicao(1, 5);
        fase4.add(blocoVerde19);

        Bloco blocoVerde20 = BlocoFactory.criaBloco("verde");
        blocoVerde20.setPosicao(3, 5);
        fase4.add(blocoVerde20);

        Bloco blocoVerde21 = BlocoFactory.criaBloco("verde");
        blocoVerde21.setPosicao(5, 5);
        fase4.add(blocoVerde21);

        Bloco blocoVerde22 = BlocoFactory.criaBloco("verde");
        blocoVerde22.setPosicao(7, 5);
        fase4.add(blocoVerde22);
        
        Bloco blocoVerde22_ = BlocoFactory.criaBloco("verde");
        blocoVerde22_.setPosicao(9, 5);
        fase4.add(blocoVerde22_);

        Bloco blocoVerde23 = BlocoFactory.criaBloco("verde");
        blocoVerde23.setPosicao(2, 6);
        fase4.add(blocoVerde23);

        Bloco blocoVerde24 = BlocoFactory.criaBloco("verde");
        blocoVerde24.setPosicao(4, 6);
        fase4.add(blocoVerde24);

        Bloco blocoVerde25 = BlocoFactory.criaBloco("verde");
        blocoVerde25.setPosicao(6, 6);
        fase4.add(blocoVerde25);

        Bloco blocoVerde26 = BlocoFactory.criaBloco("verde");
        blocoVerde26.setPosicao(8, 6);
        fase4.add(blocoVerde26);

        Bloco blocoVerde27 = BlocoFactory.criaBloco("verde");
        blocoVerde27.setPosicao(1, 7);
        fase4.add(blocoVerde27);

        Bloco blocoVerde28 = BlocoFactory.criaBloco("verde");
        blocoVerde28.setPosicao(3, 7);
        fase4.add(blocoVerde28);

        Bloco blocoVerde29 = BlocoFactory.criaBloco("verde");
        blocoVerde29.setPosicao(5, 7);
        fase4.add(blocoVerde29);

        Bloco blocoVerde30 = BlocoFactory.criaBloco("verde");
        blocoVerde30.setPosicao(7, 7);
        fase4.add(blocoVerde30);

        Bloco blocoVerde31 = BlocoFactory.criaBloco("verde");
        blocoVerde31.setPosicao(9, 7);
        fase4.add(blocoVerde31);

        Bloco blocoVerde32 = BlocoFactory.criaBloco("verde");
        blocoVerde32.setPosicao(2, 8);
        fase4.add(blocoVerde32);

        Bloco blocoVerde33 = BlocoFactory.criaBloco("verde");
        blocoVerde33.setPosicao(4, 8);
        fase4.add(blocoVerde33);

        Bloco blocoVerde34 = BlocoFactory.criaBloco("verde");
        blocoVerde34.setPosicao(6, 8);
        fase4.add(blocoVerde34);

        Bloco blocoVerde35 = BlocoFactory.criaBloco("verde");
        blocoVerde35.setPosicao(8, 8);
        fase4.add(blocoVerde35);

        Bloco blocoVerde36 = BlocoFactory.criaBloco("verde");
        blocoVerde36.setPosicao(1, 9);
        fase4.add(blocoVerde36);

        Bloco blocoVerde37 = BlocoFactory.criaBloco("verde");
        blocoVerde37.setPosicao(3, 9);
        fase4.add(blocoVerde37);

        Bloco blocoVerde38 = BlocoFactory.criaBloco("verde");
        blocoVerde38.setPosicao(5, 9);
        fase4.add(blocoVerde38);

        Bloco blocoVerde39 = BlocoFactory.criaBloco("verde");
        blocoVerde39.setPosicao(7, 9);
        fase4.add(blocoVerde39);

        Bloco blocoVerde40 = BlocoFactory.criaBloco("verde");
        blocoVerde40.setPosicao(9, 9);
        fase4.add(blocoVerde40);

        
        Item sol = new Item("sol.png");
        sol.setPosicao(0, 0);
        fase4.add(sol);
        
        Item lampada = new Item("lampada.png");
        lampada.setPosicao(0, 10);
        fase4.add(lampada);
        
        Item lanterna = new Item("lanterna.png");
        lanterna.setPosicao(10, 10);
        fase4.add(lanterna);
        
        Item vela = new Item("vela.png");
        vela.setPosicao(10, 0);
        fase4.add(vela);

        RoboAmarelo roboAmarelo1 = new RoboAmarelo("roboAmarelo.png", hHero);
        roboAmarelo1.setPosicao(10, 5);
        fase4.add(roboAmarelo1);

        RoboAmarelo roboAmarelo2 = new RoboAmarelo("roboAmarelo.png", hHero);
        roboAmarelo2.setPosicao(0, 5);
        fase4.add(roboAmarelo2);

        RoboVerde roboVerde = new RoboVerde("roboVerde.png");
        roboVerde.setPosicao(5, 0);
        fase4.add(roboVerde);

        RoboRosa roboRosa = new RoboRosa("roboRosa.png", hHero);
        roboRosa.setPosicao(5, 10);
        fase4.add(roboRosa);

        return fase4;
    }
}
