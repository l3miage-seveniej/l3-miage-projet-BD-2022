package fr.uga.im2ag.l3.miage.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("TYPE_ENTITE")
public abstract class Client {


    
    public Client() {
        this.locations = new ArrayList<Location>();
        
    }

    @Id
    @GeneratedValue
    private Long idClient;
    @Column(nullable = false)
    private String numeroCB;
    private int codeSecret;

    @OneToMany(targetEntity = Location.class)
    List<Location> locations;

    public int getCodeSecret() {
        return codeSecret;
    }

    public Client setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
        return this;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public String getNumeroCB() {
        return numeroCB;
    }
    public Client setNumeroCB(String numeroCB) {
        this.numeroCB = numeroCB;
        return this;
    }

    public void addLocation(Location l){
        locations.add(l);
    }

    public List<Location> getLocations() {
        return locations;
    }    

}
