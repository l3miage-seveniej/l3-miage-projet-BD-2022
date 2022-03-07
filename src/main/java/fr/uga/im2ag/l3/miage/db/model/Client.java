package fr.uga.im2ag.l3.miage.db.model;

public class Client {
    private int nCB;
    private int codeSecret;
    
    public int getnCB() {
        return nCB;
    }
    public void setnCB(int nCB) {
        this.nCB = nCB;
    }
    public int getCodeSecret() {
        return codeSecret;
    }
    public void setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
    }
    
}
