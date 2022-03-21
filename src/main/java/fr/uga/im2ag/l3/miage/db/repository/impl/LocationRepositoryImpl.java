package fr.uga.im2ag.l3.miage.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import fr.uga.im2ag.l3.miage.db.model.Location;
import fr.uga.im2ag.l3.miage.db.repository.api.LocationRepository;

public class LocationRepositoryImpl extends BaseRepositoryImpl implements LocationRepository {
    public LocationRepositoryImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public void save(Location entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Location entity) {
        entityManager.remove(entity);
    }

    @Override
    public Location findById(Long id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public List<Location> getAll() {
        
        return entityManager.createNamedQuery("Location.getAll", Location.class).getResultList();
    }


}
