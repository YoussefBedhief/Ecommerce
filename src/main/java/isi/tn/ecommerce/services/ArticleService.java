package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import isi.tn.ecommerce.entities.Article;

public interface ArticleService {
	Article saveArt(Article article);

	Optional<Article> findById(Long id);

	List<Article> findAllArticles();

	void delete(Article article);
}
