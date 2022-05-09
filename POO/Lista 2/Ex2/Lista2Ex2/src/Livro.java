
public class Livro extends Produto {

	protected String autor = "autor: Machado de Assis";

	public Livro(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return (this.descricao + "; " + this.autor);
	}
	
}
