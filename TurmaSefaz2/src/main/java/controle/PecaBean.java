package controle;
	import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.PecaDAO;
import dao.PecaDAOImpl;
import entidade.Peca;
import entidade.Veiculo;

	@ManagedBean(name = "PecaBean")
	@SessionScoped
	public class PecaBean {
		
		private Peca peca;
		private List<Veiculo> listaVeiculos;
		private PecaDAO pecaDAO;

		/**
		 * Construtor, que vai inicializar a lista de usuarios
		 */
		public PecaBean() {

			this.pecaDAO = new PecaDAOImpl();
			
			this.peca = new Peca();
			this.peca.setVeiculo(new Veiculo());
			this.listaVeiculos = new ArrayList<Veiculo>();
			
			this.listaVeiculos = this.pecaDAO.listaVeiculos();
			
		}

		public void cadastrar() {

			this.listaVeiculos = this.pecaDAO.listaVeiculos();
			boolean achou = false;
			
			
			
			for (Veiculo veiculoPesquisado : listaVeiculos) {
				if(this.peca.getMarca_peca().equals(veiculoPesquisado.getModelo())) {
					achou = true;
				}
			}
				
		
			
			if(achou) {
				FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Cadastro ja existente!!!"));
			}else {
//				this.listaUsuarios.add(novo);
				this.pecaDAO.inserir(peca);
				
				this.peca = new Peca();	
			
			}
		}
			public void Sair() {
				 System.exit(0);
			}
			public void actionPerformed (ActionEvent e){

			 Object mi_sair = null;
				//Evento com o item de menu ,ao clicar no menu sair ,fecha o formulário.
			    if (e.getSource() == mi_sair){

			        Sair();
			}

			Object bt_sair = null;
			if(e.getSource() == bt_sair){

			 Sair();
			}
			

			}	
	
		public Peca getPeca() {
			return peca;
		}

		public void setPeca(Peca peca) {
			this.peca = peca;
		}

		public List<Veiculo> getListaVeiculos() {
			return listaVeiculos;
		}

		public void setListaVeiculos(List<Veiculo> listaVeiculos) {
			this.listaVeiculos = listaVeiculos;
		}
	
	}
		




		