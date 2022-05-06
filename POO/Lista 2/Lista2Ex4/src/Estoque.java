import java.util.ArrayList;

public class Estoque {

	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	public void cadastrarProduto(Produto produto){
		listaProdutos.add(produto);
		
	}
	
	public void consultarProdutos(int codigo) {
		boolean aux = false;
		for (int i = 0; i < listaProdutos.size(); i++){
			if (listaProdutos.get(i).getCodigo() == codigo){
				//produto encontrado:
				System.out.println(listaProdutos.get(i).toString()); 
				aux = true;
				break;
			}
		}
		if (aux == false) {
			System.out.println("null");
		}   
	}
	
	public void retirarProduto(int codigo, int qtde){
		boolean aux = false;
		for (int i = 0; i < listaProdutos.size(); i++){
			if (listaProdutos.get(i).getCodigo() == codigo){
				//produto encontrado:
				listaProdutos.get(i).retiraEstoque(qtde);
				aux = true;
				break;
			}
		}
		if (aux == false) {
			System.out.println("null");
		} 
	}
	
	public void custoTotal(){
		float valorTotal = 0;
		for (int i = 0; i < listaProdutos.size(); i++){
			valorTotal += (listaProdutos.get(i).getPrecoUnitario()) * (listaProdutos.get(i).getQtdeEstoque());
		}
		System.out.printf("Valor total do estoque: %f\n", valorTotal);
	}
	
	public void descricaoProdutos() {
		System.out.println("Lista de Produtos:");
		
		for (int i = 0; i < listaProdutos.size(); i++){
			System.out.println(listaProdutos.get(i).getDescricao());
		}
	}
}

