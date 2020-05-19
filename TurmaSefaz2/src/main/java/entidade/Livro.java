package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LIVRO")

public class Livro {

	@Id
	@Column(name="ID_livro", nullable = false)//NUMERO DE SERIE
	private Long id;
	
	@Column(name="NOME", nullable = false)//NOME DO LIVRO
	private String nome;
	@Column(name="AUTOR", nullable = false)
	private String autor;

	public String getNome() {
		return nome;
	}
	
	

	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	}


