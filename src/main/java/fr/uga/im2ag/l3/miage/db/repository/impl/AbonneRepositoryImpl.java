package fr.uga.im2ag.l3.miage.db.repository.impl;
import fr.uga.im2ag.l3.miage.db.model.Abonne;
import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;

import java.util.List;

import javax.persistence.EntityManager;



public class AbonneRepositoryImpl extends BaseRepositoryImpl implements AbonneRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Abonne entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Abonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public Abonne findById(Long id) {
        return entityManager.find(Abonne.class, id);
    }

    @Override
    public List<Abonne> getAll() {
        
        return entityManager.createNamedQuery("Abonnes.getAll", Abonne.class).getResultList();
    }

}
