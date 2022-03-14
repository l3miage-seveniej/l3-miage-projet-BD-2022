package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BORNETTE")
public class Bornette {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private Long numeroB;
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

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
