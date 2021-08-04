package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pagamento;



public interface InPagamentoDAO {

	
	// criar o metodo//
		void inserir(Pagamento _objeto) throws SQLException;
		
		// recuperar um objeto
		Pagamento  recuperarPeloID(int _idp) throws SQLException;
		
		// Lista todos os dados recuperados//
		List<Pagamento> recuperarTodos() throws SQLException;
		// atualizar dados//
		Boolean atualizar(Pagamento _objeto) throws  SQLException;
		
		// deletar dados//
		Boolean deletar(int _idp) throws SQLException;
		
		
	
}
