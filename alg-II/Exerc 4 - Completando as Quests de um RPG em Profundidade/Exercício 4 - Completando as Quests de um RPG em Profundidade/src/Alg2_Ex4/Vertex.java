package Alg2_Ex4;

import java.util.Objects;

public class Vertex   //class quest
{
    private String name;
    private String descricao; 
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(Objects.equals(name, ""))
        {
            System.out.println("Nome vazio não será adicionado");
        }
        this.name = name;
    }

    public Vertex(String name,String descricao, int ID) {
        this.name = name;
        this.descricao=descricao;
        this.ID = ID;
    }

    public String toString()
    {
        return "Quest{\n\tID= " + ID + "\n\tname=" + name + "\n\tdescription= " + descricao + "\n}\n" ;
    }
}
