package fr.uga.im2ag.l3.miage.db.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import fr.uga.im2ag.l3.miage.db.model.Creneau;
import fr.uga.im2ag.l3.miage.db.model.Enums;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.CreneauRepository;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CreneauTest extends Base{
    CreneauRepository creneauRepository;

    @BeforeEach
    void before(){
        creneauRepository = daoFactory.newCreneauRepository(entityManager);
    }

    @AfterEach
    void after(){
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveCreneau() throws ParseException{
        Creneau creneau = new Creneau();
        Station s = new Station();
        s.setAdresse("Malherbe");
        s.setType(Enums.TypeStation.NUL);
        
    creneau.setStation(s);
    creneau.setTypeStation(Enums.TypeStation.PLUS);
    //creneau.sethDebut();
    //creneau.sethFin(hFin);


    //String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(myTimestamp);
    String formatDate = "MM/dd/yyyy HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
    //java.util.Date dateUtil = simpleDateFormat.parse("15-12-2022 14:30:10");

    java.sql.Timestamp timestampDebut = java.sql.Timestamp.valueOf("15-12-2022 14:30:10");
    java.sql.Timestamp timestampFin = java.sql.Timestamp.valueOf("15-12-2022 16:30:10");

        // java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
        // Timestamp t = new Timestamp(sqlDate);
        // creneau.sethDebut(new java.sql.Timestamp(sqlDate));

        creneau.sethDebut(timestampDebut);
        creneau.sethDebut(timestampFin);

        



        entityManager.getTransaction().begin();
        creneauRepository.save(creneau);
        entityManager.getTransaction().commit();
        entityManager.detach(creneau);


        var result = creneauRepository.findById(creneau.getIdCreneau());
        
        assertThat(result).isNotNull();
        assertThat(result.getIdCreneau()).isEqualTo(creneau.getIdCreneau());











    
    }
    
}
