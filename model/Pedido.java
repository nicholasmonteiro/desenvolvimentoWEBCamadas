package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigoPe;
	private String numero;
	private String valorP;
    
	
	private List<Cliente>Clientes;
	
	public Pedido() {
		
		this.Clientes = new ArrayList<Cliente>();
		
	}
	
	
	
	
	public Pedido(int codigoPe ,String numero,String valorP,List<Cliente>Clientes) {
		super();
		this.codigoPe = codigoPe;
		this.numero = numero;
		this.valorP = valorP;
		this.Clientes = Clientes;
				
	}

		
	
	public int getCodigoPe() {
		return codigoPe;
	}

	
	public void setCodigoPe(int codigoPe) {
		this.codigoPe = codigoPe;
	}

	

	
	public String getNumero() {
		
		return numero;
	}

	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public String getValorP() {
		return valorP;
	}

	
	public void setValorP(String valorP) {
		this.valorP = valorP;
	}

	

	

	public List<Cliente> getClientes() {
		return Clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoPe;
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
		Pedido other = (Pedido) obj;
		if (codigoPe != other.codigoPe)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pedido [codigoPe=" + codigoPe + ", numero=" + numero + ", valorP=" + valorP + ", Clientes=" + Clientes
				+ "]";
	}

	
	
}
