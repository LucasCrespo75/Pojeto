package entidade;

	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="PECAS")
	public class Peca {

		@Id
		@Column(name="ID_nome", nullable = false)
		private String nome;
		
	@Column(name="marca_peca", nullable = false)
		private String marca_peca;
		
		@Column(name="ano_peca", nullable = false)
        private int ano;
		
		@ManyToOne
		@JoinColumn(name="modelo_veiculo",  referencedColumnName = "marca", nullable = false)
		private Veiculo veiculo;
		
		
		

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMarca_peca() {
			return marca_peca;
		}

		public void setMarca_peca(String marca_peca) {
			this.marca_peca = marca_peca;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public Veiculo getVeiculo() {
			return veiculo;
		}

		public void setVeiculo(Veiculo veiculo) {
			this.veiculo = veiculo;
		}

		}
		
	

	

