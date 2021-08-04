package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagamento  implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idP;
	private String cartao;
	private int pedido_codigoPe;
	

      
    ///Processo Unidirecional to acessando classe pedido
	private List<Pedido>pedidos;
	
    
    
	public Pagamento (){ 
		
		this.pedidos = new ArrayList<Pedido>();
		
		
	}
	
	public Pagamento(int idP, String cartao,int pedido_codigoPe, List<Pedido>pedidos ) {
		super();
		this.idP = idP;
		this.cartao = cartao;
		this.pedido_codigoPe = pedido_codigoPe;	
		this.pedidos = pedidos;
	
	}


	public List<Pedido> getPedidos() {
		
		return pedidos;
		
	}

	public void setPedidos(List<Pedido> pedidos) {
		
		this.pedidos = pedidos;
	
	}

	
	
	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	

	

	public int getPedido_codigoPe() {
		return pedido_codigoPe;
		
	}

	
	public void setPedido_codigoPe(int pedido_codigoPe) {
		this.pedido_codigoPe = pedido_codigoPe;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idP;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (idP != other.idP)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagamento [idP=" + idP + ", cartao=" + cartao + ", pedido_codigoPe=" + pedido_codigoPe + ", pedidos="
				+ pedidos + "]";
	}

	
	
	
	

}