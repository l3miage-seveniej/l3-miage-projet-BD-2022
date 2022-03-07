package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Abonne")
public class Abonne extends Client {
    
    
    private String nom;
    private String prenom;
    private Enums.sexe sexe;
    private String adresse;
    private Date dateNaissance;
    private Date dateAbonnement;

    private Date dateFin;
    
   
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Enums.sexe getSexe() {
        return sexe;
    }
    public void setSexe(Enums.sexe sexe) {
        this.sexe = sexe;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDebut() {
        return dateAbonnement;
    }

    public void setDateDebut(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
}
