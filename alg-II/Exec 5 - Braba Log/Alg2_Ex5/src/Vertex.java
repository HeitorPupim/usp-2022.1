public class Vertex
{
    private int posicaoX;
    private int posicaoY;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public Vertex(int posicaoX, int posicaoY, int id) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.id = id;
    }


    @Override
    public String toString()
    {
        return "Vertex{" + posicaoX + ","+posicaoY+'}';
    }
}
