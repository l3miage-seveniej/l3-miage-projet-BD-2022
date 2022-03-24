package fr.uga.im2ag.l3.miage.db;

import java.text.ParseException;

import fr.uga.im2ag.l3.miage.db.scenario.Scenarios;
import fr.uga.im2ag.l3.miage.db.utils.LectureClavier;

public class App {

    public static void main(String[] args) {
        while(true){
            int choix = 0;
            while (choix <1 || choix >2){
                choix = LectureClavier.lireEntier("Choisissez votre choix!\n1. Mode Client\n2. Mode Administrateur");
            }

            switch(choix){
                case 1: 
                    MenuUtilisateur menu = new MenuUtilisateur();
                    
                    menu.mainMenu();
                    break;
                case 2:
                    System.out.println("");
                    Scenarios scenarios = new Scenarios();
                    int choixMenuAdmin = LectureClavier.lireEntier("Saisissez\n1 pour reset database\n 2 pour peupler la base des données! ");
                    while(choixMenuAdmin<1 || choixMenuAdmin>2){
                        choixMenuAdmin = LectureClavier.lireEntier("Saisissez\n1 pour reset database\n 2 pour peupler la base des données! ");
                    }
                    switch(choixMenuAdmin){
                        case 1: 
                            scenarios.resetDatabase();
                            break;
                        case 2:
                            try {
                                scenarios.peupler();
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            break;


                    }
                    
            }
        }

        
        /*
        try {
            scenario2();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            scenario3();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
    }
}
