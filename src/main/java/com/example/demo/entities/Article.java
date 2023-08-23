package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="articles")
public class Article {
	
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@NotNull(message = "Le nom est obligatoire !!!") // libelle n'accepte pas la valeur null. Le vide
	@Size(min = 6, max = 80, message = "le nom de l'article doit être entre 6 et 80 caractères !!!!!") // imposer une taille min et max a la chaine libele 
	@Column(name="nom_article", length = 50) // changer le nom d'une colonne
	private String libelle;
	
	@Min(100) @Max(1000) // imposer une valeur max et min au prix
	private double prix;
	
	 @NotBlank(message = "Blog Editor cannot be blank") // ne pas accepter le vide pour description, non plus un espace
	private String description;
	
	@ManyToOne
	private Categorie categorie;
	
	public Article() {
		super();
	}
	public Article(String libelle, double prix, String description) {

		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return libelle + " " + description + " " + prix;
	}
	
}
