package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.model.Enums.Modele;
import fr.uga.im2ag.l3.miage.db.model.Enums.Situation;

@Entity
@Table(name = "VELO")
public class Velo {

    public Velo() {
    }

    public Velo(Modele modeleV, Etat etatV, Situation situation, Date dateMiseEnService, Bornette estAccueilli) {
        this.modeleV = modeleV;
        this.etatV = etatV;
        this.situation = situation;
        this.dateMiseEnService = dateMiseEnService;
        this.estAccueilli = estAccueilli;
        estAccueilli.setLibre(false);
        this.estAccueilli.setVelo(this);
    }

    @Id
    @GeneratedValue
    private Long numeroV;

    @Enumerated(EnumType.STRING)
    private Enums.Modele modeleV;

    @Enumerated(EnumType.STRING)
    private Enums.Etat etatV;

    @Enumerated(EnumType.STRING)
    private Enums.Situation situation;

    private Date dateMiseEnService;

    // Velo et location est uni-directionnelle
    // @ManyToMany(targetEntity = Location.class, mappedBy = "velos" )
    // private List<Location> location;

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

    public Bornette getEstAccueilli() {
        return estAccueilli;
    }

    public void veloEstLoue() {
        this.estAccueilli.setVelo(null);
        this.estAccueilli.setLibre(true);
        this.situation = Situation.EN_LOCATION;

    }

    public void veloEstRendu(Bornette b) {
        this.setEstAccueilli(b);
        this.estAccueilli.setVelo(this);
        this.estAccueilli.setLibre(false);
        this.situation = Situation.EN_STATION;

    }

    public void setEstAccueilli(Bornette estAccueilli) {
        this.estAccueilli = estAccueilli;
    }

    @Override
    public String toString() {
        return "Velo [dateMiseEnService=" + dateMiseEnService + ", estAccueilli=" + estAccueilli + ", etatV=" + etatV
                + ", modeleV=" + modeleV + ", numeroV=" + numeroV + ", situation=" + situation + "]";
    }

}
