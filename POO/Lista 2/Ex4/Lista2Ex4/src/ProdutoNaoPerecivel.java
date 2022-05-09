
public class ProdutoNaoPerecivel extends Produto{

	protected int AnosGarantia;

	
	
	public ProdutoNaoPerecivel(int codigo, int qtdeEstoque, String descricao, float precoUnitario, int anosGarantia) {
		super(codigo, qtdeEstoque, descricao, precoUnitario);
		this.AnosGarantia = anosGarantia;
	}



	public int getAnosGarantia() {
		return AnosGarantia;
	}

	
	
}
