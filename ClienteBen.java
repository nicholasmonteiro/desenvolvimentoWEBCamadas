package control;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import javax.faces.model.ListDataModel;

import dao.ClienteDAO;
import dao.FabricaConexao;
import model.Cliente;

import util.JSFMessage;

@ManagedBean(name ="Pag_Cliente")
@ViewScoped

public class ClienteBen {

	
	private List<Cliente> listaClientes;
	private ListDataModel<Cliente> novaListaClientes;
	private Cliente  cliente;
	
	public ClienteBen() {
		// Instanciar back-bean (cliente) não ira retorna nulo
		this.cliente = new Cliente();
		
	}


	public List<Cliente> getListaClientes() {
		
		return listaClientes;
	}


	public void setListaClientes(List<Cliente> listaClientes) {	
		this.listaClientes = listaClientes;
	}


	


	public ListDataModel<Cliente> getNovaListaClientes() {
		return novaListaClientes;
	}


	public void setNovaListaClientes(ListDataModel<Cliente> novaListaClientes) {
		this.novaListaClientes = novaListaClientes;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public void PrepararEditar() {
		this.cliente = novaListaClientes.getRowData();
	}
	
	public void PrepararDeletar() {
		this.cliente = novaListaClientes.getRowData();
	}
	
	public void Clear() {
		this.cliente = new Cliente();
	}
	
	public void PrepararCadastrar() {
		this.cliente= new Cliente();
	}
	
	public void Cadastrar() {
		try {
			
			ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
			
			dao.inserir(this.cliente);
			
			this.listaClientes.add(this.cliente);
			this. novaListaClientes = new ListDataModel<Cliente>(this.listaClientes);
	       JSFMessage.adicionarMensagemDeSucesso("cliente cadastrado com sucesso!");
			       
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void Update() {
         try {
			
			ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
			if(dao.atualizar(this.cliente)) {
							
				JSFMessage.adicionarMensagemDeSucesso("Cliente atualizada com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Deletar() {
		try {

		ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
			if(dao.deletar(this.cliente.getCpf())) {
			
				this.listaClientes.remove(this.cliente);
				this.novaListaClientes= new ListDataModel<Cliente>(this.listaClientes);
				
				JSFMessage.adicionarMensagemDeSucesso("Cliente deletada com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			//Popular Lista de Pessoas
		//	ClienteService serv = new ClienteService();
		  //  this.listaClientes = serv.getListaDeClientes();
			
            ClienteDAO dao = new ClienteDAO(FabricaConexao.fazerConexao());
			
			this.listaClientes = dao.recuperarTodos();
			
		    this.novaListaClientes = new ListDataModel<Cliente>(this.listaClientes);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
