/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Boura
 */
@Entity
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    @NotEmpty
    public String nomCategorie;
    public String description;
    @Lob
    public byte[] photo;
    public String nomPhoto;
    @OneToMany(mappedBy = "categorie")
    public Collection<Produit> produits;

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nom) {
        this.nomCategorie = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Categorie(String nom, String description, byte[] photo, String nomPhoto) {
        this.nomCategorie = nom;
        this.description = description;
        this.photo = photo;
        this.nomPhoto = nomPhoto;
       
    }

    public Categorie() {
    }
  

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long id) {
        this.idCategorie = id;
    }
 

    @Override
    public String toString() {
        return "sn.ecommerce.Entity.Categorie[ id=" + idCategorie + " ]";
    }
    
}
