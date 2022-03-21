package fr.uga.im2ag.l3.miage.db;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Persistence;

import org.assertj.core.util.DateUtil;

import fr.uga.im2ag.l3.miage.db.model.Abonne;
import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Location;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.model.Velo;
import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.model.Enums.Modele;
import fr.uga.im2ag.l3.miage.db.model.Enums.Situation;

import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;

public class MenuUtilisateur {

    public static Date convertDate(String dateString) throws ParseException {
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime());
    }

    public static Timestamp convertTimestamp(String timeString) throws ParseException {
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = format.parse(timeString);
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        return timestamp;

    }

    // A. Un abonné A venir à une station S qui est situe à 12 Avenue De Gaulle
    // B. Station S a 4 bornettes
    // C. Une bornette est en hors service
    // D. Il y a 2 VTT dans cette station
    // E. Le VTT sur bornette 1 est mise en service depuis 15 Janvier 2021
    // F. Le TT sur bornette 3 est mise en service depuis 16 Mars 2022
    // G. La station demande sonID et Code Secret
    // H. Il a mis son ID et son code secret
    // I. Il a loué un VTT
    // J. Il va à la station R qui est situe à 458 avenue de la MIAGE
    // K. La station R a une seule bornette qui est aussi libre
    // L. Il a rendu le vélo après 54 minutes

    public static void scenario1() throws ParseException {

        // A. Un abonné A venir à une station S
        Abonne A = new Abonne("MACRON", "Emmanuel", Enums.sexe.MALE, "33 Avenue Champs-Elysée",
                convertDate("2000-09-14"), convertDate("2022-03-15"));

        // B. Station S a 4 bornettes
        Station S = new Station("12 Avenue De Gaulle");
        Bornette b1 = new Bornette(Enums.Etat.OK, S);
        Bornette b2 = new Bornette(Enums.Etat.OK, S);
        Bornette b3 = new Bornette(Enums.Etat.OK, S);

        // C. Une bornette est en hors service
        Bornette b4 = new Bornette(Enums.Etat.HS, S);

        EntityManager entityManager;
        StationRepository stationRepository;

        // entityManager.getTransaction().begin();
        // stationRepository.save(S);
        // entityManager.getTransaction().commit();

        // D. Il y a 2 velo dans cette station, VTT et VTC
        // E. Le VTT sur bornette 1 est mise en service depuis 15 Janvier 2021
        Velo v1 = new Velo(Enums.Modele.VTT, Etat.OK, Situation.EN_STATION, convertDate("2021-01-15"), b1);

        // F. Le VTT sur bornette 3 est mise en service depuis 16 Mars 2022
        Velo v2 = new Velo(Enums.Modele.VTT, Etat.OK, Situation.EN_STATION, convertDate("2022-03-16"), b3);

        // G. La station demande son ID Client et Code Secret
        System.out.println("Veuillez saisir votre ID et Code Secret!");
        // To Do

        // H. Il a mis son ID et son code secret
        // To Do

        // I. Il a loué un VTT
        Location l = new Location();
        l.setClient(A);
        l.addVelos(v1);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        l.startLocation(S, currentTime);

        System.out.println("-------------------------------------");
        System.out.println(v1.toString());
        System.out.println("-------------------------------------");

        A.addLocation(l);

        // J. Il va à la station R qui est situe à 458 avenue de la MIAGE
        Station R = new Station("458 avenue de la MIAGE");

        // K. La station R a une seule bornette qui est aussi libre
        Bornette BRetour = new Bornette(Enums.Etat.OK, R);

        // L. Il a rendu le vélo après 54 minutes
        l.endLocation(R, new Timestamp((currentTime.getTime() + (54 * 60 * 1000))));

        BRetour.setVelo(v1);

        System.out.println("-------------------------------------");
        System.out.println(A.toString());
        System.out.println("-------------------------------------");
        System.out.println(l.toString());
        System.out.println("-------------------------------------");
        System.out.println(S.toString());
        System.out.println("-------------------------------------");
        System.out.println(R.toString());
        System.out.println("-------------------------------------");
        System.out.println(v1.toString());
        System.out.println("-------------------------------------");

    }

    // Il existe 4 station
    // Station A a 4 bornettes libres et fonctionnent bien
    // Station B a 4 bornettes qui sont hors services
    public static void peupler() {
    }

    public static void inscrire() {

        Scanner scanner = new Scanner(System.in);
        
        //*****paramètre à saisir*******
        Abonne nouvelleAbonne;
        String nom;
        String prenom;
        Date dateNaissance;
        Enums.sexe sexe;
        String adresse;
        Date dateAbonnement;
        
        //*****Saisie du nom***** 
        System.out.println("Saisissez votre nom de Famille:");
        nom = scanner.nextLine();
        //*****Saisie du prenom*****
        System.out.println("Saisissez votre prenom ");
        prenom = scanner.nextLine();
        //*****Saisie de la date de naissance*****
        dateNaissance = new Date(System.currentTimeMillis());//initialisation
        System.out.println("Saisissez votre date de naissance date (AAAA-MM-JJ): ");
        String str = scanner.nextLine();
            //Ici on verifie que str demandé est au bon format =)
            try {
                dateNaissance = Fixtures.convertDate(str);
            }catch (Exception e) {
                System.out.println(e);
         }
        //*****Saisie du sexe*****
        int i = 0;
        sexe = Enums.sexe.NON_BINAIRE;//initialisation
        while (i >= 1 && i <= 3) {
            System.out.println("Saisissez votre sexe : ");
            System.out.println(" saisissez 1 pour homme : ");
            System.out.println(" saisissez 2 pour femme : ");
            System.out.println(" saisissez 3 pour non binaire : ");
            i = scanner.nextInt();
        }
        switch (i){
            case 1:
                sexe = Enums.sexe.MALE;
            break;
            
            case 2:
                sexe = Enums.sexe.FEMELLE;
            break;
            
            case 3:
                sexe = Enums.sexe.NON_BINAIRE;
            break;
                
            default:
            break;

            
        }
        //*****Saisie de l'adresse*****
        System.out.println("Saisissez votre adresse : ");
        adresse = scanner.nextLine();

        //*****Saisie du mot de passe*****
        
        
        
        //date d'inscription = date de souscription d'un abonnement 
         dateAbonnement = new Date(System.currentTimeMillis());

        //instantiation d'un nouvelle abonné
         nouvelleAbonne = new Abonne(nom, prenom, sexe, adresse, dateNaissance, dateAbonnement);
         
         
         //nouvelleAbonne
        

    }

    // TODO: JONATHAN

    // TODO: Identifier

    // TODO: Connexion Anonyme

    // ====================================== //

    // TODO: VINICIUS

    // TODO: Enprunt
        // 1 -> Demander le Code Secret
        // 2 -> Choisir une borne NON LIBRE avec un Velo avec Etat OK
            // Generer New Location :
                // 1 -> set la Location de velo égale la nouvelle location géneré
                // 2 -> set la Location du client égale la nouvelle location géneré
                // 3 -> set heureDebut = now()
                // 4 -> set heurefin = null
    public void emprunt() {

        Scanner scanner = new Scanner(System.in);
        
        String codeSecret;
        int borneN = -1;

        // Liste des Bornettes
        Station station = new Station();

        Bornette b1 = new Bornette(Etat.OK, station);
        Bornette b2 = new Bornette(Etat.OK, station);
        Bornette b3 = new Bornette(Etat.HS, station);

        Velo v1 = new Velo(Modele.VTC, Etat.OK, Situation.EN_STATION, new Date(2020, 1, 1), b1);
        Velo v2 = new Velo(Modele.VTT, Etat.OK, Situation.EN_STATION, new Date(2020, 1, 4), b2);
        Velo v3 = new Velo(Modele.HOLLANDAIS, Etat.HS, Situation.EN_STATION, new Date(2020, 2, 9), b3);

        b1.setVelo(v1);
        b2.setVelo(v2);
        b3.setVelo(v3);

        station.setBornettes(Arrays.asList(b1, b2, b3));

        // Fin Liste des Bornettes

        System.out.println("Saisir votre code secret : ");
        codeSecret = scanner.nextLine();

        // Afficher la liste des bornettes
        System.out.println("Choisir une des bornettes : ");
        // Parcourir la liste des bornettes
        int index = 1;
        for (Bornette bornette : station.getBornettes()) {
            System.out.println(index + " - Bornette B" + (index++));
        }

        while(borneN <= 1 || borneN >= station.getBornettes().size() + 1) {
            borneN = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(borneN);
    } 

    

    // TODO: Rendu
        // 1 -> Demander le Code Secret
        // 2 -> Choisir une borne LIBRE
            // Mettre a jour / Modifier la Location :
                // 1 -> set heureFin = now()
                // 2 -> calculCout()

    // TODO: Declaration Etat
        // Set l'etat du velo du client, lié par la location
            // 1 -> Velo.etatV = OK | HS
}
