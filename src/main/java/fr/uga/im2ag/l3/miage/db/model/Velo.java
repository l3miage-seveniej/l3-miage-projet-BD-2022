package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

public class Velo {
    
    private int numero;
    private String modele;
    private Date dateMiseEnService;
    private Etat etat;
    private Situation situation;

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }
    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }
    public Etat getEtat() {
        return etat;
    }
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    public Situation getSituation() {
        return situation;
    }
    public void setSituation(Situation situation) {
        this.situation = situation;
    }
}
