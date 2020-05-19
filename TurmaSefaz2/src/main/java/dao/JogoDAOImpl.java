package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Jogo;
import entidade.Plataforma;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementação ela recebe no construtor o entityManager,
 *  a conexão com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class JogoDAOImpl implements JogoDAO {

	
	private Long recuperaId() {
		
		String sql = "select s_jogo.nextval from dual";
		
		Long idRetorno = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				idRetorno = res.getLong(1);

			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idRetorno;
	}
	
	
	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Jogo jogo) {
		
		String sql = "INSERT INTO SEFAZ.jogo(id, nome, genero, nome_plataforma) " + 
				"  values(?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			Long id = this.recuperaId();
			
			ps.setLong(1, id);
			ps.setString(2, jogo.getNome());
			ps.setString(3, jogo.getGenero());
			ps.setString(4, jogo.getPlataforma().getNome());

			ps.execute();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

/**
 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
 */
	public void alterar(Jogo jogo) {

//		EntityManager ent = JpaUtil.getEntityManager();
//		EntityTransaction tx = ent.getTransaction();
//		tx.begin();
//		
//		ent.merge(jogo);
//		
//		tx.commit();
//		ent.close();

	}


	public void remover(Jogo jogo) {
		
//		EntityManager ent = JpaUtil.getEntityManager();
//		EntityTransaction tx = ent.getTransaction();
//		tx.begin();
//		
//		ent.remove(jogo);
//		
//		tx.commit();
//		ent.close();
		
	}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Jogo pesquisar(Long id) {
		
//		EntityManager ent = JpaUtil.getEntityManager();
//		Jogo jogo = ent.find(Jogo.class, id);
//		
//		return jogo;
		return null;
//		
	}

/**
 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
 * assim from Usuario, que isso é o objeto usuario e não a tabela
 */
	public List<Jogo> listarTodos() {

//		EntityManager ent = JpaUtil.getEntityManager();
//
//		Query query = ent.createQuery("from Jogo j");
//		
//		List<Jogo> jogos = query.getResultList();
//	
//		return jogos;
		return null;
		
	}
	
	public List<Plataforma> listarPlataformas(){
		
		String sql = "select P.NOME, P.DESCRICAO from PLATAFORMA P";
		
		List<Plataforma> listaPlataformas = new ArrayList<Plataforma>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Plataforma plataforma = new Plataforma();
				plataforma.setNome(res.getString("NOME"));
				plataforma.setDescricao(res.getString("DESCRICAO"));
				
				listaPlataformas.add(plataforma);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPlataformas;
	}

	
	
	
	
	
	
	
	
	
	
}







