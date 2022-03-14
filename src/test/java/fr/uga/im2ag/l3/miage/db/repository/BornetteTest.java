package fr.uga.im2ag.l3.miage.db.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class BornetteTest extends Base {
    BornetteRepository bornetteRepository;

    @BeforeEach
    void before(){
        bornetteRepository = daoFactory.newBornetteRepository(entityManager);
    }

    @AfterEach
    void after(){
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveBornette(){

        Station s = new Station();
        

        Bornette b = new Bornette();
        b.setLibre(true);
        b.setEtatB(Enums.Etat.OK);
        b.setStation( s);

        entityManager.persist(s);
        entityManager.getTransaction().begin();
        bornetteRepository.save(b);
        entityManager.getTransaction().commit();
        entityManager.detach(b);

        var result = bornetteRepository.findById(b.getNumeroB());

        assertThat(result).isNotNull();
        assertThat(result.getNumeroB()).isEqualTo(b.getNumeroB());

    }
}
