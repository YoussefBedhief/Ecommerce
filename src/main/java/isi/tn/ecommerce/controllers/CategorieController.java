package isi.tn.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import isi.tn.ecommerce.entities.User;
import isi.tn.ecommerce.services.ArticleService;
import isi.tn.ecommerce.services.CategorieService;
import isi.tn.ecommerce.services.UserService;


@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	CategorieService cserv;
	
	
	@PostMapping("/addcat")
	public Categorie createCat(@Validated @RequestBody Categorie cat) {
		return cserv.saveCat(cat);
	}

	@GetMapping("/cat/{id}")
	public Optional<Categorie> getCatById(@PathVariable(value = "id") Long Id) {
		return cserv.findById(Id);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}

	@GetMapping("/categories")
	public List<Categorie> getAllCategories() {
		List<Categorie> pro = cserv.findAllCategories();
		return pro;

	}

	@DeleteMapping("/cat/{id}")
	public ResponseEntity<?> deleteCat(@PathVariable(value = "id") Long catId) {
		Categorie cat = cserv.findById(catId).orElseThrow(null);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		// userRepository.deleteById(userId);
		cserv.delete(cat);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/cat/{id}")
	public Categorie updateCategorie(@PathVariable(value = "id") Long Id, @Validated @RequestBody Categorie catDetails) {

		Categorie cat = cserv.findById(Id).orElseThrow(null);

		cat.setLibelle(catDetails.getLibelle());
		
		Categorie updatedCategorie = cserv.saveCat(cat);
		return updatedCategorie;
	}
	
	
}
