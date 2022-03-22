package fr.uga.im2ag.l3.miage.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATION")
@NamedQuery(name="Station.getAll", query="Select S from Station S")
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

    public void addBornette(Bornette b){
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



    @Override
    public String toString() {
        return "Station [adresse=" + adresse + ", bornettes=" + bornettes + ", creneaux=" + creneaux + ", idStation="
                + idStation + "]";
    }

    

}
