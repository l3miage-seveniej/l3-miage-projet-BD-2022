package fr.uga.im2ag.l3.miage.db.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location {
    @Id
    private int idLoc;

    private int heureDebut;

    private int heureFin;
    
    private float cout;

    @OneToOne
    private Velo velo;

    @OneToOne
    private Client client;


    public int getIdLoc() {
        return idLoc;
    }
    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }
    public Velo getVelo() {
        return velo;
    }
    public void setVelos(Velo velo) {
        this.velo = velo;
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
