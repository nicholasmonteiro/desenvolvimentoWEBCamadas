package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.PedidoDAO;
import model.Pedido;
import util.JSFMessage;


@ManagedBean(name = "Pag_Pedido")
@ViewScoped
public class PedidoBen {

	private List<Pedido> listaPedidos;
	private ListDataModel<Pedido> novaListaPedidos;
	private Pedido pedido;
	

    public PedidoBen(){
	 

 }

	
 
    public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public ListDataModel<Pedido> getNovaListaPedidos() {
		return novaListaPedidos;
	}



	public void setNovaListaPedidos(ListDataModel<Pedido> novaListaPedidos) {
		this.novaListaPedidos = novaListaPedidos;
	}



	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}



	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public void PrepararDeletar() {
		this.pedido = novaListaPedidos.getRowData();
	}
	
	
	public void PrepararEditar() {
		this.pedido = novaListaPedidos.getRowData();
	}
	
	
	
	public void Deletar() {
		try {

			this.listaPedidos.remove(this.pedido);
			
			this.novaListaPedidos = new ListDataModel<Pedido>(this.listaPedidos);
			
			JSFMessage.adicionarMensagemDeSucesso("Pessoa deletada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	@PostConstruct
    public void iniciar() {
    	
  	try {
			//Popular Lista de Produtos
  	//	PedidoService serv = new PedidoService(5);
  		
  		PedidoDAO dao = new PedidoDAO(FabricaConexao.fazerConexao());
		
		this.listaPedidos = dao.recuperarTodos();
		
		this.novaListaPedidos = new ListDataModel<Pedido>(this.listaPedidos);
		
		
	  } catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
      }
    
    
	} 
    
    
