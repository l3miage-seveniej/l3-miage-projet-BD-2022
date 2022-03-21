package fr.uga.im2ag.l3.miage.db;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import fr.uga.im2ag.l3.miage.db.model.Enums.Situation;


public class App {

    public static Date convertDate(String dateString) throws ParseException {
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime());
    }

    public static Timestamp convertTimestamp(String timeString) throws ParseException {
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = format.parse(timeString);
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        return timestamp;

    }

    public static void main(String[] args)  {
        // Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();


        try {
            scenario1();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // A. Un abonné A venir à une station S qui est situe à 12 Avenue De Gaulle
    // B. Station S a 4 bornettes
    // C. Une bornette est en hors service
    // D. Il y a 2 VTT dans cette station
    // E. Le VTT sur bornette 1 est mise en service depuis 15 Janvier 2021
    // F. Le TT sur bornette 3 est mise en service depuis 16 Mars 2022
    // G.  La station demande sonID et Code Secret
    // H. Il a mis son ID et son code secret
    // I. Il a loué un VTT 
    // J. Il va à la station R qui est situe à 458 avenue de la MIAGE
    // K. La station R a une seule bornette qui est aussi libre
    // L. Il a rendu le vélo après 54 minutes 

    public static void scenario1() throws ParseException{

        // A. Un abonné A venir à une station S
        Abonne A = new Abonne("MACRON", "Emmanuel", Enums.sexe.MALE, "33 Avenue Champs-Elysée", convertDate("2000-09-14"), convertDate("2022-03-15"));

        // B. Station S a 4 bornettes
        Station S = new Station("12 Avenue De Gaulle");
        Bornette b1 = new Bornette(Enums.Etat.OK, S);
        Bornette b2 = new Bornette(Enums.Etat.OK, S);
        Bornette b3 = new Bornette(Enums.Etat.OK, S);

        // C. Une bornette est en hors service
        Bornette b4 = new Bornette(Enums.Etat.HS, S);
        
        // D. Il y a 2 velo dans cette station, VTT et VTC
        // E. Le VTT sur bornette 1 est mise en service depuis 15 Janvier 2021
        Velo v1 = new Velo(Enums.Modele.VTT, Etat.OK, Situation.EN_STATION, convertDate("2021-01-15"), b1);

        // F. Le VTT sur bornette 3 est mise en service depuis 16 Mars 2022
        Velo v2 = new Velo(Enums.Modele.VTT, Etat.OK, Situation.EN_STATION, convertDate("2022-03-16"), b3);

        // G.  La station demande son ID Client et Code Secret
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
        
        

        A.addLocation(l);

        // J. Il va à la station R qui est situe à 458 avenue de la MIAGE
        Station R = new Station("458 avenue de la MIAGE");

        // K. La station R a une seule bornette qui est aussi libre
        Bornette BRetour = new Bornette(Enums.Etat.OK, R);


        // L. Il a rendu le vélo après 54 minutes 
        l.endLocation(R, new Timestamp((currentTime.getTime() + (54*60*1000))) );
        
        
        // To do: mettre le velo dans une bornette

        


        System.out.println(A.toString());
        System.out.println(l.toString());

    }
}
