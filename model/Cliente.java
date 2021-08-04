package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements  Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	private Long cpf;
	private String nome;
	private String cel;
	private String endereco;
	private String email;
	
	/// Relacionando a classe pedido
	
	
	
	
	
	public Cliente (){
		
		
	}
		
		
	
	public Cliente(Long cpf,String nome, String cel,String endereco,String email) {
		super();
		
		this.cpf =cpf;
		this.nome = nome;
		this.cel = cel;
		this.endereco = endereco;
		this.email = email;
		
		
	
		
				
	}


	



	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	

	public Long getCpf() {
		return cpf;
	}



	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCel() {
		return cel;
	}


	public void setCel(String cel) {
		this.cel = cel;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}



	@Override
	public String toString() {
		
		return nome + " , " +  cel  + "/"  + email ;
	}

	
	
}
