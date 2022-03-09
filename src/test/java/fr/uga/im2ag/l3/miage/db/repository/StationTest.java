package fr.uga.im2ag.l3.miage.db.repository;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class StationTest extends Base {
    StationRepository stationRepository;

    @BeforeEach
    void before() {
        stationRepository = daoFactory.newStationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStudent() {
        Station station = new Station();
        Bornette b = new Bornette();

        b.setEtatB(Enums.Etat.OK);
        b.setLibre(true);
        

        station.setAdresse("23 rue de la mathematique");
        station.setType(Enums.VType.PLUS);
        station.setBornettes(Arrays.asList(b));

        entityManager.persist(b);
        entityManager.getTransaction().begin();
        stationRepository.save(station);
        entityManager.getTransaction().commit();
        entityManager.detach(station);


        var result = stationRepository.findById(station.getIdStation());
        
        assertThat(result).isNotNull();
        assertThat(result.getIdStation()).isEqualTo(station.getIdStation());


    }

}
