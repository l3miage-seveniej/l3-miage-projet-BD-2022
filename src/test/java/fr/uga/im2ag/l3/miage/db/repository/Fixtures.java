package fr.uga.im2ag.l3.miage.db.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import fr.uga.im2ag.l3.miage.db.model.Abonne;
import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Creneau;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.NonAbonne;
import fr.uga.im2ag.l3.miage.db.model.Station;

public class Fixtures {
    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Date convertDate(String dateString) throws ParseException {
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime());
    }

    public static Timestamp convertTimestamp(String timeString) throws ParseException {
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = format.parse(timeString);
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        return timestamp;

    }

    public static Enums.sexe getRandomSexe() {
        Enums.sexe sexe;
        sexe = Enums.sexe.values()[new Random().nextInt(3)];
        return sexe;
    }

    public static Enums.TypeStation getRandomTypeStation() {
        Enums.TypeStation TS;
        TS = Enums.TypeStation.values()[new Random().nextInt(3)];
        return TS;
    }

    public static Enums.Etat getRandomEtatBornette() {
        Enums.Etat etatB;
        etatB = Enums.Etat.values()[new Random().nextInt(2)];
        return etatB;
    }


    public static Abonne createAbonne(Date dateAbonnement) {
        Abonne newAbonne = new Abonne()
                .setPrenom(FAKER.funnyName().name())
                .setNom(FAKER.gameOfThrones().character())
                .setAdresse(FAKER.address().fullAddress())
                .setDateNaissance(new java.sql.Date(FAKER.date().past(60 * 365, 30 * 365, TimeUnit.DAYS).getTime()))
                .setSexe(getRandomSexe())
                .setDateDebut(dateAbonnement);

        newAbonne.setCodeSecret(9999);
        return newAbonne;
        // to do
        // code secret generator
        // .setCodeSecret(new Random().nextInt(arg0));
    }

    public static NonAbonne createNonAbonne(String numeroCB) {
        NonAbonne newNA = new NonAbonne();

        newNA.setNumeroCB(numeroCB)
                .setCodeSecret(9999);

        return newNA;

    }

    public static Creneau createCreneau(String hDebut, Station s) throws ParseException {
        Creneau newCreneau = new Creneau();

        newCreneau.sethDebut(convertTimestamp(hDebut))
                .setStation(s)
                .setTypeStation(getRandomTypeStation());

        return newCreneau;

    }

    public static Station createStation(Bornette... bornettes) {
        Station newStation = new Station();

        newStation.setAdresse(FAKER.address().fullAddress())
                .setType(getRandomTypeStation());

        if (bornettes != null) {
            newStation.setBornettes(Arrays.asList(bornettes));
        }
        return newStation;

    }

    public static Bornette createBornette(Station s, Enums.Etat ...b){
        Bornette newBornette = new Bornette();

        newBornette.setLibre(true).setStation(s);

        if (b!=null){
            newBornette.setEtatB(b[0]);
        } else{
            newBornette.setEtatB(getRandomEtatBornette());
        }

        return newBornette;

    }
}
