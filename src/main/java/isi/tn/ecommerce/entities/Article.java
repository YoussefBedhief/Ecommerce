package isi.tn.ecommerce.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



import static javax.persistence.FetchType.LAZY;


@Entity
public class Article {
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "artId") // esm lcolonne art_id
	private Long artId;

	private String libelle;
	private double prix;
	private String ref;
	 @ManyToOne(fetch= LAZY )
	 @JoinColumn(name = "catId",referencedColumnName="catId")
    private Categorie categorie;
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "article_user",
	            joinColumns = {
	                    @JoinColumn(name = "artId")
	            },
	            inverseJoinColumns = {
	                    @JoinColumn(name = "userId")})
	    private Set<User> user = new HashSet<>();
	 
	public Article(Long id, String libelle, double prix, String ref) {
		super();
		this.artId = id;
		this.libelle = libelle;
		this.prix = prix;
		this.ref = ref;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public void setArtId(Long id) {
		this.artId = id;
	}
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getArtId() {
		return artId;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Categorie getCat() {
		return categorie;
	}
	public void setCat(Categorie categorie) {
		this.categorie = categorie;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> users) {
		this.user = users;
	}

	
	
	
	
}
