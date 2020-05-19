package dao;

import java.util.List;

import entidade.Livro;



/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementa��o ela recebe no construtor o entityManager,
 *  a conex�o com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class LivroDAOimpl implements LivroDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transi��o, inicia e 
	 * executar a a��o de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Livro livro) {
//		
//		EntityManager ent = JpaUtil.getEntityManager();
//		EntityTransaction tx = ent.getTransaction();
//		tx.begin();
//		
//		ent.persist(livro);
//		
//		tx.commit();
//		ent.close();

	}

/**
 * Metodo alterar, recebe o usuario, criar uma transi��o, inicia e executa a a��o de merger
 */
	public void alterar(Livro livro) {

//		EntityManager ent = JpaUtil.getEntityManager();
//		EntityTransaction tx = ent.getTransaction();
//		tx.begin();
//		
//		ent.merge(livro);
//		
//		tx.commit();
//		ent.close();

	}


/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Livro pesquisar(int id) {
		
//		EntityManager ent = JpaUtil.getEntityManager();
//		Livro livro = ent.find(Livro.class, id);
//		
//		return livro;
		return null;
		
	}

/**
 * O metodo listar todos, faz um select * from, por�m com o JPA, vc faz a consulta pelo objeto direto
 * assim from Usuario, que isso � o objeto usuario e n�o a tabela
 */
	public List<Livro> listarTodos() {

//		EntityManager ent = JpaUtil.getEntityManager();
//
//		Query query = ent.createQuery("from Livro u");
//		
//		List<Livro> livro = query.getResultList();
//	
//		return livro;
		return null;
		
	}

	
	
	
	
	
	
	
	
	
	
}
