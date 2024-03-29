package facade;

public class TransacaoFacade {
    Cliente cliente;
    Banco banco;
    Loja loja;
    public TransacaoFacade(String sNomeCliente, Loja umaLoja){
        loja = umaLoja;
        cliente = loja.getClienteByName(sNomeCliente);
        banco = cliente.getBancoDoCliente();
    }

    public boolean CompraDeProduto(int iIndiceProduto){
        if(loja.hasProduct(iIndiceProduto)){
            Produto produto = loja.getProdutoByIndex(iIndiceProduto);        
            if(banco.Paga(produto, cliente))
                return true;
            return false;
        }else return false;
    }
}
