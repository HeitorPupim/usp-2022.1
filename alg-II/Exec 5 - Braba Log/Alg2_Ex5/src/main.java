import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.*;


public class main {
    public static void main(String[] args) {
        AbstractGraph graph;
        TraversalStrategy traversalStrategy;
        Scanner scan = new Scanner(System.in);


        int nv = scan.nextInt();
        //System.out.printf("\nnv:"+nv+"\n");


        int x1,x2,y1,y2;
        String linha, xNumero="",yNumero="";
        String[] cordenadas;

        linha= scan.nextLine();//pula linha vazia
        System.out.println(linha);

        List<Vertex> vertices = new ArrayList<>();


        for (int x = 0; x < nv; x++) {
            linha= scan.nextLine();
            cordenadas= linha.split(",");
            x1 = Integer.parseInt(cordenadas[0]);
            y1 = Integer.parseInt(cordenadas[1]);

            vertices.add(new Vertex(x1,y1,x));
        }
        graph = new DigraphList(vertices);

        int na;
        na = scan.nextInt();
        linha= scan.nextLine();

        float distancia;
        Vertex atual = null ;
        Vertex destino = null;
        String[] linhasAUX;

        for (int x = 0; x < na; x++) {
            linha= scan.nextLine();
            linhasAUX= linha.split(":");

            cordenadas = linhasAUX[0].split(",");
            x1= Integer.parseInt(cordenadas[0]);
            y1= Integer.parseInt(cordenadas[1]);

            cordenadas = linhasAUX[1].split(",");
            x2= Integer.parseInt(cordenadas[0]);
            y2= Integer.parseInt(cordenadas[1]);

            //System.out.printf("x1: "+x1+"   y1: "+y1+"  x2: "+x2+"  y2: "+y2+"\n");

            distancia = (float) (sqrt(pow( x1-x2, 2) + pow( y1-y2,2 )));
            //System.out.printf("distancia: "+distancia+"\n");

            for (int i =0; i<vertices.size(); i++){
                if(vertices.get(i).getPosicaoX() == x1){
                    if(vertices.get(i).getPosicaoY() == y1){
                       atual = vertices.get(i);
                    }
                }
            }
            for (int i =0; i<vertices.size(); i++){
                if(vertices.get(i).getPosicaoX() == x2){
                    if(vertices.get(i).getPosicaoY() == y2){
                        destino = vertices.get(i);
                    }
                }
            }
            graph.addEdge(atual, destino,distancia);
        }

        //System.out.println("correto");
        traversalStrategy = new FloydWarshallTraversal(graph);


        traversalStrategy.traverseGraph(graph.getVertices().get(0));
        traversalStrategy.verticeCentra(traversalStrategy.getDistanceMatrix());
        traversalStrategy.verticePeriferico(traversalStrategy.getDistanceMatrix());
        //traversalStrategy.printDistances();
        //traversalStrategy.printPath();
        //traversalStrategy.printVisitTree();
        //graph.printInGraphviz("GraphList");
    }
}
