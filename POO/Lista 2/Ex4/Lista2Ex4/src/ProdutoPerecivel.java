import java.time.LocalDate;


public class ProdutoPerecivel extends Produto {
	
	protected LocalDate dataValidade;

	
	public ProdutoPerecivel(int codigo, int qtdeEstoque, String descricao, float precoUnitario) {
		super(codigo, qtdeEstoque, descricao, precoUnitario);
	}
	
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void retiraEstoque(LocalDate dataRetirada, int qtde) {
		
		if (dataRetirada.plusDays(30).isAfter(this.dataValidade)){
			System.out.println("Zerando o estoque! Produtos vao vencer em 30 dias.");
			this.qtdeEstoque = 0;
		}
		else {
			System.out.printf("Retirando  %d produtos\n", qtde);
			this.qtdeEstoque = this.qtdeEstoque - qtde;
			System.out.printf("Quantidade apos a retirada: %d\n", this.qtdeEstoque);
		}
	}
	
	public boolean insereEstoque(int qtde) {
		if (this.qtdeEstoque == 0) {
			System.out.printf("Inserindo %d produtos no estoque\n", qtde);
			this.qtdeEstoque = qtde;
			System.out.printf("Quantidade de produtos apos inserir no estoque: %d\n", this.qtdeEstoque);
			return true;
		}
		else return false;
	}
	
	
	

}
