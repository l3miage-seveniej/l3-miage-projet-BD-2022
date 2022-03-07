package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

public class Velo {

    private int numero;
    private Enums.Modele modele;
    private Date dateMiseEnService;
    private Enums.Etat etatV;
    private Enums.Situation situation;

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Enums.Modele getModele() {
        return modele;
    }
    public void setModele(Enums.Modele modele) {
        this.modele = modele;
    }
    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }
    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }
    public Enums.Etat getEtat() {
        return etatV;
    }
    public void setEtat(Enums.Etat etatV) {
        this.etatV = etatV;
    }
    public Enums.Situation getSituation() {
        return situation;
    }
    public void setSituation(Enums.Situation situation) {
        this.situation = situation;
    }
}
