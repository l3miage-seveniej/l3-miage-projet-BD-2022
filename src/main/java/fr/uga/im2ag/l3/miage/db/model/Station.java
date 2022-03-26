package fr.uga.im2ag.l3.miage.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATION")
@NamedQuery(name = "Station.getAll", query = "Select S from Station S")
public class Station {

    public Station() {
        this.bornettes = new ArrayList<Bornette>();
        this.creneaux = new ArrayList<Creneau>();
    }

    public Station(String adresse) {
        this.adresse = adresse;
        this.bornettes = new ArrayList<Bornette>();
        this.creneaux = new ArrayList<Creneau>();
    }

    @Id
    @GeneratedValue
    private Long idStation;
    private String adresse;

    @OneToMany(targetEntity = Bornette.class)
    private List<Bornette> bornettes;

    @OneToMany
    private List<Creneau> creneaux;

    public void addBornette(Bornette b) {
        bornettes.add(b);
    }

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

    public boolean stationOK() {
        if (getBornettes().size() == 0)
            return false; // Si la station est vide, la station n'est pas OK

        for (Bornette bornette : getBornettes()) {
            if (bornette.getVelo() != null && bornette.getVelo().getEtat() == Enums.Etat.OK) {
                return true;
            }
        }
        return false;
    }

    public boolean contientPlaceLibre() {
        if (getBornettes().size() == 0) return false;                                   // Si la station est vide, la station n'est pas OK

        for (Bornette bornette : getBornettes()) {
            if (bornette.getEtatB() == Enums.Etat.OK && bornette.getLibre() == true) {  
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Station [adresse=" + adresse + ", bornettes=" + bornettes + ", creneaux=" + creneaux + ", idStation="
                + idStation + "]";
    }

}
