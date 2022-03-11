package fr.uga.im2ag.l3.miage.db.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location {
    @Id
    @GeneratedValue
    private int idLoc;

    private int heureDebut;

    private int heureFin;
    
    private float cout;

    @ManyToMany
    private List<Velo> velo;

    @ManyToOne
    private Client client;


    public int getIdLoc() {
        return idLoc;
    }
    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }
   
    
    public List<Velo> getVelo() {
        return velo;
    }
    public void setVelo(List<Velo> velo) {
        this.velo = velo;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public int getId() {
        return idLoc;
    }
    public void setId(int idLoc) {
        this.idLoc = idLoc;
    }
    public int getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }
    public int getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }
    public float getCout() {
        return cout;
    }
    public void setCout(float cout) {
        this.cout = cout;
    }
    
}
