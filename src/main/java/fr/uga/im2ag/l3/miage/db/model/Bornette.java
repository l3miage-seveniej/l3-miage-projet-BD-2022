package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "BORNETTE")
public class Bornette {
    
    @Column(nullable = false)
    @Id
    @GeneratedValue
    private int numeroB;
    private Enums.Etat etatB;
    private Boolean libre;

    @ManyToOne(targetEntity = Station.class)
    private Station station;

    @OneToMany(targetEntity = Velo.class)
    private List<Velo> velos;

    public int getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(int numeroB) {
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

    public List<Velo> getVelos() {
        return velos;
    }

    public void setVelos(List<Velo> velos) {
        this.velos = velos;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Bornette [etatB=" + etatB + ", libre=" + libre + ", numeroB=" + numeroB + ", station=" + station
                + ", velos=" + velos + "]";
    }
    
    
}
