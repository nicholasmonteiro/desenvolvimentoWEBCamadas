package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface InClienteDAO {

	
	
	// criar o metodo//
	void inserir(Cliente  _objeto) throws SQLException;
	
	// recuperar um objeto
	Cliente  recuperarPeloID(int _cpf) throws SQLException;
	
	// Lista todos os dados recuperados//
	List<Cliente> recuperarTodos() throws SQLException;
	// atualizar dados//
	Boolean atualizar(Cliente _objeto) throws  SQLException;
	
	// deletar dados//
	Boolean deletar(Long _cpf) throws SQLException;
	
	
}
