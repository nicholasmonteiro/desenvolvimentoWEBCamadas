package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO implements InProdutoDAO {

	private Connection conexao;

	public ProdutoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	
	@Override
	public void inserir(Produto _objeto) throws SQLException {
		
        
	}

	@Override
	public Produto recuperarPeloID(int _id) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM produto WHERE id = " + _id;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Produto produto = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			
			produto = new Produto();
			
			produto.setId(rs.getInt(1));
			produto.setNome(rs.getString(2));
			produto.setPreco(rs.getString(3));	
			produto.setMarca(rs.getString(4));
			
		
			
			//int id = rs.getInt(1);
			//String nome = rs.getString(2);
			///String preco = rs.getString("preco");
			///String marca = rs.getString("marca");
		
			//int endPadrao = rs.getInt("end_padrao");
			
			//p = new Produto(id, nome, preco, marca );
		}
		
		return produto;
		//return p;
	}

	@Override
	public List<Produto> recuperarTodos() throws SQLException {
		
      List<Produto> listaProdutos = new ArrayList<Produto>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "id, nome, preco, marca"
				+ " FROM produto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String preco = rs.getString("preco");
			String marca = rs.getString("marca");
			
		
			Produto p = new Produto(id, nome, preco, marca);
	
			listaProdutos.add(p);
		}
		
		
		//Retorno do Método
		return listaProdutos;
	}

	@Override
	public Boolean atualizar(Produto _objeto) throws SQLException {
	
		return null;
	}

	@Override
	public Boolean deletar(Long _id) throws SQLException {
		
		return null;
		
	}
	
	
	

}
