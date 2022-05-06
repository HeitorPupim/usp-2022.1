import java.time.LocalDate;

public class Programa {

	public static void main(String[] args) {
		
		//produto perecivel
		ProdutoPerecivel banana = new ProdutoPerecivel(1, 10, "banana", 3.50f);
		LocalDate dataValidade = LocalDate.of(2022, 05, 06);
		banana.setDataValidade(dataValidade);
		
		//produto perecivel especial
		ProdutoPerecivelEspecial pessego = new ProdutoPerecivelEspecial(2, 30, "pessego", 2.50f);
		LocalDate dataValidade2 = LocalDate.of(2022, 12, 06);
		pessego.setDataValidade(dataValidade2);
		
		//produto nao perecivel
		ProdutoNaoPerecivel geladeira = new ProdutoNaoPerecivel(3,2,"geladeira", 1400.25f, 5);
		
		Estoque estoque = new Estoque();
		
		estoque.cadastrarProduto(banana);
		estoque.cadastrarProduto(geladeira);
		estoque.cadastrarProduto(pessego);
		
		estoque.consultarProdutos(3);
		
		estoque.custoTotal();
		estoque.descricaoProdutos();
	}

}
