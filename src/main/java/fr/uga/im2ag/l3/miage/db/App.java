package fr.uga.im2ag.l3.miage.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

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
            while (choix < 1 || choix > 4) {
                choix = LectureClavier.lireEntier(
                        "Choisissez votre choix!\n1. Mode Client\n2. Mode Administrateur\n3. Mode Maintenance\n4. Quitter l'application");
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
                            .lireEntier("Saisissez\n1 pour reset database\n2 pour peupler la base des données!\n3 pour peupler la base des données avec le script .sql ");
                    while (choixMenuAdmin < 1 || choixMenuAdmin > 3) {
                        choixMenuAdmin = LectureClavier
                                .lireEntier("Saisissez\n1 pour reset database\n2 pour peupler la base des données!\n3 pour peupler la base des données avec le script .sql ");
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
                        case 3:
                            // Ne fonctionne pas
                            InputStream sqlFileInputStream = Thread.currentThread().getContextClassLoader()
                                .getResourceAsStream("script.sql");

                            // Convert input stream to something that can be read line-by-line

                            BufferedReader sqlFileBufferedReader = new BufferedReader(
                                    new InputStreamReader(sqlFileInputStream));
                            try {
                                menuAdmin.peuplerParScript(sqlFileBufferedReader);
                            } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println(e);
                            }
                            break;
                    }
                    break;
                case 3:
                    MenuMaintenance menuMaintenance = new MenuMaintenance();
                    int choixmenuMaintenance = LectureClavier
                            .lireEntier("Saisissez\n1 pour informations des stations");
                    while (choixmenuMaintenance < 1 || choixmenuMaintenance > 2) {
                        choixMenuAdmin = LectureClavier
                                .lireEntier("Saisissez\n1 pour reset database\n2 pour peupler la base des données! ");
                    }

                    switch (choixmenuMaintenance) {
                        case 1:

                            menuMaintenance.infoStations();

                    }

                    break;
                case 4:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;

            }
        }

        
    }
}
