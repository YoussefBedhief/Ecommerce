package isi.tn.ecommerce.services;

import java.util.List;
import java.util.Optional;

import isi.tn.ecommerce.entities.Article;
import isi.tn.ecommerce.response.MessageResponse;

public interface ArticleService {
	MessageResponse saveArt(Article article);

	Optional<Article> findById(Long id);

	List<Article> findAllArticles();

	MessageResponse delete(Long id);
}
