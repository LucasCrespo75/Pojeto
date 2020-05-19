package controle;


	import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dao.LivroDAO;
import dao.LivroDAOimpl;
import entidade.Livro;

	@ManagedBean(name = "LivroBean")
	@SessionScoped
	public class LivroBean {

		private String txtNome;
		private String txtAutor;

		private List<Livro> listaLivros;
		private Livro livro; // Objeto para cadastro
		private String msgCriarLivro;
		private String msgAlterarLivro;
		
		private LivroDAO livroDAO;

		/**
		 * Construtor, que vai inicializar a lista de usuarios
		 */
		public LivroBean() {
			this.listaLivros = new ArrayList<Livro>();
			this.livro = new Livro();
			this.livroDAO = new LivroDAOimpl();
		}

		/**
		 * Metodo responsavel por validar o usuario no login
		 */
		public String entrar() {

			boolean achou = false;

			this.listaLivros = this.livroDAO.listarTodos();
			
			for (Livro livroPesquisa : listaLivros) {

				if (livroPesquisa.getId().equals(this.txtNome) && livroPesquisa.getAutor().equals(this.txtAutor)) {

					achou = true;
				}
			}

			if (achou) {
				return "login.xhtml";
			} else {
				return "";
			}
	
			}
			

		

		/**
		 * Metodo responsavel por criar um novo usuario na lista
		 */
		public void criarLivro() {

			Livro novo = new Livro();

			novo.setNome(this.livro.getNome());
			novo.setId(this.livro.getId());
			novo.setAutor(this.livro.getAutor());

			boolean achou = false;
			
			this.listaLivros = this.livroDAO.listarTodos();
			
			for (Livro livroPesquisa : listaLivros) {
				if (livroPesquisa.getId().equals(this.livro.getId())) {
					achou = true;
				}
			}
			
			if(achou) {
				FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Livro existente!!!"));
			}else {
//				this.listaUsuarios.add(novo);
				this.livroDAO.inserir(novo);
				
				this.livro = new Livro();	
			}
		}
			
			
			public void alterarLivro() {

				Livro novo = new Livro();

				novo.setNome(livro.getNome());
				novo.setId(livro.getId());
				novo.setAutor(livro.getAutor());

				boolean achou = false;
				
				this.listaLivros = this.livroDAO.listarTodos();
				
				for (Livro livroPesquisa : listaLivros) {
					if (livroPesquisa.getId().equals(this.livro.getId())) {
						achou = true;
					}
				}
				
				if(achou) {
					FacesContext.getCurrentInstance()
						.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, livro nao existe", "Livro encontrado!!!"));
				}else {
//					this.listaUsuarios.add(novo);
					this.livroDAO.alterar(livro);
					this.livroDAO.inserir(novo);
					this.livro = new Livro();	
				}
			}
		
			
		
		
		public String getTxtNome() {
			return txtNome;
		}

		public void setTxtNome(String txtNome) {
			this.txtNome = txtNome;
		}

	
		public String getTxtAutor() {
			return txtAutor;
		}

		public void setTxtAutor(String txtAutor) {
			this.txtAutor = txtAutor;
		}


		
		public List<Livro> getListaLivros() {
			return listaLivros;
		}

		public void setListaLivros(List<Livro> listaLivros) {
			this.listaLivros = listaLivros;
		}

		public Livro getLivro() {
			return livro;
		}

		public void setLivro(Livro livro) {
			this.livro = livro;
		}

		public String getMsgCriarLivro() {
			return msgCriarLivro;
		}

		public void setMsgCriarLivro(String msgCriarLivro) {
			this.msgCriarLivro = msgCriarLivro;
		}

		public String getMsgAlterarLivro() {
			return msgAlterarLivro;
		}

		public void setMsgAlterarLivro(String msgAlterarLivro) {
			this.msgAlterarLivro = msgAlterarLivro;
		}

	
		


	}