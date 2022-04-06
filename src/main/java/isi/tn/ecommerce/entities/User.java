package isi.tn.ecommerce.entities;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "userId") // esm lcolonne user_id
	private Long userId;
	private String email;
	private String pwd;
	private String fname;
	private String lname;
	@ManyToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Article> article = new HashSet<>();

	//

	public User() {
		super();
	}

	public User(Long id, String email, String pwd, String fname, String lname) {
		super();
		this.userId = id;
		this.email = email;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> articles) {
		this.article = articles;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public Long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
