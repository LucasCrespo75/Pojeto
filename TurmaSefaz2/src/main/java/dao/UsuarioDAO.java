package dao;

import java.util.List;
import entidade.Usuario;

public interface UsuarioDAO {
	
	
	public void inserir(Usuario usuario);
	
	public void remover(Usuario usuario);
	
	public Usuario pesquisar(Long id_cpf);
	
	public List<Usuario> listarTodos();

}
//porq usar unterface? Pois ela esta espelahndo design patner, q tem q ser usando pela sua interface n pela implementação. Sendo assim, uma regra do PATNER
