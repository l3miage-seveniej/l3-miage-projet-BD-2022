package fr.uga.im2ag.l3.miage.db.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public abstract class Client {
    @Id
    @GeneratedValue
    private Long idClient;
    private int numeroCB;
    private int codeSecret;

    @OneToMany(targetEntity = Location.class)
    List<Location> locations;

    public int getnCB() {
        return numeroCB;
    }
    public void setnCB(int numeroCB) {
        this.numeroCB = numeroCB;
    }
    public int getCodeSecret() {
        return codeSecret;
    }
    public void setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
    }
    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public int getNumeroCB() {
        return numeroCB;
    }
    public void setNumeroCB(int numeroCB) {
        this.numeroCB = numeroCB;
    }
    
    
    
}
