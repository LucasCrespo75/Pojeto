package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.JogoDAO;
import dao.JogoDAOImpl;
import entidade.Jogo;
import entidade.Plataforma;

@ManagedBean(name = "JogoBean")
@SessionScoped
public class JogoBean {
	
	private Jogo jogo;
	private List<Plataforma> listaPlataformas;
	private JogoDAO jogoDAO;

	/**
	 * Construtor, que vai inicializar a lista de usuarios
	 */
	public JogoBean() {

		this.jogoDAO = new JogoDAOImpl();
		
		this.jogo = new Jogo();
		this.jogo.setPlataforma(new Plataforma());
		this.listaPlataformas = new ArrayList<Plataforma>();
		
		this.listaPlataformas = this.jogoDAO.listarPlataformas();
		
	}

	public void salvar() {

		this.jogoDAO.inserir(this.jogo);
		this.jogo = new Jogo();
		
	}
	
	
	
	

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Plataforma> getListaPlataformas() {
		return listaPlataformas;
	}

	public void setListaPlataformas(List<Plataforma> listaPlataformas) {
		this.listaPlataformas = listaPlataformas;
	}
}
	
