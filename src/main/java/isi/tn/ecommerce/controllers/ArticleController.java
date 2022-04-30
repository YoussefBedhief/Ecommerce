package isi.tn.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.ecommerce.entities.Article;
import isi.tn.ecommerce.entities.Categorie;
import isi.tn.ecommerce.response.MessageResponse;
import isi.tn.ecommerce.services.ArticleService;
import isi.tn.ecommerce.services.CategorieService;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	ArticleService aserv;

	@Autowired
	CategorieService cserv;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addart")
	public MessageResponse createArt(@Validated @RequestBody Article art) {
		return aserv.saveArt(art);
	}

	@GetMapping("/art/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public Optional<Article> getArtById(@PathVariable(value = "id") Long Id) {
		return aserv.findById(Id);

	}

	@GetMapping("/articles")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<Article> getAllArticles() {
		List<Article> pro = aserv.findAllArticles();
		return pro;

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/art/{id}")
	public MessageResponse deleteArt(@PathVariable(value = "id") Long artId) {

		return aserv.delete(artId);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/art/{id}")
	public MessageResponse updateArticle(@PathVariable(value = "id") Long Id,
			@Validated @RequestBody Article artDetails) {

		Article art = aserv.findById(Id).orElseThrow(null);

		art.setLibelle(artDetails.getLibelle());
		art.setPrix(artDetails.getPrix());
		art.setRef(artDetails.getRef());

		MessageResponse updatedArticle = aserv.saveArt(art);

		return updatedArticle;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/affecter/{aid}/{cid}")
	public void affecterArt(@PathVariable(value = "aid") Long Id, @PathVariable(value = "cid") Long Idp,
			@Validated Categorie cat) {

		Article article = aserv.findById(Id).get();
		Categorie categorie = cserv.findById(Idp).get();
		article.setCategorie(categorie);
		this.aserv.saveArt(article);

	}
}
