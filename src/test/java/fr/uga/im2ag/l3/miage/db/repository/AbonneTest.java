package fr.uga.im2ag.l3.miage.db.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Abonne;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class AbonneTest extends Base {
    AbonneRepository abonneRepository;

    @BeforeEach
    void before() {
        abonneRepository = daoFactory.newAbonneRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveAbonne() throws ParseException {
        Abonne abonne = new Abonne();
        
        abonne.setAdresse("33 Avenue Champs Elysee");
        abonne.setCodeSecret(5698);
        abonne.setNom("Macrone");
        abonne.setPrenom("Emmanuelle");
        abonne.setSexe(Enums.sexe.FEMELLE);
        abonne.setNumeroCB(4589614);

        String formatDate = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);

        
        java.util.Date dateUtil = simpleDateFormat.parse("15-12-2022");
        java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
        abonne.setDateDebut(sqlDate);

        java.util.Date dateNais = simpleDateFormat.parse("14-12-2000");
        abonne.setDateNaissance(new java.sql.Date(dateNais.getTime()));



        
        entityManager.getTransaction().begin();
        abonneRepository.save(abonne);
        entityManager.getTransaction().commit();
        entityManager.detach(abonne);


        var result = abonneRepository.findById(abonne.getIdClient());
        
        assertThat(result).isNotNull();
        assertThat(result.getIdClient()).isEqualTo(abonne.getIdClient());
        assertThat(result.getDateFin()).isEqualTo(new java.sql.Date((abonne.getDateDebut().getTime() + (365l*24l*60l*60l*1000l))) ); // verifie si la date fin est un an apres la date debut


    }

}
