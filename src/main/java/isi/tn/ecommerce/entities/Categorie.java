package isi.tn.ecommerce.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie {
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "catId") // esm lcolonne cat_id
	private Long catId;
	private String libelle;
	@OneToMany (mappedBy="categorie")
	private List<Article> articles;
	

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Long getCatId() {
		return catId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie(Long catId, String libelle) {
		super();
		this.catId = catId;
		this.libelle = libelle;
	}

	public Categorie() {
		super();
	}

}
