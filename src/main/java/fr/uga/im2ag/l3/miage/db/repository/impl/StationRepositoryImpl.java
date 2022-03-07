package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;

public class StationRepositoryImpl extends BaseRepositoryImpl implements StationRepository {
    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public StationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Station entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Station entity) {
        entityManager.remove(entity);
    }

    @Override
    public Station findById(Long id) {
        return entityManager.find(Station.class, id);
    }

    @Override
    public List<Station> getAll() {
        
        return entityManager.createNamedQuery("Station.getAll", Station.class).getResultList();
    }
}
