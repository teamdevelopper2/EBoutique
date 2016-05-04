package org.sid.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminCategoriesMetier metier = 
					(IAdminCategoriesMetier) context.getBean("metier");
			List<Categorie> cts1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateur", "Ordinateur", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimente", "imprimente", null, "image2.jpg"));
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size()+2==cts2.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);
		}
		
	}
	
	@Test
	public void test2() {
		try {
			ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminCategoriesMetier metier = 
					(IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> prods = metier.listProduits();
			metier.ajouterProduit(new Produit("HP45ERT", "HP7890", "HP Compact", 6000, true, "image1.jpg", 50), 1L);
			metier.ajouterProduit(new Produit("AZERTY", "HP7891", "HP ", 6000, true, "image1.jpg", 50), 1L);
			List<Produit> prods2 = metier.listProduits();
			assertTrue(prods.size()+2==prods2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
		
	}

}
