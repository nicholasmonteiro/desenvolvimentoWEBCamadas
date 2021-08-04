package util;


import java.util.ArrayList;
import java.util.List;


import model.Pagamento;


public class PagamentoService {

	
private List<Pagamento> listaDePagamentos;
	
	public PagamentoService() {
		
		this.listaDePagamentos= new ArrayList<Pagamento>();
		
		for (int i = 1; i <= 5; i++) {
			
			Pagamento p = new Pagamento();
			
			p.setIdP (i);
			p.setCartao("7877" + i);
			PedidoService serv = new PedidoService(i -1);
			
		    p.setPedidos(serv.getListaPedidos());
			
		  
		
			
			
			
		    listaDePagamentos.add(p);
		}
		
	}

	public List<Pagamento>getListaDeEntregas() {
		return listaDePagamentos;
	}
	
}
