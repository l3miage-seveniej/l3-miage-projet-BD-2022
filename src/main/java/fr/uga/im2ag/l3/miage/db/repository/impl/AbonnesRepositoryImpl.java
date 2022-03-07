package fr.uga.im2ag.l3.miage.db.repository.impl;
import fr.uga.im2ag.l3.miage.db.model.Abonnes;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonnesRepository;

import java.util.List;

import javax.persistence.EntityManager;



public class AbonnesRepositoryImpl extends BaseRepositoryImpl implements AbonnesRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public AbonnesRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Abonnes entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Abonnes entity) {
        entityManager.remove(entity);
    }

    @Override
    public Abonnes findById(Long id) {
        return entityManager.find(Abonnes.class, id);
    }

    @Override
    public List<Abonnes> getAll() {
        
        return entityManager.createNamedQuery("Abonnes.getAll", Abonnes.class).getResultList();
    }

}
