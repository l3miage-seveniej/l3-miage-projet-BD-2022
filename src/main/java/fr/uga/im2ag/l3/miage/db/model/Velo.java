package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VELO")
public class Velo {
    @Id
    @GeneratedValue
    private Long numeroV;

    private Enums.Modele modeleV;

    private Enums.Etat etatV;

    private Enums.Situation situation;

    private Date dateMiseEnService;

    @ManyToMany(targetEntity = Location.class)
    private List<Location> location;

    @OneToOne(targetEntity = Bornette.class)
    private Bornette estAccueilli;

    public Long getNumero() {
        return numeroV;
    }

    public void setNumero(Long numeroV) {
        this.numeroV = numeroV;
    }

    public Enums.Modele getModele() {
        return modeleV;
    }

    public void setModele(Enums.Modele modeleV) {
        this.modeleV = modeleV;
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
