package fr.uga.im2ag.l3.miage.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.uga.im2ag.l3.miage.db.model.Abonne;
import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Creneau;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.model.Velo;
import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.model.Enums.Modele;
import fr.uga.im2ag.l3.miage.db.model.Enums.Situation;
import fr.uga.im2ag.l3.miage.db.model.Enums.sexe;
import fr.uga.im2ag.l3.miage.db.repository.RepositoryFactory;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.CreneauRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.LocationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;

public class MenuAdministrateur {
    public Date convertDate(String dateString) throws ParseException {
        return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime());
    }

    RepositoryFactory daoFactory = new RepositoryFactory();

    public void resetDatabase() {
        Map<String, String> properties = new HashMap<String, String>() {
            {
                put("hibernate.hbm2ddl.auto", "create-drop");
            }
        };
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA-HBM", properties)
                .createEntityManager();

    }

    EntityManager entityManager = Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();
    StationRepository stationRepository = daoFactory.newStationRepository(entityManager);
    BornetteRepository bornetteRepository = daoFactory.newBornetteRepository(entityManager);
    AbonneRepository abonneRepository = daoFactory.newAbonneRepository(entityManager);
    VeloRepository veloRepository = daoFactory.newVeloRepository(entityManager);
    LocationRepository locationRepository = daoFactory.newLocationRepository(entityManager);
    CreneauRepository creneauRepository = daoFactory.newCreneauRepository(entityManager);

    // Notre entreprise de location de vélos a 4 abonnées pour ce moment
    // On a 4 stations; station A,B,C,D
    // Chaque station a 4 bornettes
    // Notre entreprise avoir 6 velo qui sont circulant
    // La plupart des vélos sont garées à station D car la plupart de notre abonnées
    // sont des étudiants à l'IM2AG
    public void peupler() throws ParseException {
        

        Abonne Andreas = new Abonne("Schevchenko", "Andreas", sexe.MALE, "Paris", convertDate("1945-08-17"),
                convertDate("2022-03-20"), 666);
        Abonne Emmanuelle = new Abonne("Macrone", "Emmanuelle", sexe.FEMELLE, "Amiens", convertDate("1977-12-21"),
                convertDate("2022-03-10"), 1789);
        Abonne Sofia = new Abonne("Boutella", "Sofia", sexe.FEMELLE, "39 avenue de Deschamps",
                convertDate("1999-11-11"), convertDate("2022-02-15"), 9999);
        Abonne Theo = new Abonne("Flavius", "Theodorus", sexe.MALE, "LXIX rue des Romains", convertDate("350-01-14"),
                convertDate("2022-03-21"), 7887);

        Station A = new Station("Residential Area");
        Bornette AB1 = new Bornette(Etat.OK, A);
        Bornette AB2 = new Bornette(Etat.OK, A);
        Bornette AB3 = new Bornette(Etat.OK, A);
        Bornette AB4 = new Bornette(Etat.OK, A);

        Station B = new Station("Industrial Area");
        Bornette BB1 = new Bornette(Etat.OK, B);
        Bornette BB2 = new Bornette(Etat.OK, B);
        Bornette BB3 = new Bornette(Etat.OK, B);
        Bornette BB4 = new Bornette(Etat.HS, B);

        Station C = new Station("Shopping Area");
        Bornette CB1 = new Bornette(Etat.HS, C);
        Bornette CB2 = new Bornette(Etat.HS, C);
        Bornette CB3 = new Bornette(Etat.HS, C);
        Bornette CB4 = new Bornette(Etat.HS, C);

        Station D = new Station("Campus Area");
        Bornette DB1 = new Bornette(Etat.OK, D);
        Bornette DB2 = new Bornette(Etat.OK, D);
        Bornette DB3 = new Bornette(Etat.OK, D);
        Bornette DB4 = new Bornette(Etat.OK, D);

        Velo v1 = new Velo(Modele.HOLLANDAIS, Etat.OK, Situation.EN_STATION, convertDate("2021-12-15"), DB1);
        Velo v2 = new Velo(Modele.VTC, Etat.OK, Situation.EN_STATION, convertDate("2021-12-15"), DB2);
        Velo v3 = new Velo(Modele.HOLLANDAIS, Etat.OK, Situation.EN_STATION, convertDate("2021-12-15"), DB3);
        Velo v4 = new Velo(Modele.HOLLANDAIS, Etat.OK, Situation.EN_STATION, convertDate("2021-12-15"), DB4);
        Velo v5 = new Velo(Modele.VTT, Etat.HS, Situation.EN_STATION, convertDate("2021-12-15"), CB1);
        Velo v6 = new Velo(Modele.HOLLANDAIS, Etat.OK, Situation.EN_STATION, convertDate("2021-12-15"), AB1);


        Creneau creneau = new Creneau();
        creneau.setStation(A);
        creneau.setTypeStation(Enums.TypeStation.PLUS);
        creneau.sethDebut(new Timestamp(System.currentTimeMillis()));
        creneau.sethFin(new Timestamp(System.currentTimeMillis() + (60*60)));

        entityManager.getTransaction().begin();

        abonneRepository.save(Andreas);
        abonneRepository.save(Emmanuelle);
        abonneRepository.save(Sofia);
        abonneRepository.save(Theo);

        stationRepository.save(A);
        stationRepository.save(B);
        stationRepository.save(C);
        stationRepository.save(D);

        bornetteRepository.save(AB1);
        bornetteRepository.save(AB2);
        bornetteRepository.save(AB3);
        bornetteRepository.save(AB4);
        bornetteRepository.save(BB1);
        bornetteRepository.save(BB2);
        bornetteRepository.save(BB3);
        bornetteRepository.save(BB4);
        bornetteRepository.save(CB1);
        bornetteRepository.save(CB2);
        bornetteRepository.save(CB3);
        bornetteRepository.save(CB4);

        veloRepository.save(v1);
        veloRepository.save(v2);
        veloRepository.save(v3);
        veloRepository.save(v4);
        veloRepository.save(v5);
        veloRepository.save(v6);
        creneauRepository.save(creneau);
        entityManager.getTransaction().commit();

    }

    void peuplerParScript(BufferedReader br) throws IOException {
        String line;
        entityManager.getTransaction().begin();
        while( (line = br.readLine()) != null )
        {
            entityManager.createNativeQuery(line).executeUpdate();
        }
        entityManager.getTransaction().commit();
    }
}
