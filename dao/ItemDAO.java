package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Item;
import model.Produto;

public class ItemDAO implements InItemDAO {

	
	// paramentro para conectar com o banco dados//
		private Connection conexao;
		
		public ItemDAO(Connection _conexao) {
			
			this.conexao = _conexao;
			
		}
			
	
	@Override
	public void inserir(Item _objeto) throws SQLException {
		

		String SQL = "INSERT INTO item (produto_id,pedido_codigoPe, qtd, nome ) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(1, _objeto.getProduto_id());
			ps.setInt(2, _objeto.getPedido_codigoPe() );
			ps.setString(3, _objeto.getQtd());
			ps.setString(4, _objeto.getNome());
			
			
			ps.execute();
			
		
	}

	@Override
	public Item recuperarPeloID(int _id) throws SQLException {

	
		
		String SQL = "SELECT "
				+ "produto_id, pedido_codigoPe, qtd, nome "
				+ " FROM item WHERE produto_id = " + _id;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Item i = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			
			int produto_id = rs.getInt(1);
			int pedido_codigoPe = rs.getInt(2);
			String qtd = rs.getString("qtd");
			String nome = rs.getString("email");
	    	
		
			ProdutoDAO daoEnd = new ProdutoDAO(this.conexao);
		
			
			i = new Item(produto_id, pedido_codigoPe, qtd, nome,new Produto(), daoEnd.recuperarTodos());
			
		}
		
		return i;
		
		
	}

	@Override
	public List<Item>recuperarTodos() throws SQLException {
		
		  List<Item> listaItems = new ArrayList<Item>();
			
			//Preenchimento da Lista para retorno da Camada Requisitante
			
			String SQL = "SELECT "
					+ "produto_id, pedido_codigoPe, qtd, nome"
					+ " FROM item";
			
			// prepara o ambiente para execurção//
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
			while(rs.next()) {
				int produto_id = rs.getInt(1);
				int pedido_codigoPe = rs.getInt(2);
				String qtd = rs.getString("qtd");
				String  nome = rs.getString("nome");
			//	int  produto_padrao = rs.getInt("produto_padrao");
			
				
			  ProdutoDAO daoEnd = new ProdutoDAO(this.conexao);
		
				
			//	Item i = new Item(produto_id, pedido_codigoPe, qtd, nome, null, null);
				 
				Item i = new Item(produto_id, pedido_codigoPe, qtd, nome, new Produto(), daoEnd.recuperarTodos());
			
				
			  listaItems.add(i);
				
			   
			}
			
	
			
			//Retorno do Método
			return listaItems;
	}

	@Override
	public Boolean atualizar(Item _objeto) throws SQLException {
		
		return null;
	}

	@Override
	public Boolean deletar(int _id) throws SQLException {
	
		return null;
	}

	public List<Item> recuperarIntensPorProduto(int _id) throws SQLException {

		List<Item> listaItens = new ArrayList<Item>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM item WHERE produto_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			Item item = new Item();
					
			item = new Item();
			
			item.setProduto_id(rs.getInt(1));
			item.setPedido_codigoPe(rs.getInt(2));
			item.setQtd(rs.getString(rs.getString(3)));
			item.setNome(rs.getString(rs.getString(4)));
			
			
			listaItens.add(item);
		}
		
		
		//Retorno do Método
		return listaItens;
	}
	
}
