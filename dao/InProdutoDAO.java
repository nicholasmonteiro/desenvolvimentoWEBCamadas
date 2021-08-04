package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produto;


public interface InProdutoDAO {

	
	     // criar o metodo//
		void inserir(Produto _objeto) throws SQLException;
		
		// recuperar um objeto
		Produto  recuperarPeloID(int _id) throws SQLException;
		
		// Lista todos os dados recuperados//
		List<Produto> recuperarTodos() throws SQLException;
		// atualizar dados//
		Boolean atualizar(Produto  _objeto) throws  SQLException;
		
		// deletar dados//
		Boolean deletar(Long _id) throws SQLException;
		
	
	
}
