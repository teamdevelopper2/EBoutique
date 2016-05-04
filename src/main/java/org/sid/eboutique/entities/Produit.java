/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Boura
 */
@Entity
@Table(name="produits")
public class Produit implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nom;
    @NotEmpty
    @Size(min=4,max=15)
    private String designation;
    private String description;
    private double prix;
    private boolean selected;
    private String photo;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
   

    public Produit(String nom, String designation, String description, double prix, boolean selected, String photo, int quantite) {
        this.nom = nom;
        this.designation = designation;
        this.description = description;
        this.prix = prix;
        this.selected = selected;
        this.photo = photo;
        this.quantite = quantite;
    }

    public Produit() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
   

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long id) {
        this.idProduit = id;
    }

       @Override
    public String toString() {
        return "sn.ecommerce.Entity.Produit[ id=" + idProduit + " ]";
    }
    
}
