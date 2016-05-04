/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Boura
 */
@Entity
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    private Date dateCommande;
    @OneToMany(mappedBy = "commande")
    private Collection<LigneCommande> items;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    public Commande() {
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Collection<LigneCommande> getItems() {
        return items;
    }

    public void setItems(Collection<LigneCommande> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int id) {
        this.idCommande = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCommande;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if (this.idCommande != other.idCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.ecommerce.Entity.Commande[ id=" + idCommande + " ]";
    }
    
}
