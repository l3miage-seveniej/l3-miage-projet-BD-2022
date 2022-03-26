package fr.uga.im2ag.l3.miage.db.repository.api;

import java.util.List;

import fr.uga.im2ag.l3.miage.db.model.Bornette;

public interface BornetteRepository  extends Repository<Bornette, Long> {
    List<Bornette> findBornetteByStation(Long idStation);
}
