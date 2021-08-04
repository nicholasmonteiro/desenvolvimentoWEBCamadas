package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;


import dao.FabricaConexao;
import dao.ItemDAO;

import model.Item;
import model.Produto;
import util.JSFMessage;
//import util.ItemService;

@ManagedBean(name = "Pag_Item")
@ViewScoped
public class ItemBean {

	private List<Item> listaItens;
	private ListDataModel<Item> novaListaItens;
	private Item item;
	private Produto produto;
	private List<Produto>Produtos;
	
	// Item{	
	//Produto,
	//valor * valorProduto,
	//qtdProduto,
      // }
	//intensProdutos.add(item)
	public ItemBean() {
		
		// Instanciar back-bean (item) não ira retorna nulo
		this.item = new Item();
		
	}

	

	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public List<Produto> getProdutos() {
		return Produtos;
	}



	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}



	public List<Item> getListaItens() {
		return listaItens;
	}



	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}



	public ListDataModel<Item> getNovaListaItens() {
		return novaListaItens;
	}



	public void setNovaListaItens(ListDataModel<Item> novaListaItens) {
		this.novaListaItens = novaListaItens;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public void PrepararEditar() {
		this.item = novaListaItens.getRowData();
	}
	
	public void PrepararDeletar() {
		this.item = novaListaItens.getRowData();
	}
	
	public void Clear() {
		this.item = new Item();
	}
	
	public void PrepararCadastrar() {
		this.item= new Item();
	}
	
	public void Cadastrar() {
		try {
			
            ItemDAO dao = new ItemDAO(FabricaConexao.fazerConexao());
          
			
           
			dao.inserir(this.item);
			
			
			this.listaItens.add(this.item);
			this.novaListaItens = new ListDataModel<Item>(this.listaItens);
			
			
		 
	        
			
			JSFMessage.adicionarMensagemDeSucesso("Compra Adcionada na lista com sucesso!");
			
		} catch (Exception e) {
			
		}
	}
	
	public void Update() {
		try {
			JSFMessage.adicionarMensagemDeSucesso(" atualizada compra com sucesso!");
			
		} catch (Exception e) {
		
		}
	}
	
	public void Deletar() {
		try {

			this.listaItens.remove(this.item);
			
			this.novaListaItens = new ListDataModel<Item>(this.listaItens);
			
			JSFMessage.adicionarMensagemDeSucesso("Compra deletada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			
		
	        ItemDAO dao = new ItemDAO(FabricaConexao.fazerConexao());
	        
	     
		    this.listaItens = dao.recuperarTodos();	
	
		       	    
			
			this.novaListaItens = new ListDataModel<Item>(this.listaItens);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
