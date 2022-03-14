package fr.uga.im2ag.l3.miage.db.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Location;
import fr.uga.im2ag.l3.miage.db.model.Velo;
import fr.uga.im2ag.l3.miage.db.model.Enums.Etat;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;

public class VeloTest extends Base{
    VeloRepository veloRepository;

    @BeforeEach
    void before() {
        veloRepository = daoFactory.newVeloRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveVelo(){
        Velo v = new Velo();
        v.setEtat(Etat.OK);
        v.setModele(Enums.Modele.HOLLANDAIS);
        v.setSituation(Enums.Situation.EN_STATION);

        Location location = new Location();
        
        

        entityManager.getTransaction().begin();
        veloRepository.save(v);
        entityManager.getTransaction().commit();
        entityManager.detach(v);

        var result = veloRepository.findById(v.getNumero());

    }
    
}
