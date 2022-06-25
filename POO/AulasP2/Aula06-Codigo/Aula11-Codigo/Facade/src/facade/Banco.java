
package facade;

import java.util.ArrayList;

public class Banco {
    ArrayList<Cliente> alClientes;

    public boolean Paga(Produto p, Cliente c){
        if(alClientes.contains(c))
            return true;
        return false;
    }
}
