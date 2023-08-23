package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.loader.BatchFetchStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom_categorie", length = 40)
	private String nom;
	
	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY) // par defaut
	List<Article> articles = new ArrayList<>(); 
	
	public Categorie(String nom) {
		this.nom = nom;
	}
	public Categorie() {
		super();
	}
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
