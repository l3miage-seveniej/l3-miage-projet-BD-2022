package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;

public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {
     /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Bornette entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Bornette entity) {
        entityManager.remove(entity);
    }

    @Override
    public Bornette findById(Long id) {
        return entityManager.find(Bornette.class, id);
    }

    @Override
    public List<Bornette> getAll() {
        
        return entityManager.createNamedQuery("Bornette.getAll", Bornette.class).getResultList();
    }

}
