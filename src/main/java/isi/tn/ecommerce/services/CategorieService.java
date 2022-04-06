package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import isi.tn.ecommerce.entities.Categorie;

public interface CategorieService {
	Categorie saveCat(Categorie categorie);

	Optional<Categorie> findById(Long id);

	List<Categorie> findAllCategories();

	void delete(Categorie categorie);
}
