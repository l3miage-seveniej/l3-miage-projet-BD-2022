package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.impl.AbonneRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.CreneauRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.NonAbonneRepository;
import fr.uga.im2ag.l3.miage.db.repository.impl.BornetteRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.repository.impl.CreneauRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.repository.impl.NonAbonneRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;
import fr.uga.im2ag.l3.miage.db.repository.impl.StationRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;
import fr.uga.im2ag.l3.miage.db.repository.impl.VeloRepositoryImpl;

import javax.persistence.EntityManager;

public class RepositoryFactory {

    public AbonneRepository newAbonneRepository(EntityManager entityManager) {
        return new AbonneRepositoryImpl(entityManager);
    }

    public BornetteRepository newBornetteRepository(EntityManager entityManager) {
        return new BornetteRepositoryImpl(entityManager);
    }

    public StationRepository newStationRepository(EntityManager entityManager) {
        return new StationRepositoryImpl(entityManager);
    }

    public VeloRepository newVeloRepository(EntityManager entityManager) {
        return new VeloRepositoryImpl(entityManager);
    }

    public NonAbonneRepository newNonAbonneRepository(EntityManager entityManager) {
        return new NonAbonneRepositoryImpl(entityManager);
    }
    public CreneauRepository newCreneauRepository(EntityManager entityManager) {
        return new CreneauRepositoryImpl(entityManager);
    }
    


}
