public class Mouse extends Produto {

	String tipoMouse = "tipo optico";
	
	public Mouse(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao + "; " + this.tipoMouse;
	}

}
