package fr.uga.im2ag.l3.miage.db.model;

public class Enums {

    public enum Situation {
        EN_STATION, EN_LOCATION, EN_MAINTENANCE;
    }
    
    public enum Etat {
        OK, HS;
    }

    /**
     * Valeur par minute
     */
    public enum Modele {
        HOLLANDAIS(1), VTC(2), VTT(4);
        private final int valeur;

        private Modele(int valeur) {
            this.valeur = valeur;
        }

        public int getValeur() {
            return this.valeur;
        }
    }

    
    public enum VType {
        PLUS, MOINS, NUL;
    }
    public enum sexe {
        MALE, FEMELLE, NON_BINAIRE;
    }
}
