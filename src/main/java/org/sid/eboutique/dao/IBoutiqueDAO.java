package org.sid.eboutique.dao;

import java.util.List;

import org.sid.eboutique.entities.*;

public interface IBoutiqueDAO {

	public Long ajouterCategorie(Categorie categorie);
	public  List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long categorieID);
    public void modifierCategorie(Categorie c);
    
    public Long ajouterProduit(Produit p, Long idCat);
    public List<Produit> listProduits();
    public List<Produit> produitsParMotCle(String mc);
    public List<Produit> produitsParCategorie(Long idCat);
    public List<Produit> produitsSelectionnes();
    public Produit getProduit(Long idP);
    public void supprimerProduit(Long idP);
    public void modifierProduit(Produit p);
    
    public void ajouterUser(Users u);
    public void attribuerRole(Role r, Long userID);
    public Commande enregisterCommande(Panier p, Client c);
   
}
