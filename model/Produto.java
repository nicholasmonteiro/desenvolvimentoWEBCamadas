package model;

import java.io.Serializable;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String nome;
	private String preco;
	private String marca;
	
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, String preco, String marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	
	}

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getPreco() {
		return preco;
	}

	
	public void setPreco(String preco) {
		this.preco = preco;
	}

	
	public String getMarca() {
		return marca;
	}

	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", marca=" + marca + "]";
	}
	
	
	

	
}
