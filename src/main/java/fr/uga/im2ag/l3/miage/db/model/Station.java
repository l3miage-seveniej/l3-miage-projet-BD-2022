package fr.uga.im2ag.l3.miage.db.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATION")
public class Station {

    @Id
    @GeneratedValue
    private Long idStation;
    private String adresse;

    @OneToMany(targetEntity = Bornette.class)
    private List<Bornette> bornettes;

    @OneToMany
    private List<Creneau> creneaux;

    public Long getIdStation() {
        return idStation;
    }

    public void setIdStation(Long idStation) {
        this.idStation = idStation;
    }

    public List<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(List<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    public String getAdresse() {
        return adresse;
    }

    public Station setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

}
