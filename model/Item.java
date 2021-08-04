package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int produto_id;
	private int pedido_codigoPe;
	private String qtd;
	private String nome;
	//Relacionamento Unidirecional com a classe produto
	private List<Produto> produtos;
	private Produto produto_padrao;
	

	
	public Item() { 
		this.produtos = new ArrayList<Produto>();
		this.produto_padrao = new Produto();
	}
	
	public Item(int produto_id,int pedido_codigoPe ,String qtd,  String nome,Produto produto_padrao ,List<Produto> produtos) {
		super();
		
		this.produto_id = produto_id;
		this.pedido_codigoPe = pedido_codigoPe;
		this.qtd = qtd;
		this.nome = nome;
		this.produto_padrao = produto_padrao;
		this.produtos = produtos;
		
	}

	
	public int getProduto_id() {
		return produto_id;
		
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
		
	}

	
	public int getPedido_codigoPe() {
		return pedido_codigoPe;
	}
	

	public void setPedido_codigoPe(int pedido_codigoPe) {
		this.pedido_codigoPe = pedido_codigoPe;
		
	}

	public String getQtd() {
			return qtd;
			
	}

	
	public void setQtd(String qtd) {
		this.qtd = qtd;
		
	}

	
	
	public String getNome() {
		return nome;
	}

	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	


	public Produto getProduto_padrao() {
		
		return produto_padrao;
		
	}

	public void setProduto_padrao(Produto produto_padrao) {
		
		this.produto_padrao = produto_padrao;
		
		
	}
	
	
	public List<Produto> getProdutos() {
		return produtos;
		
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pedido_codigoPe;
		result = prime * result + produto_id;
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
		Item other = (Item) obj;
		if (pedido_codigoPe != other.pedido_codigoPe)
			return false;
		if (produto_id != other.produto_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [produto_id=" + produto_id + ", pedido_codigoPe=" + pedido_codigoPe + ", qtd=" + qtd + ", nome="
				+ nome + ", produtos=" + produtos + ", produto_padrao=" + produto_padrao + "]";
	}

	
	
		
	
}
	