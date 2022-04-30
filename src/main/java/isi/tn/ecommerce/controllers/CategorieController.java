package isi.tn.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import isi.tn.ecommerce.entities.Categorie;
import isi.tn.ecommerce.response.MessageResponse;
import isi.tn.ecommerce.services.CategorieService;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	CategorieService cserv;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addcat")
	public MessageResponse createCat(@Validated @RequestBody Categorie cat) {
		return cserv.saveCat(cat);
	}

	@GetMapping("/cat/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public Optional<Categorie> getCatById(@PathVariable(value = "id") Long Id) {
		return cserv.findById(Id);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}

	@GetMapping("/categories")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public List<Categorie> getAllCategories() {
		List<Categorie> pro = cserv.findAllCategories();
		return pro;

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/cat/{id}")
	public MessageResponse deleteCat(@PathVariable(value = "id") Long catId) {

		return cserv.delete(catId);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/cat/{id}")
	public MessageResponse updateCategorie(@PathVariable(value = "id") Long Id,
			@Validated @RequestBody Categorie catDetails) {

		Categorie cat = cserv.findById(Id).orElseThrow(null);

		cat.setLibelle(catDetails.getLibelle());

		MessageResponse updatedCategorie = cserv.saveCat(cat);
		return updatedCategorie;
	}

}
