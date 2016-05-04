/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Boura
 */
public class Panier implements Serializable{
    private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
    
    //Ajout d'un produit
    public void addArticle(Produit produit,int quantite){
        if(items.get((produit.getIdProduit())) == null){
            LigneCommande lc = new  LigneCommande();
            lc.setProduit(produit);
            lc.setQuantite(quantite);
            lc.setPrix(produit.getPrix());
        }
        else{
            LigneCommande lc = new  LigneCommande();
            lc.setQuantite(lc.getQuantite() + quantite);
        }
    }
    //Liste des ligne de commmande
    public Collection<LigneCommande> getItems(){
        return items.values();
    }
    
    //Totale des ligne de commande
    
    public double getTotal(){
        double total = 0;
        for(LigneCommande lc : items.values()){
            total +=lc.getPrix()*lc.getQuantite();
        }
        return  total;
    }
    //Le nombre de produit
    
    public int getSize(){
        return items.size();
    }
    //Suppression d4un produit
    public void deleteItem(Long idProduit){
        items.remove(idProduit);
    }
}
