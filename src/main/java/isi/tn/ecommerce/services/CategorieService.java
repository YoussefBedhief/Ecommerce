package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import isi.tn.ecommerce.entities.Categorie;
import isi.tn.ecommerce.response.MessageResponse;

public interface CategorieService {
	MessageResponse saveCat(Categorie categorie);

	Optional<Categorie> findById(Long id);

	List<Categorie> findAllCategories();

	MessageResponse delete(Long id);
}
