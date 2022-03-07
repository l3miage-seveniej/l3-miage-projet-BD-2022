package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

public class Abonnes extends Client {
    
    private Boolean estAbonne;
    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
    private int nCB;
    private Date dateNaissance;
    private Date dateDebut;

    private Date dateFin;
    
    public Boolean getEstAbonne() {
        return estAbonne;
    }
    public void setEstAbonne(Boolean estAbonne) {
        this.estAbonne = estAbonne;
    }
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
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getnCB() {
        return nCB;
    }
    public void setnCB(int nCB) {
        this.nCB = nCB;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
}
