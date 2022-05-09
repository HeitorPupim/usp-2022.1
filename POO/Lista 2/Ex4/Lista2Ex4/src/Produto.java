
public class Produto {
	protected int codigo, qtdeEstoque;
	protected String descricao;
	protected float precoUnitario;
	
	public Produto(int codigo, int qtdeEstoque, String descricao, float precoUnitario){
		this.codigo = codigo;
		this.qtdeEstoque = qtdeEstoque;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public boolean insereEstoque(int qtde){
		this.qtdeEstoque = this.qtdeEstoque + qtde;
		System.out.printf("Nova quantidade em estoque: %d\n", this.qtdeEstoque);
		return true;
	}
	
	public void retiraEstoque(int qtde) {
		System.out.printf("Quantidade disponivel antes da retirada: %d\n", this.qtdeEstoque);
		this.qtdeEstoque = this.qtdeEstoque - qtde;
		
		if (qtde > this.qtdeEstoque){
			System.out.printf("Quantidade retirada: %d\n", this.qtdeEstoque);
			this.qtdeEstoque = 0;
		}
		else {
			this.qtdeEstoque = this.qtdeEstoque - qtde;
			System.out.printf("Quantidade retirada: %d\n", qtde);
		}
	}

	
	public String toString() {
		return "Produto [codigo=" + codigo + ", qtdeEstoque=" + qtdeEstoque + ", descricao=" + descricao
				+ ", precoUnitario=" + precoUnitario + "]";
	}
	
	
	
}
