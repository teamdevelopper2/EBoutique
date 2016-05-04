package org.sid.eboutique.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Client;
import org.sid.eboutique.entities.Commande;
import org.sid.eboutique.entities.LigneCommande;
import org.sid.eboutique.entities.Panier;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.Users;

public class BoutiqueDaoImpl implements IBoutiqueDAO {

	@PersistenceContext
	private EntityManager em;
	@Override
	public Long ajouterCategorie(Categorie categorie) {

		em.persist(categorie);
		return categorie.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		Query req =  em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long categorieID) {
		Categorie c = em.find(Categorie.class, categorieID);
		em.remove(c);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
		
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie c = getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
		Query req =  em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req =  em.createQuery("select p from Produit p where p.designation like :x or p.designation like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req =  em.createQuery("select p from Produit p where p.categorie.idCategorie =:x");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req =  em.createQuery("select p from Produit p where p.selected =true");
		
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		Produit p = getProduit(idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void ajouterUser(Users u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		Users u = em.find(Users.class, userID);
		u.getRoles().add(r);
		em.persist(r);
	}

	@Override
	public Commande enregisterCommande(Panier p, Client c) {
		em.persist(c);
		Commande cmd = new Commande();
		cmd.setDateCommande(new Date());
		cmd.setItems(p.getItems());
		for(LigneCommande lc : p.getItems()){
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

}
