package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Pagamento;

public class PagamentoDAO implements InPagamentoDAO {

	
	
	// paramentro para conectar com o banco dados//
		private Connection conexao;
		
		public PagamentoDAO(Connection _conexao) {
			
			this.conexao = _conexao;
			
		}
		
	
	@Override
	public void inserir(Pagamento _objeto) throws SQLException {
		

        String SQL = "INSERT INTO pagamento (cartao, pedido_codigoPe ) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getCartao());
		ps.setInt(2, _objeto.getPedido_codigoPe());

		
		
		ps.execute();
		
	}

	
	
	
	@Override
	public Pagamento recuperarPeloID(int _idp) throws SQLException {
	
		return null;
	}

	@Override
	public List<Pagamento> recuperarTodos() throws SQLException {
		
		return null;
	}

	@Override
	public Boolean atualizar(Pagamento _objeto) throws SQLException {
		
	
		String SQL = "UPDATE pagamento SET  cartao = ?, pedido_codigoPe = ? WHERE idP = ?";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

	     
		     ps.setString(1, _objeto.getCartao());
		     ps.setInt(2, _objeto.getPedido_codigoPe());
		     ps.setInt(3, _objeto.getIdP());
		
		

		return ps.execute();
		
	
	}

	@Override
	public Boolean deletar(int _idp) throws SQLException {
		
		return null;
	}

}
