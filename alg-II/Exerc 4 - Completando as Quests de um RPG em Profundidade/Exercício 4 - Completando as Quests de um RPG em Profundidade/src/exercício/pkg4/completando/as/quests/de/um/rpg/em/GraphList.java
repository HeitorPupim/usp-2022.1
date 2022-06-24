package exercício.pkg4.completando.as.quests.de.um.rpg.em;

import Alg2_Ex4.DigraphList;
import Alg2_Ex4.Vertex;

import java.util.List;

public class GraphList extends DigraphList
{
    protected GraphList(List<Vertex> vertices) {
        super(vertices);
    }


    public void addEdge(Vertex source, Vertex destination) {
        super.addEdge(source, destination);
        super.addEdge(destination, source);
    }

    public void removeEdge(Vertex source, Vertex destination) {
        super.removeEdge(source, destination);
        super.removeEdge(destination, source);
    }

    public boolean hasAnyEdge(Vertex vertex) {
        int vertexIndex = getVertices().indexOf(vertex);
        return !getAdjacencyList().get(vertexIndex).isEmpty();
    }
}
