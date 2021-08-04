package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.ProdutoDAO;
import model.Produto;
//import util.ProdutoService;

@ManagedBean(name = "Pag_Produto")
@ViewScoped
public class ProdutoBen {

	private List<Produto> listaProdutos;
	private ListDataModel<Produto> novalistaProdutos;
	private Produto produto;
	

    public ProdutoBen(){
	 
    	/// por valor nao volta nullo//
    	
    	this.produto = new Produto();
    	
 }

    
    
	public ListDataModel<Produto> getNovalistaProdutos() {
		return novalistaProdutos;
		
	}


	public void setNovalistaProdutos(ListDataModel<Produto> novalistaProdutos) {
		this.novalistaProdutos = novalistaProdutos;
		
	}


	public Produto getProduto() {
		return produto;
	}




	public void setProduto(Produto produto) {
		this.produto = produto;
	}




	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}


	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
 
    @PostConstruct
    public void iniciar() {
    	
    	try {
			//Popular Lista de Produtos
	//	ProdutoService serv = new ProdutoService(5);
	//	this.listaProdutos = serv.getListaProdutos();
          ProdutoDAO dao = new ProdutoDAO(FabricaConexao.fazerConexao());
			
			this.listaProdutos = dao.recuperarTodos();
			
			this.novalistaProdutos = new ListDataModel<Produto>(this.listaProdutos);
			
			//this. = new ListDataModel<>(this.listaProdutos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
    
    
}