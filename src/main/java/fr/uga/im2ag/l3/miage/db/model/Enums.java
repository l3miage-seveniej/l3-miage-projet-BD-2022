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
    
    public enum TypeStation {
        PLUS, MOINS, NUL;
    }
    public enum sexe {
        MALE, FEMELLE, NON_BINAIRE;
    }
}
