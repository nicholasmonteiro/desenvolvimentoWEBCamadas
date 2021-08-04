package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pedido;



public interface InPedidoDAO {

	        // criar o metodo//
			void inserir(Pedido _objeto) throws SQLException;
			
			// recuperar um objeto
			Pedido  recuperarPeloID(int _codigoPe) throws SQLException;
			
			// Lista todos os dados recuperados//
			List<Pedido> recuperarTodos() throws SQLException;
			// atualizar dados//
			Boolean atualizar(Pedido _objeto) throws  SQLException;
			
			// deletar dados//
			Boolean deletar(int _CodigoPe) throws SQLException;
	
	
	
}
