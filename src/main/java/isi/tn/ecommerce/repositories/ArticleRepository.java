package isi.tn.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.ecommerce.entities.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Boolean existsByRef(String ref);


}
