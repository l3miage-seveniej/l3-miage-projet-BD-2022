package fr.uga.im2ag.l3.miage.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.repository.RepositoryFactory;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.LocationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.NonAbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;

public class MenuMaintenance {
    RepositoryFactory daoFactory = new RepositoryFactory();
    EntityManager entityManager = Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();
    StationRepository stationRepository = daoFactory.newStationRepository(entityManager);
    BornetteRepository bornetteRepository = daoFactory.newBornetteRepository(entityManager);
    AbonneRepository abonneRepository = daoFactory.newAbonneRepository(entityManager);
    VeloRepository veloRepository = daoFactory.newVeloRepository(entityManager);
    LocationRepository locationRepository = daoFactory.newLocationRepository(entityManager);
    NonAbonneRepository nonAbonneRepository = daoFactory.newNonAbonneRepository(entityManager);


    public void infoStations(){
        List<Station> stations = stationRepository.getAll();

        for(Station station: stations) {
            if (station.getBornettes().size() > 0) {            // Si la station a un ou plusieurs bornettes
                System.out.println(station.getAdresse());
                velosOKDansStation(station);
            } 
        }


    }
    
    public void velosOKDansStation(Station s){
        List<Bornette> bornettes = bornetteRepository.findBornetteByStation(s.getIdStation());
        int nombreVelosOk = 0;
        int nombreVelosHS = 0;
        for(Bornette bornette: bornettes){
            if(bornette.getVelo() != null){
                if(bornette.getVelo().getEtat() == Etat.OK){
                    nombreVelosOk++;
                } else if (bornette.getVelo().getEtat() == Etat.HS){
                    nombreVelosHS++;
                }
            }
        }

        int nombreVelosTotal = nombreVelosHS + nombreVelosOk;
        System.out.println("Il y a " + (nombreVelosHS + nombreVelosOk) + " velos dans Station " + s.getAdresse());
        if(nombreVelosTotal > 0){
            System.out.println("dont " + nombreVelosOk + "en bon etat et "+ nombreVelosHS + " velos hors service");
        } 

    }
}
