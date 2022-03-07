package fr.uga.im2ag.l3.miage.db.model;

public class Location {
    
    private int id;
    private int heureDebut;
    private int heureFin;
    private int cout;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getCout() {
        return cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    
}
