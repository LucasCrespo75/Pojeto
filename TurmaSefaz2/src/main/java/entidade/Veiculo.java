package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VEICULO")
public class Veiculo {

	@Id
	@Column(name="MODELO", nullable = false)
	private String modelo;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
    @Column(name="ANO", nullable = false)
    private int ano;
    
    @OneToMany(mappedBy="modelo", cascade= CascadeType.ALL)
	private List<Peca> pecas;
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public <Pecas> Pecas setPecas(Pecas pecas) {
		return pecas;
	

	}
}


//	@JoinColumn(name = "nome_plataforma", referencedColumnName = "nome", nullable = false)
	//private Plataforma plataforma;

	

