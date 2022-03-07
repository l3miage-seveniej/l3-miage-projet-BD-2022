package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.uga.im2ag.l3.miage.db.model.Velo;
import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;

public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository {
     /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Velo entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Velo entity) {
        entityManager.remove(entity);
    }

    @Override
    public Velo findById(Long id) {
        return entityManager.find(Velo.class, id);
    }

    @Override
    public List<Velo> getAll() {
        
        return entityManager.createNamedQuery("Velo.getAll", Velo.class).getResultList();
    }
}
