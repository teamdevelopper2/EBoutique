package org.sid.eboutique.metier;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.Users;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {
	public Long ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(Long categorieID);
    public void modifierCategorie(Categorie c);
    public void ajouterUser(Users u);
    public void attribuerRole(Role r, Long userID);
}
