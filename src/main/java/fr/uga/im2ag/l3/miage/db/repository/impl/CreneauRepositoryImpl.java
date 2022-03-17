package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.uga.im2ag.l3.miage.db.model.Creneau;
import fr.uga.im2ag.l3.miage.db.repository.api.CreneauRepository;

public class CreneauRepositoryImpl extends BaseRepositoryImpl implements CreneauRepository {
     /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public CreneauRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Creneau entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Creneau entity) {
        entityManager.remove(entity);
    }

    @Override
    public Creneau findById(Long id) {
        return entityManager.find(Creneau.class, id);
    }

    @Override
    public List<Creneau> getAll() {
        
        return entityManager.createNamedQuery("Creneau.getAll", Creneau.class).getResultList();
    }

}
