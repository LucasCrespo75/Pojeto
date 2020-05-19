package dao;

import java.util.List;

import entidade.Jogo;
import entidade.Plataforma;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface JogoDAO {
	
	public void inserir(Jogo jogo);
	
	public void alterar(Jogo jogo);

	public void remover(Jogo jogo);

	public Jogo pesquisar(Long id);

	public List<Jogo> listarTodos();
	
	public List<Plataforma> listarPlataformas();


//Alterar e pesquisa 

		
    	
    	
    }
    

//porq usar unterface? Pois ela esta espelahndo design patner, q tem q ser usando pela sua interface n pela implementação. Sendo assim, uma regra do PATNER
