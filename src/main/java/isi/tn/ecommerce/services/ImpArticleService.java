package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.ecommerce.entities.Article;
import isi.tn.ecommerce.repositories.ArticleRepository;
import isi.tn.ecommerce.response.MessageResponse;

@Service
public class ImpArticleService implements ArticleService {
	@Autowired
	ArticleRepository arepos;

	@Transactional
	@Override
	public MessageResponse saveArt(Article article) {
		// TODO Auto-generated method stub
		boolean existe = arepos.existsByRef(article.getRef());
		if (existe) {
			return new MessageResponse("Echec la reférence existe deja 🛑");
		}
		arepos.save(article);
		return new MessageResponse("Article ajouté avec succés ✔");
	}

	@Override
	public Optional<Article> findById(Long id) {
		// TODO Auto-generated method stub
		return arepos.findById(id);
	}

	@Override
	public List<Article> findAllArticles() {
		// TODO Auto-generated method stub
		return (List<Article>) arepos.findAll();
	}

	@Override
	public MessageResponse delete(Long  id) {
		try {
			arepos.deleteById(id);
			return new MessageResponse("Action réalisée avec succés ✔");
		} catch (Exception e) {
			// TODO: handle exception
			return new MessageResponse("Echec 💥🛑❌");
		}
	}
}
