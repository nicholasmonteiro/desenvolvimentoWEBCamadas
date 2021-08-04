package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.ClienteDAO;
import dao.FabricaConexao;
import dao.PagamentoDAO;

import model.Pagamento;
//import util.PagamentoService;
import util.JSFMessage;


@ManagedBean(name ="Pag_Pagamento")
@ViewScoped

public class PagamentoBen {

	private List<Pagamento> listaPagamentos;
	private ListDataModel<Pagamento> novaListaPagamentos;
	private Pagamento pagamento;
	
	
	public PagamentoBen() {
		
		
		this.pagamento = new Pagamento();
		
	}


	public List<Pagamento> getListaPagamentos() {
		return listaPagamentos;
		
	}


	public void setListaPagamentos(List<Pagamento> listaPagamentos) {
		this.listaPagamentos = listaPagamentos;
		
		
	}



	public ListDataModel<Pagamento> getNovaListaPagamentos() {
		return novaListaPagamentos;
		
	}



	public void setNovaListaPagamentos(ListDataModel<Pagamento> novaListaPagamentos) {
		this.novaListaPagamentos = novaListaPagamentos;
		
	}


	public Pagamento getPagamento() {
		return pagamento;
		
	}



	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
		
	}

	public void Cadastrar() {
		try {
			
			PagamentoDAO dao = new PagamentoDAO(FabricaConexao.fazerConexao());
			
			dao.inserir(this.pagamento);
			
			this.listaPagamentos.add(this.pagamento);
			this.novaListaPagamentos = new ListDataModel<Pagamento>(this.listaPagamentos);
			
			
		
			JSFMessage.adicionarMensagemDeSucesso("cliente cadastrado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void Update() {
        try {
			
			PagamentoDAO dao = new PagamentoDAO(FabricaConexao.fazerConexao());
			if(dao.atualizar(this.pagamento)) {
							
				JSFMessage.adicionarMensagemDeSucesso("cartao atualizada com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@PostConstruct
	public void iniciar() {
		try {
			//Popular Lista de Pessoas
		//	PagamentoService serv = new PagamentoService();
			//this.listaPagamentos = serv.getListaDeEntregas();
		   // this.novaListaPagamentos = new ListDataModel<Pagamento>(this.listaPagamentos); 

			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
