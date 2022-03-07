package fr.uga.im2ag.l3.miage.db.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue
    private int idClient;
    private int numeroCB;
    private int codeSecret;

    @OneToMany(targetEntity = Velo.class)
    private List<Velo> velos;
    
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
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
}
