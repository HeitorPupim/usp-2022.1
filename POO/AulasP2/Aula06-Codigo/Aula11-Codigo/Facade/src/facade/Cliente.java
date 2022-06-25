package facade;


public class Cliente {
    String sNome;
    Banco b;

    public Cliente(String sNome, Banco b) {
        this.sNome = sNome;
        this.b = b;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public Banco getBancoDoCliente() {
        return b;
    }
}
