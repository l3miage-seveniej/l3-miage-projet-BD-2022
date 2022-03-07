package fr.uga.im2ag.l3.miage.db.model;

public class Bornette {
    
    private int numeroB;
    private Enums.Etat etatB;
    private Boolean libre;

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
}
