package com.example.demo.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.entities.Article;
@Service
public class ArticleService {
	@Autowired
	private ArticleRepository artRepo;
	

	public List<Article> listArticle(){
		return artRepo.findAll();
	}
	
	public Article unArticle(int id) {
		Optional<Article> art = artRepo.findById(id);
		
		Article article= null;
		if(art.isPresent())
			article = art.get();
		
		return article ;
	}
	
	public void ajouterArticle(Article art) {
		artRepo.save(art);  // insert into article () values()
	}
	
	public void modifier(Article artNouveau) {
		Optional<Article> artAncien = artRepo.findById(artNouveau.getId());
		Article art  = artAncien.get();
		art.setLibelle(artNouveau.getLibelle());
		art.setPrix(artNouveau.getPrix());
		artRepo.save(art);	
	}
	
	public void supprimer(int id) {
		Optional<Article> artAncien = artRepo.findById(id);
		artRepo.delete(artAncien.get());
	}

}
