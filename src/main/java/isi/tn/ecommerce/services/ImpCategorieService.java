package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.ecommerce.entities.Categorie;
import isi.tn.ecommerce.repositories.CategorieRepository;

@Service
public class ImpCategorieService implements CategorieService {
	@Autowired
	CategorieRepository crepos;

	@Override
	public Categorie saveCat(Categorie categorie) {
		// TODO Auto-generated method stub
		return crepos.save(categorie);
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
	public void delete(Categorie categorie) {
		// TODO Auto-generated method stub
		crepos.delete(categorie);
	}
}
