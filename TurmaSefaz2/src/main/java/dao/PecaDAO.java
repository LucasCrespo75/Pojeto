package dao;

import java.util.List;

import entidade.Peca;
import entidade.Veiculo;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface PecaDAO {
	
	public void inserir(Peca peca);
	
	public void alterar(Peca peca);

	public void remover(Peca epca);

	public Peca pesquisar(String id);

	public List<Peca> listarTodas();
	
	public List<Veiculo> listaVeiculos();


//Alterar e pesquisa 

		
    	
    	
    }

    