package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.ecommerce.entities.Article;
import isi.tn.ecommerce.entities.Categorie;
import isi.tn.ecommerce.repositories.CategorieRepository;
import isi.tn.ecommerce.response.MessageResponse;

@Service
public class ImpCategorieService implements CategorieService {
	@Autowired
	CategorieRepository crepos;

	@Transactional
	@Override
	public MessageResponse saveCat(Categorie cat) {
		// TODO Auto-generated method stub
		boolean existe = crepos.existsByLibelle(cat.getLibelle());
		if (existe) {
			return new MessageResponse("Echec la catégorie existe deja 🛑");
		}
		crepos.save(cat);
		return new MessageResponse("Une catégorie est ajoutée avec succés ✔");
	}

	@Override
	public Optional<Categorie> findById(Long id) {
		// TODO Auto-generated method stub
		return crepos.findById(id);
	}

	@Override
	public List<Categorie> findAllCategories() {
		// TODO Auto-generated method stub
		return (List<Categorie>) crepos.findAll();
	}

	@Override
	public MessageResponse delete(Long  id) {
		try {
			crepos.deleteById(id); 
			return new MessageResponse("Action réalisée avec succés ✔");
		} catch (Exception e) {
			// TODO: handle exception
			return new MessageResponse("Echec 💥🛑❌");
		}
	}
}
