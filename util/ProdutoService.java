package util;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoService {

	private List<Produto> listaProdutos;
	
	public ProdutoService(int _qtd_valores) {
	
		this.listaProdutos = new ArrayList<Produto>();
		
		for (int i = 1; i <= _qtd_valores; i++) {
					
			Produto end = new Produto();
			
			end.setId(i);
			end.setNome("Pizaa" + i);
			end.setPreco("15," + i + "0" );
			end.setMarca("Seara" + i);
		
			listaProdutos.add(end);
				
		}
	
	}
	
	
	
	


	//public ProdutoService() {
		
		
		//listaProdutos.add(new Produto(1, "Teste1", "(21) 11111-1111", "teste1@gmail.com"));
		//listaProdutos.add(new Produto(2, "Teste2", "(21) 21111-1111", "teste2@gmail.com"));
		//listaProdutos.add(new Produto(3, "Teste3", "(21) 31111-1111", "teste3@gmail.com"));
		//listaProdutos.add(new Produto(4, "Teste4", "(21) 41111-1111", "teste4@gmail.com"));
		
		
	//}






	public List<Produto>getListaProdutos() {
		return listaProdutos;
	}	
}
