package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.uga.im2ag.l3.miage.db.model.NonAbonne;
import fr.uga.im2ag.l3.miage.db.repository.api.NonAbonneRepository;

public class NonAbonneRepositoryImpl extends BaseRepositoryImpl implements NonAbonneRepository {

    public NonAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void save(NonAbonne entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(NonAbonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public NonAbonne findById(Long id) {
        return entityManager.find(NonAbonne.class, id);
    }

    @Override
    public List<NonAbonne> getAll() {
        
        return entityManager.createNamedQuery("NonAbonne.getAll", NonAbonne.class).getResultList();
    }
    
}
