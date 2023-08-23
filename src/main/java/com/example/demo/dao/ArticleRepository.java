package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Article;
@Repository 
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	public Article findByLibelle(String name);	
	
	  @Query("select a from Article a where a.libelle like :nom% ")
	  List<Article> maRequete(@Param("nom") String nom);
	  
}
