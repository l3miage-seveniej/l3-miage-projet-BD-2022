package fr.uga.im2ag.l3.miage.db.repository;

import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.im2ag.l3.miage.db.model.NonAbonne;
import fr.uga.im2ag.l3.miage.db.repository.api.NonAbonneRepository;
import static org.assertj.core.api.Assertions.assertThat;


public class NonAbonneTest extends Base {
    NonAbonneRepository nonabonneRepository;

    @BeforeEach
    void before() {
        nonabonneRepository = daoFactory.newNonAbonneRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }


    @Test
    void shouldSaveNonAbonne() throws ParseException {
        NonAbonne nonabonne = new NonAbonne();
        
        nonabonne.setCodeSecret(5698);
        nonabonne.setNumeroCB("4589614");

       
    
        entityManager.getTransaction().begin();
        nonabonneRepository.save(nonabonne);
        entityManager.getTransaction().commit();
        entityManager.detach(nonabonne);



        var result = nonabonneRepository.findById(nonabonne.getIdClient());
        
        assertThat(result).isNotNull();
        assertThat(result.getIdClient()).isEqualTo(nonabonne.getIdClient());
        







    }
}
