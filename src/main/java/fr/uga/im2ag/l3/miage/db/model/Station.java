package fr.uga.im2ag.l3.miage.db.model;

public class Station {
    
    private String adresse;
    private Enums.VType type;
    private Bornette bornette;

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

    public Bornette getBornette() {
        return bornette;
    }

    public void setBornette(Bornette bornette) {
        this.bornette = bornette;
    }
    
    
}
