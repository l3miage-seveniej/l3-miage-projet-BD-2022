package fr.uga.im2ag.l3.miage.db.model;

public class Enums {

    public enum Situation {
        EN_STATION, EN_LOCATION, EN_MAINTENANCE;
    }
    
    public enum Etat {
        OK, HS;
    }
    
    public enum Modele {
        HOLLANDAIS, VTC, VTT;
    }
    
    public enum VType {
        PLUS, MOINS, NUL;
    }
}
