package com.example_spring.blog.repository;

import com.example_spring.blog.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {



}
