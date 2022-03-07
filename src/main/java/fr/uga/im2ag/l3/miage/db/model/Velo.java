package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VELO")
public class Velo {

    private int numeroV;
    private Enums.Modele modele;
    private Enums.Etat etatV;
    private Enums.Situation situation;
    private Date dateMiseEnService;

    @ManyToOne(targetEntity = Bornette.class)
    private Bornette estAccueilli;

    public int getNumero() {
        return numeroV; //numero
    }

    public void setNumero(int numeroV) {
        this.numeroV = numeroV;
    }

    public Enums.Modele getModele() {
        return modele;
    }

    public void setModele(Enums.Modele modele) {
        this.modele = modele;
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

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }
}
