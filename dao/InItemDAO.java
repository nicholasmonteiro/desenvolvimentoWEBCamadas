package dao;

import java.sql.SQLException;
import java.util.List;

import model.Item;


public interface InItemDAO {

	  // criar o metodo//
			void inserir(Item _objeto) throws SQLException;
			
			// recuperar um objeto
			Item  recuperarPeloID(int _id) throws SQLException;
			
			// Lista todos os dados recuperados//
			List<Item> recuperarTodos() throws SQLException;
			// atualizar dados//
			Boolean atualizar(Item  _objeto) throws  SQLException;
			
			// deletar dados//
			Boolean deletar(int _id) throws SQLException;
			
	
	
	
}
