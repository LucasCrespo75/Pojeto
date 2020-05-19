package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Usuario;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *         Essa classe implementa a interface, todos os metodos mostrados na
 *         interface. Lembrando de uma coisa, a implementação ela recebe no
 *         construtor o entityManager, a conexão com o banco de dados, deixando
 *         assim essa classe totalemnte independente
 *
 */

public class UsuarioDAOImpl implements UsuarioDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia
	 * e executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Usuario usuario) {

		String sql = "insert into USUARIO (ID_cpf, email, senha) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setLong(1, usuario.getCpf());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a
	 * ação de merger
	 */


	public void remover(Usuario usuario) {

		String sql = "DELETE FROM USUARIO WHERE cpf = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setLong(1, usuario.getCpf());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
	public Usuario pesquisar(Long cpf) {

		String sql = "select U.ID_CPF, U.EMAIL, U.SENHA from USUARIO U where ID_cpf = ?";
		
		Usuario usuario = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setLong(1, cpf);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				usuario = new Usuario();
				usuario.setCpf(res.getLong("CPF"));
				usuario.setEmail(res.getString("Email"));
				usuario.setSenha(res.getString("SENHA"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a
	 * consulta pelo objeto direto assim from Usuario, que isso é o objeto usuario e
	 * não a tabela
	 */
	public List<Usuario> listarTodos() {

		String sql = "select U.ID_CPF, U.EMAIL, U.SENHA from USUARIO U";
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setCpf(res.getLong("CPF"));
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setSenha(res.getString("SENHA"));
				
				listaUsuarios.add(usuario);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUsuarios;

	}

}






























//package dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;

//import util.JpaUtil;

//import entidade.Usuario;
//import oracle.net.aso.e;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementação ela recebe no construtor o entityManager,
 *  a conexão com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

//public class UsuarioDAOImpl implements UsuarioDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	//public void inserir(Usuario usuario) {
		
	//	String sql = "insert into SEFAZ.usaurio(cpf, nome, senha) values (?,?,?)";
			
	//	try {
		//	Connection conexao = JpaUtil.getConexao();
		//	PreparedStatement ps = conexao.prepareStatement(sql);
		
	//	ps.setString(1, usuario.getCpf());
	//	ps.setString(2, usuario.getNome());
		//ps.setString(3, usuario.getSenha());
		
	//	ps.executeUpdate();
	//	ps.close();
		
	//}catch(SQLException e){
//		e.printStackTrace();
	//	
//	}
//
//	}

		
		//EntityManager ent = JpaUtil.getEntityManager();
		//EntityTransaction tx = ent.getTransaction();
		//tx.begin();
		
		//ent.persist(usuario);
		
		//tx.commit();
		//ent.close();

	

/**
 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
 */
//	public void alterar(Usuario usuario) {

			
	//		String sql = "UPDATE SEFAZ.usaurio SET nome = ?, senha = ? where cpf = ?";
				
		//	try {
		//		Connection conexao = JpaUtil.getConexao();
		//		PreparedStatement ps = conexao.prepareStatement(sql);
			
		//	ps.setString(1, usuario.getNome());
		//	ps.setString(2, usuario.getSenha());
		//	ps.setString(3, usuario.getCpf());
			
		//	ps.executeUpdate();
		//	ps.close();
			
	//	}catch(SQLException e){
		//	e.printStackTrace();
			
	//	}

//	}


	//public void remover(Usuario usuario) {
		

//String sql = "DELETE FROM SEFAZ.usuario WHERE cpf = ?;";
	
//try {
	//Connection conexao = JpaUtil.getConexao();
	
	//PreparedStatement ps = conexao.prepareStatement(sql);

//ps.setString(1, usuario.getCpf());

//ps.execute();
//ps.close();

//}catch(SQLException e){
//e.printStackTrace();

//}

//}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
//	public Usuario pesquisar(String cpf) {
		

		
	//	String sql = "SELECT U.CPF, U.CPF, U.NOME FROM  SEFAZ.usuario U  cpf = ?";
		
		
		//Usuario.usuario = null
		//try {
		//	Connection conexao = JpaUtil.getConexao();
			
			//PreparedStatement ps = conexao.prepareStatement(sql);
	
	//  ResultSet rs = ps.executeQuery();
	
	   
	//	while(rs.next()) {
			
		
		//	System.out.println("CPF:" + rs.setInt(1));
			//System.out.println("NOME:" + rs.setString(2));
			//System.out.println("SENHA:" + rs.setString(3));
			//System.out.println("----------------------------------");
			
			
			//ps.setString(1, cpf);

			//ps.execute();
			//ps.close();

			//}catch(SQLException e){
			//e.printStackTrace();

	   
	   
	   
/**
 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
 * assim from Usuario, que isso é o objeto usuario e não a tabela
 */
//	public List<Usuario> listarTodos() {

	//	EntityManager ent = JpaUtil.getEntityManager();

	//	Query query = ent.createQuery("from Usuario u");
		
		//List<Usuario> usuarios = query.getResultList();
	
	//	return usuarios;
		
//	}
//
	
	
	
	
	
	
	
	
	
	
//}

