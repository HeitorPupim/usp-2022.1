
public class ProdutoPerecivelEspecial extends ProdutoPerecivel {

	
	public ProdutoPerecivelEspecial(int codigo, int qtdeEstoque, String descricao, float precoUnitario) {
		super(codigo, qtdeEstoque, descricao, precoUnitario);
	}

	public void notaControle() {
		System.out.println("Codigo: " + this.codigo + "\n" +
						   "Descricao: " + this.descricao + "\n" + 
							"Qtde Estoque: " + this.qtdeEstoque + "\n"+
						   "Validade: " + this.dataValidade + "\n");
	}
}
