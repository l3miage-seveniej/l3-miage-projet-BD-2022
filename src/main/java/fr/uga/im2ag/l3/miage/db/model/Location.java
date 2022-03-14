package fr.uga.im2ag.l3.miage.db.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue
    private int idLoc;

    private Timestamp dateDebut;

    private Timestamp dateFin;

    private float cout;

    @ManyToMany
    private List<Velo> velo;

    @ManyToOne
    private Client client;

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public List<Velo> getVelo() {
        return velo;
    }

    public void setVelo(List<Velo> velo) {
        this.velo = velo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return idLoc;
    }

    public void setId(int idLoc) {
        this.idLoc = idLoc;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public void calculerCout(Velo velo) {
        // Calculer le temps de location
        int minute = 1000 * 60;        
        float minutes = (dateFin.getTime() - dateDebut.getTime()) / minute;
        
        // Recuperer le €/min du velo
        int valeurV = velo.getModele().getValeur();

        // Multiplier le prix par le temps (en minutes)
        float cout = valeurV * minutes;

        if (client instanceof Abonne) {
            cout = cout * 0.7f;         // Réduction de 30%
        }

        setCout(cout);
    }
}
