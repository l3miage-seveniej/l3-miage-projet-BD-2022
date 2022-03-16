package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Abonne")
@DiscriminatorValue("Abonne")
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

    public Abonne setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
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
        this.dateFin = new Date((dateAbonnement.getTime() + (365l * 24l * 60l * 60l * 1000l))); // renvoie la date un an
                                                                                                // plus tard (365 jours)
    }

    public Date getDateFin() {
        return dateFin;
    }

}
