package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.ecommerce.entities.Article;
import isi.tn.ecommerce.repositories.ArticleRepository;

@Service
public class ImpArticleService implements ArticleService {
	@Autowired
	ArticleRepository arepos;

	@Override
	public Article saveArt(Article article) {
		// TODO Auto-generated method stub
		return arepos.save(article);
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
	public void delete(Article article) {
		// TODO Auto-generated method stub
		arepos.delete(article);
	}
}
