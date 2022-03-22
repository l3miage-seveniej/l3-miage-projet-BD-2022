package fr.uga.im2ag.l3.miage.db;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import fr.uga.im2ag.l3.miage.db.repository.RepositoryFactory;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.LocationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;
import fr.uga.im2ag.l3.miage.db.utils.LectureClavier;

public class MenuUtilisateur {

    RepositoryFactory daoFactory = new RepositoryFactory();
         EntityManager entityManager = Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();
         StationRepository stationRepository =  daoFactory.newStationRepository(entityManager);
         BornetteRepository bornetteRepository =  daoFactory.newBornetteRepository(entityManager);
         AbonneRepository abonneRepository =  daoFactory.newAbonneRepository(entityManager);
         VeloRepository veloRepository = daoFactory.newVeloRepository(entityManager);
         LocationRepository locationRepository = daoFactory.newLocationRepository(entityManager);




    public  Date convertDate(String dateString) throws ParseException {
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime());
    }

    public  Timestamp convertTimestamp(String timeString) throws ParseException {
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = format.parse(timeString);
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        return timestamp;

    }
    


    // Il existe 4 station
    // Station A a 4 bornettes libres et fonctionnent bien
    // Station B a 4 bornettes qui sont hors services
    public static void peupler() {
    }


   public  boolean isValidDate(String d)
    {
        String regex = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
        // String regex = ' ^\d';
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }




    public boolean contientCodeSecret(int codeSecret){
        boolean b = false;
        List<Abonne> list =  abonneRepository.getAll();
        for (Abonne abonne : list) {
            if( abonne.getCodeSecret()== codeSecret){
                b = true;
            }
        }
        return b;
    }
    public String contient (int codeSecret){
        List<Abonne> list =  abonneRepository.getAll();
        String str="";
        for (Abonne abonne : list) {
            if( abonne.getCodeSecret()== codeSecret){
                str = abonne.toString();
        }
            
        }
        
        return str; 

    }
    // TODO: JONATHAN
    public  void inscrire() {

      
        
        //*****Paramètre à saisir******//
        Abonne nouvelleAbonne;
        String nom;
        String prenom;
        Date dateNaissance;
        Enums.sexe sexe;
        String adresse;
        Date dateAbonnement;
        int codeSecret;
        String numeroCB;
        
        //*****Saisie du nom***** //
        System.out.println("Saisissez votre nom de Famille:");
        nom = LectureClavier.lireChaine();
        //*****Saisie du prenom*****//
        System.out.println("Saisissez votre prenom ");
        prenom = LectureClavier.lireChaine();
        //*****Saisie de la date de naissance*****//
        //initialisation
        dateNaissance = new Date(System.currentTimeMillis());
        
        System.out.println("Saisissez votre date de naissance (AAAA-MM-JJ): ");
        String str = LectureClavier.lireChaine();
        //Ici on verifie que str demandé est au bon format )
        while(isValidDate(str)!=true){
            System.out.println("Saisissez votre date de naissance!(AAAA-MM-JJ): ");
             str = LectureClavier.lireChaine();
        }
       
            try {
                dateNaissance = convertDate(str);
            }catch (Exception e) {
               
                System.out.println("pattern de date invalide , use:(AAAA-MM-JJ)");

         }
        
        //*****Saisie du sexe*****//
        int i = 0;
        sexe = Enums.sexe.NON_BINAIRE;//initialisation
        while (i < 1 || i > 3) {
            System.out.println("Saisissez votre sexe : ");
            System.out.println(" saisissez 1 pour homme : ");
            System.out.println(" saisissez 2 pour femme : ");
            System.out.println(" saisissez 3 pour non binaire : ");
            i = LectureClavier.lireEntier("entier lu :");
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
        //*****Saisie de l'adresse*****//
        System.out.println("Saisissez votre adresse : ");
        adresse = LectureClavier.lireChaine();

        //*****Saisie du mot de passe*****//
        System.out.println("Saisissez votre code secret   : ");
        codeSecret= LectureClavier.lireEntier("code lu:");
        while(contientCodeSecret(codeSecret)==true){
        codeSecret= LectureClavier.lireEntier("entrez un nouveau code lu:");
        }
        //*****Saisie du numéro de carte bancaire****
        System.out.println("Saisissez votre numéro de carte bancaire  : ");
        numeroCB = LectureClavier.lireChaine();
        //date d'inscription = date de souscription d'un abonnement 
         dateAbonnement = new Date(System.currentTimeMillis());
        //instantiation d'un nouvelle abonné
         nouvelleAbonne = new Abonne(nom, prenom, sexe, adresse, dateNaissance, dateAbonnement);
         nouvelleAbonne.setCodeSecret(codeSecret);
         nouvelleAbonne.setNumeroCB(numeroCB);
        
         

        //  nouvelleAbonne dans la base de donnée
         entityManager.getTransaction().begin();
         abonneRepository.save(nouvelleAbonne);
         entityManager.getTransaction().commit();

    }

    

    // TODO: Identifier 

    public void identifier(){
       
        int codeSecret;
        String abonne ="";

        System.out.println("Saisissez votre code secret afin de vous identifier : ");
        codeSecret = LectureClavier.lireEntier("code lu :");
        while(contientCodeSecret(codeSecret)!=true){
            
            System.out.println("votre code secret  ne correspond à aucun abonne veuillez resaisir à nouveau votre code secret: ");
            codeSecret = LectureClavier.lireEntier("code lu :");


        }
        abonne = contient(codeSecret);
        System.out.println(" Bonjour "+abonne+".");
        


    }
   

    public Station choisirStation(){
        List<Station> ListStation = stationRepository.getAll();
        int choix;
        Station stationChoisi = null;
        int i= 0;
        while(stationChoisi == null){
            for(Station station: ListStation){
                System.out.println("choisissez un station!");
                System.out.println(i + ". " + station.getAdresse());
            }
            choix = LectureClavier.lireEntier("");
            if(ListStation.get(choix) != null){
                stationChoisi = ListStation.get(choix);
            }
        }

        return stationChoisi;

    }

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
    public void emprunt(Station S) {

        // Scanner scanner = new Scanner(System.in);
        
        int codeSecret;

        // Liste des Bornettes
        // Station station = new Station();

        // Bornette b1 = new Bornette(Etat.OK, station);
        // Bornette b2 = new Bornette(Etat.OK, station);
        // Bornette b3 = new Bornette(Etat.HS, station);

        // Velo v1 = new Velo(Modele.VTC, Etat.OK, Situation.EN_STATION, new Date(2020, 1, 1), b1);
        // Velo v2 = new Velo(Modele.VTT, Etat.OK, Situation.EN_STATION, new Date(2020, 1, 4), b2);
        // Velo v3 = new Velo(Modele.HOLLANDAIS, Etat.HS, Situation.EN_STATION, new Date(2020, 2, 9), b3);

        // b1.setVelo(v1);
        // b2.setVelo(v2);
        // b3.setVelo(v3);

        // station.setBornettes(Arrays.asList(b1, b2, b3));

        // Fin Liste des Bornettes
        // codeSecret = scanner.nextLine();

        System.out.println("Saisir votre code secret : ");
        codeSecret = LectureClavier.lireEntier("Saisir votre code secret : ");
        while( !contientCodeSecret(codeSecret)){
            System.out.println("code secret inexistante! ");
            System.out.println("resaisissez votre codre secret!");

            codeSecret = LectureClavier.lireEntier("Resaisissez votre code secret !");
        }

        System.out.println((contient(codeSecret)));




        // Afficher la liste des bornettes
        System.out.println("Choisir une des bornettes : ");
        // Parcourir la liste des bornettes
        int index = 0;
        for (Bornette bornette : S.getBornettes()) {
            System.out.println(index + " - Bornette B" + (index++));
        }
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
