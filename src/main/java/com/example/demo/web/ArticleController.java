package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Article;
import com.example.demo.metier.ArticleService;

import jakarta.validation.Valid;

@Controller
public class ArticleController {
	 @Autowired
	private ArticleService artServ; 
	 
	 @GetMapping("/home")
	 public String getHome() {
		 System.out.println("------------ Ici Home ----------------------- ");
		 return "home";
	 }
	 
	 @GetMapping("/login")
	 public String getLogin(Model model) {
		 AppUser user = new AppUser();
			model.addAttribute("user", user);
		 
		 System.out.println("------------ ICi login ----------------------- ");
		 return "login";
	 }
	 
	 @GetMapping("/")
	 public String getArts(Model model) {
		 List<Article> arts = artServ.listArticle();
		 model.addAttribute("articles", arts);
		 return "listearticles";
	 }
	 
	@RequestMapping("/addart")
	public String ajouterArticle(Model model) {
		Article art = new Article();
		model.addAttribute("article", art);
		
		System.out.println("----------- ici  addArt -------------");
		return "ajouterarticle";
	}

	@PostMapping("/PostAddart")
	public String postAjouterArticle(/*indiquer au Spring de lancer la verification*/ 
										@Valid @ModelAttribute("article")Article art, 
									 /*ajouter ce parametre qui detient les erreurs*/
										BindingResult bindingResult) {

		// si l'une des contraintes n'est pas respectées : bindingResult.hasErrors() retourne true
		if(bindingResult.hasErrors()) {
			// retour au meme formulaire
			return "ajouterarticle";
		}
		
		// sinon, il fait son traitement qui est l'ajout
		artServ.ajouterArticle(art);
		System.out.println("----------- ici 2-------------");
		return "redirect:/";
	}
	
	
	@RequestMapping("/editart/{id_art}")
	public String modifierArticle(Model model, 
						@PathVariable(value="id_art") int id) {
		Article art = artServ.unArticle(id);
		model.addAttribute("article", art);
		
		System.out.println("----------- ici -------------");
		return "modifierarticle";
	}
	
	@GetMapping("/deleteart/{id}")
	public String supprimerArticle(@PathVariable(value="id")int id) {
		artServ.supprimer(id);
		return "redirect:/"; 
	}

	
}
