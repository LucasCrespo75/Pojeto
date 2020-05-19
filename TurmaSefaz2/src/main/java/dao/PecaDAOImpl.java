
	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import entidade.Peca;
import entidade.Veiculo;
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

     public class PecaDAOImpl  implements PecaDAO {
		
		/**
		 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
		 * executar a ação de persistir, tudo dando certo realiza o commit no final
		 */
		public void inserir(Peca peca) {
			
			String sql = "INSERT INTO pecas(ID_nome, marca_peca, ano_peca, modelo_veiculo)  values(?, ?, ?, ?)";

			Connection conexao;
			try {
				
				conexao = JpaUtil.getConexao();
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, peca.getNome());
				ps.setString(3, peca.getMarca_peca());
				ps.setInt(4, peca.getAno());
				ps.setString(5, peca.getVeiculo().getModelo());

				ps.execute();
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	/**
	 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
	 */
		public void alterar(Peca peca) {

//			EntityManager ent = JpaUtil.getEntityManager();
//			EntityTransaction tx = ent.getTransaction();
//			tx.begin();
//			
//			ent.merge(jogo);
//			
//			tx.commit();
//			ent.close();

		}


		public void remover(Peca peca) {
			
//			EntityManager ent = JpaUtil.getEntityManager();
//			EntityTransaction tx = ent.getTransaction();
//			tx.begin();
//			
//			ent.remove(jogo);
//			
//			tx.commit();
//			ent.close();
			
		}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
		public Peca pesquisar(String id) {
	
			
//			EntityManager ent = JpaUtil.getEntityManager();
//			Jogo jogo = ent.find(Jogo.class, id);
//			
//			return jogo;
			return null;
//			
		}

	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
	 * assim from Usuario, que isso é o objeto usuario e não a tabela
	 */
		public List<Peca> listarTodas() {

//			EntityManager ent = JpaUtil.getEntityManager();
	//
//			Query query = ent.createQuery("from Jogo j");
//			
//			List<Jogo> jogos = query.getResultList();
	//	
//			return jogos;
			return null;
			
		}
		//PEÇAS, FAZER LISTA
		public List<Veiculo> listaVeiculos(){
			
			String sql = " select V.modelo, V.nome, V.ano from Veiculo V";
			
			List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
			
			Connection conexao;
			try {
				conexao = JpaUtil.getConexao();
				
				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet res = ps.executeQuery();

				while (res.next()) {
			
					Veiculo veiculo = new Veiculo();
					Peca peca = new Peca();
					peca.setVeiculo(new Veiculo());
					veiculo.setModelo(res.getString("Modelo"));
					veiculo.setNome(res.getString("NOME"));
					veiculo.setAno(res.getInt("ANO"));
					
					listaVeiculos.add(veiculo);
				 }
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listaVeiculos;
     }
     }

		
		
		
		
		
		
		
		
		
		
	









