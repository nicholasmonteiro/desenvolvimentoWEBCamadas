package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO implements InClienteDAO {

	// paramentro para conectar com o banco dados//
	private Connection conexao;
	
	public ClienteDAO(Connection _conexao) {
		
		this.conexao = _conexao;
		
	}
	
	
	@Override
	public void inserir(Cliente _objeto) throws SQLException {
		

	String SQL = "INSERT INTO cliente (cpf, nome, cel, endereco, email ) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setLong(1, _objeto.getCpf());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getCel());
		ps.setString(4, _objeto.getEndereco());
		ps.setString(5, _objeto.getEmail());
		
		ps.execute();
		
	}

	
	
	
	@Override
	public Cliente recuperarPeloID(int _cpf) throws SQLException {
	
		return null;
	}

	@Override
	public List<Cliente> recuperarTodos() throws SQLException {
		
      List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "cpf, nome, cel, endereco,email "
				+ " FROM cliente";
		
		// prepara o ambiente para execurção//
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			Long cpf = rs.getLong(1);
			String nome = rs.getString(2);
			String cel = rs.getString("cel");
			String endereco = rs.getString("endereco");
			String email = rs.getString("email");
			//int endPadrao = rs.getInt("end_padrao");
			
			
			Cliente p = new Cliente(cpf, nome, cel, endereco, email);
			
			listaClientes.add(p);
		}
		
		
		//Retorno do Método
		return listaClientes;
	}
	

	@Override
	public Boolean atualizar(Cliente _objeto) throws SQLException {
	
		String SQL = "UPDATE cliente SET  nome = ?, cel = ?, endereco = ?, email = ? WHERE cpf = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

	       ps.setString(1,  _objeto.getNome());
	       ps.setString(2, _objeto.getCel());
	       ps.setString(3, _objeto.getEndereco());
	       ps.setString(4, _objeto.getEmail());
	       ps.setLong(5, _objeto.getCpf());
		

		return ps.execute();
	}

	@Override
	public Boolean deletar(Long  _cpf) throws SQLException {
		
       String SQL = "DELETE FROM cliente WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _cpf);
		
	    return ps.execute();
		
	}

}
