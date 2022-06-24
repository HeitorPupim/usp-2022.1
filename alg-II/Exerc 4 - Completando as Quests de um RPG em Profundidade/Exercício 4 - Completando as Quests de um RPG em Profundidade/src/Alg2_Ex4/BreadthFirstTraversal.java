package Alg2_Ex4;

import java.util.*;

public class BreadthFirstTraversal extends TraversalStrategy
{
    public BreadthFirstTraversal(AbstractGraph graph)
    {
        super(graph);
    }


    public void traverseGraph(Vertex source)
    {
        int sourceIndex = getGraph().getVertices().indexOf(source);
        addToPath(source);
        markVertexAsVisited(sourceIndex);
        setDistanceToVertex(sourceIndex, 0);
        setPredecessorVertexIndex(sourceIndex, -1);

        Queue<Vertex> vertexesToVisit = new LinkedList<>();
        vertexesToVisit.add(source);

        recurcao(vertexesToVisit);
        
        printPath();
    }
    
    private void recurcao(Queue<Vertex> vertexesToVisit){
        Vertex currentVisitedVertex;
        int currentVisitedVertexIndex;
        while(!vertexesToVisit.isEmpty())
        {
            
            currentVisitedVertex = vertexesToVisit.poll();
            currentVisitedVertexIndex = getGraph().getVertices().indexOf(currentVisitedVertex);
            if (currentVisitedVertex != null)
            {
                var adjacentVertex = getGraph().getFirstConnectedVertex(currentVisitedVertex);
                while(adjacentVertex != null)
                {
                    int adjacentVertexIndex = getGraph().getVertices().indexOf(adjacentVertex);
                    if(!hasVertexBeenVisited(adjacentVertexIndex))
                    {
                        updateTraversalInfoForVertex(adjacentVertexIndex, currentVisitedVertexIndex);
                        vertexesToVisit.add(adjacentVertex);
                        recurcao(vertexesToVisit);
                    }
                    
                    
                    adjacentVertex = getGraph().getNextConnectedVertex(currentVisitedVertex, adjacentVertex);
                }
            }
        }
    } 
    
    private void updateTraversalInfoForVertex(int newVertexIndex, int previousVertexIndex)
    {
        var newVertex = getGraph().getVertices().get(newVertexIndex);
        var oldVertex = getGraph().getVertices().get(previousVertexIndex);
        float newDistance = getGraph().getDistance(oldVertex, newVertex);
        float distance = getDistanceToVertex(previousVertexIndex) + newDistance;
        addToPath(newVertex);
        markVertexAsVisited(newVertexIndex);
        setDistanceToVertex(newVertexIndex,  distance);
        setPredecessorVertexIndex(newVertexIndex, previousVertexIndex);
        setSuccessorVertexIndex(previousVertexIndex, newVertexIndex);
    }

}