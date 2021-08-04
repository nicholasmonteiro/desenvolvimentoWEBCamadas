package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Pedido;

public class PedidoDAO implements InPedidoDAO {

	// paramentro para conectar com o banco dados//
	private Connection conexao;
	
	public PedidoDAO(Connection _conexao) {
		
		this.conexao = _conexao;
		
	}
	
	
	@Override
	public void inserir(Pedido _objeto) throws SQLException {
	

	}

	@Override
	public Pedido recuperarPeloID(int _codigoPe) throws SQLException {
		
		return null;
	}

	@Override
	public List<Pedido> recuperarTodos() throws SQLException {
		
		
	List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		

        	String SQL = "SELECT "
		        	+ "*"
			        + " FROM pedido";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			 int codigoPe = rs.getInt(1);
			 String numero = rs.getString("numero");
			 String ValorP = rs.getString("valorP");
			
		
			ClienteDAO daoEnd = new ClienteDAO(this.conexao);
			
	     	Pedido p = new Pedido(codigoPe, numero, ValorP, daoEnd.recuperarTodos());
			
			
			listaPedidos.add(p);
		}
		
		
		//Retorno do Método
		return listaPedidos;
	}
		

	@Override
	public Boolean atualizar(Pedido _objeto) throws SQLException {

		return null;
	}

	@Override
	public Boolean deletar(int _CodigoPe) throws SQLException {
		
		return null;
	}

	
	public List<Pedido> recuperarPedidosPorCliente(Long _cpf) throws SQLException {

		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM pedido WHERE cliente_cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _cpf);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			Pedido pedido = new Pedido(0, SQL, SQL, null);
			
			pedido = new Pedido(0, SQL, SQL, null);
			pedido.setCodigoPe(rs.getInt(1));
			pedido.setNumero(rs.getString(2));
			pedido.setValorP(rs.getString(3));
			
		
			
			listaPedidos.add(pedido);
		}
		
		
		//Retorno do Método
		return listaPedidos;
	}
}
