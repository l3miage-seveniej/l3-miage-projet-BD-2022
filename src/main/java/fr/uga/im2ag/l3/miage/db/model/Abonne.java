package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name = "Abonne")
@DiscriminatorValue("Abonne")
public class Abonne extends Client {

    public Abonne() {
    }

    public Abonne(String nom, String prenom, Enums.sexe sexe, String adresse,
        Date dateNaissance, Date dateAbonnement) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.dateAbonnement = dateAbonnement;
        setDateDebut(dateAbonnement);
    }

    private String nom;
    private String prenom;
    
    @Enumerated(EnumType.STRING)
    private Enums.sexe sexe;
    private String adresse;
    private Date dateNaissance;
    private Date dateAbonnement;

    private Date dateFin;

    public String getNom() {
        return nom;
    }

    public Abonne setNom(String nom) {
        this.nom = nom;
        return this;
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

    public Abonne setSexe(Enums.sexe sexe) {
        this.sexe = sexe;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Abonne setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Abonne setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public Date getDateDebut() {
        return dateAbonnement;
    }

    public Abonne setDateDebut(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
        this.dateFin = new Date((dateAbonnement.getTime() + (365l * 24l * 60l * 60l * 1000l))); // renvoie la date un an
                                                                                                // plus tard (365 jours)
        return this;
    }

    public Date getDateFin() {
        return dateFin;
    }

    @Override
    public String toString() {
        return "Abonne [adresse=" + adresse + ", dateAbonnement=" + dateAbonnement + ", dateFin=" + dateFin
                + ", dateNaissance=" + dateNaissance + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + "]";
    }


    
}
