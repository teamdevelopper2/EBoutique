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
import javax.persistence.OneToMany;

/**
 *
 * @author Boura
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String nom;
    private String adresse;
    private String email;
    private String Tel;
    @OneToMany(mappedBy = "client")
    private Collection<Commande> commandes;

    public Client(String nom, String adresse, String email, String Tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.Tel = Tel;
    }

    public Client() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public int getIdCLient() {
        return idClient;
    }

    public void setIdClient(int id) {
        this.idClient = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idClient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.ecommerce.Entity.client[ id=" + idClient + " ]";
    }
    
}
