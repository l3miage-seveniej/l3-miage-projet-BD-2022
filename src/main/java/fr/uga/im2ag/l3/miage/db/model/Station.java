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
    private int idStation;
    private String adresse;
    private Enums.VType type;

    @OneToMany(targetEntity = Bornette.class)
    private List<Bornette> bornettes;
    
    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
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

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Enums.VType getType() {
        return type;
    }

    public void setType(Enums.VType type) {
        this.type = type;
    }
}
