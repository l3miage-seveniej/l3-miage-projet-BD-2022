package fr.uga.im2ag.l3.miage.db;

import java.text.ParseException;

import fr.uga.im2ag.l3.miage.db.scenario.Scenarios;
import fr.uga.im2ag.l3.miage.db.utils.LectureClavier;

public class App {

    public static void main(String[] args) {

        System.out.println("##############################################");
        System.out.println(" | _ \\_ _ ___ (_)___| |_  | _ )   \\|   \\ ");
        System.out.println(" |  _/ '_/ _ \\| / -_)  _| | _ \\ |) | |) |");
        System.out.println(" |_| |_| \\___// \\___|\\__| |___/___/|___/ ");
        System.out.println("            |__/                         ");
        System.out.println("##############################################");
        System.out.println("");
        while (true) {
            int choix = 0;
            while (choix < 1 || choix > 3) {
                choix = LectureClavier.lireEntier(
                        "Choisissez votre choix!\n1. Mode Client\n2. Mode Administrateur\n3. Quitter l'application");
                System.out.println("");
            }

            switch (choix) {
                case 1:
                    MenuUtilisateur menu = new MenuUtilisateur();

                    menu.mainMenu();
                    break;
                case 2:
                    System.out.println("");
                    MenuAdministrateur menuAdmin = new MenuAdministrateur();
                    int choixMenuAdmin = LectureClavier
                            .lireEntier("Saisissez\n1 pour reset database\n2 pour peupler la base des données! ");
                    while (choixMenuAdmin < 1 || choixMenuAdmin > 2) {
                        choixMenuAdmin = LectureClavier
                                .lireEntier("Saisissez\n1 pour reset database\n2 pour peupler la base des données! ");
                    }
                    switch (choixMenuAdmin) {
                        case 1:
                            menuAdmin.resetDatabase();
                            break;
                        case 2:
                            try {
                                menuAdmin.peupler();
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;

            }
        }

        /*
         * try {
         * scenario2();
         * } catch (ParseException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         * try {
         * scenario3();
         * } catch (ParseException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */
    }
}
