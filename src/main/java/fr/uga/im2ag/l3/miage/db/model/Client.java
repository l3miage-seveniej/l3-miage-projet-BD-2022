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
    private Long idClient;
    private int numeroCB;
    private int codeSecret;

    @OneToMany(targetEntity = Velo.class)
    private List<Velo> velos;
    
    @OneToMany(targetEntity = Client.class)
    private List<Client> clients;


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
    public List<Velo> getVelos() {
        return velos;
    }
    public void setVelos(List<Velo> velos) {
        this.velos = velos;
    }
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    
    
}
