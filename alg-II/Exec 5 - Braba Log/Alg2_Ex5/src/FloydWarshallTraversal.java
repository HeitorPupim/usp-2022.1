import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.logging.Logger;

public class FloydWarshallTraversal extends TraversalStrategy
{
    private static final Logger LOGGER = Logger.getLogger("FloydWarshallTraversal.class");

    public float[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(float[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    private float [][] distanceMatrix;

    protected FloydWarshallTraversal(AbstractGraph graph) {
        super(graph);
        distanceMatrix = new float[graph.getNumberOfVertices()][graph.getNumberOfVertices()];
        for(int i=0;i<graph.getNumberOfVertices();i++){
            for (int j=0;j<graph.getNumberOfVertices();j++){
                distanceMatrix[i][j]=0;
            }
        }
    }

    @Override
    void traverseGraph(Vertex source)
    {
        for (int i = 0; i < getGraph().getNumberOfVertices(); i++) {
            for (int j = 0; j < getGraph().getNumberOfVertices(); j++) {
                Vertex origin = getGraph().getVertices().get(i);
                Vertex destination = getGraph().getVertices().get(j);
                if(getGraph().edgeExists(origin, destination))
                {
                    distanceMatrix[i][j] = getGraph().getDistance(origin, destination);
                }
                else
                {
                    distanceMatrix[i][j] = Float.POSITIVE_INFINITY;
                }
            }
        }
        for (int k = 0; k < getGraph().getNumberOfVertices(); k++) {
            for (int i = 0; i < getGraph().getNumberOfVertices(); i++) {
                for (int j = 0; j < getGraph().getNumberOfVertices(); j++) {
                    float newDistance = distanceMatrix[i][k] + distanceMatrix[k][j];
                    if(newDistance < distanceMatrix[i][j])
                    {
                        distanceMatrix[i][j] = newDistance;
                    }
                }
            }
        }
        printDistanceMatrix();
    }


    /*public void verticeCentra(){
        var maxDistancia = new float [this.distanceMatrix.length];
        for (int i=0;i<this.distanceMatrix.length;i++){
            for (int j=0;j<this.distanceMatrix[0].length;j++){
                if (maxDistancia[j]<this.distanceMatrix[j][i]){
                    maxDistancia[j]=this.distanceMatrix[j][i];
                }
            }
        }
        int menorIndice = 0;
        float menorDis= maxDistancia[0];
        for (int i=0;i< maxDistancia.length;i++){
            if(menorDis>maxDistancia[i]){
                menorDis = maxDistancia[i];
                menorIndice=i;
            }
        }
        System.out.printf(String.valueOf(getGraph().getVertices().get(menorIndice).getPosicaoX()+
                getGraph().getVertices().get(menorIndice).getPosicaoY()));
    }*/

    private void printDistanceMatrix() {
        var decimalFormat = new DecimalFormat("00.00");
        var distanceMatrixString = new StringBuilder();
        distanceMatrixString.append('\n');
        for (float[] row: distanceMatrix) {
            for(float value: row) {
                distanceMatrixString.append(decimalFormat.format(value));
                distanceMatrixString.append(' ');
            }
            distanceMatrixString.append('\n');
        }
        LOGGER.info(distanceMatrixString.toString());
    }
}