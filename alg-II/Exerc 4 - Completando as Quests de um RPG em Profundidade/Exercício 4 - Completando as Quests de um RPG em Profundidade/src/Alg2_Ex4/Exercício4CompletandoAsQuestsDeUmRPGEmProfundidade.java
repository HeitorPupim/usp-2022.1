package Alg2_Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercício4CompletandoAsQuestsDeUmRPGEmProfundidade {

    

    public static void main(String[] args) {
        AbstractGraph graph;
        TraversalStrategy traversalStrategy;
        Scanner scan = new Scanner(System.in);
        
        int nv = scan.nextInt();
        String nome;
        String descricao;
        List<Vertex> vertices = new ArrayList<>();
        nome = scan.nextLine();
        
        
        for (int x = 0; x < nv; x++) {
            nome = scan.nextLine();
            descricao = scan.nextLine();
            vertices.add(new Vertex(nome,descricao,x));
        }   
        graph = new DigraphList(vertices);
        
        
        int na = scan.nextInt();
        int verticeOrigemID;
        int verticeDestinoID;
        
        
        for (int x = 0; x < na; x++) {
            verticeOrigemID = scan.nextInt();
            verticeDestinoID = scan.nextInt();
            graph.addEdge(vertices.get(verticeOrigemID), vertices.get(verticeDestinoID));
        }
        
        int source = scan.nextInt();
        

        traversalStrategy = new BuscaEmProfundidade(graph);

        traversalStrategy.traverseGraph(graph.getVertices().get(source));
        //traversalStrategy.printDistances();
        //traversalStrategy.printPath();
        //traversalStrategy.printVisitTree();
        graph.printInGraphviz("GraphList");
    }
    
}
