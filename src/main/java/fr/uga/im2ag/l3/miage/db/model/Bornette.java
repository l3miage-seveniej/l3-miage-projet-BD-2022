package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.model.Enums.Situation;

@Entity
@Table(name = "BORNETTE")
public class Bornette {


    public Bornette() {
    }

    

    public Bornette(Etat etatB, Station station) {
        this.etatB = etatB;
        setStation(station);
        this.libre = true;
    }



    @Column(nullable = false)
    @Id
    @GeneratedValue
    private Long numeroB;

    @Enumerated(EnumType.STRING)
    private Enums.Etat etatB;
    private Boolean libre;

    @ManyToOne(targetEntity = Station.class)
    private Station station;

    @OneToOne
    private Velo velo;

    public Long getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(Long numeroB) {
        this.numeroB = numeroB;
    }

    public Enums.Etat getEtatB() {
        return etatB;
    }

    public void setEtatB(Enums.Etat etatB) {
        this.etatB = etatB;
    }

    public Boolean getLibre() {
        return libre;
    }

    public Bornette setLibre(Boolean libre) {
        this.libre = libre;
        return this;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
        station.addBornette(this);
    }

    // Si il n'y a pas un velo dans cette bornette, 
    // on mets un velo
    // sinon on ne mets pas un velo 
    // renvoie le velo qui est officiellement dans cette bornette
    public Velo setVelo(Velo velo){
        if(this.velo != null){
            this.velo = velo;
            velo.setEstAccueilli(this);
            setLibre(false);
            velo.setSituation(Situation.EN_STATION);
        }else{
            this.velo=velo;
        }
        return this.velo;
    }

    public void removeVelo(){
        if(this.velo == null){
            velo.setEstAccueilli(null);
            this.velo = null;
            setLibre(true);
        }
    }



    @Override
    public String toString() {
        return "Bornette [etatB=" + etatB + ", libre=" + libre + ", numeroB=" + numeroB + ", addresse=" + station.getAdresse() + "]";
    }

    
}
