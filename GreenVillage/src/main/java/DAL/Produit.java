/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author 80010-58-17
 */
public class Produit {

    private int id;
    private String libCourt;
    private String libLong;
    private double prixAchat;
    private String photo;
    private int rubId;
    private int fouId;

    public Produit() {
    }

    public Produit(int id, String libCourt, String libLong, double prixAchat, String photo, int rubId, int fouId) {
        this.id = id;
        this.libCourt = libCourt;
        this.libLong = libLong;
        this.prixAchat = prixAchat;
        this.photo = photo;
        this.rubId = rubId;
        this.fouId = fouId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibCourt() {
        return libCourt;
    }

    public void setLibCourt(String libCourt) {
        this.libCourt = libCourt;
    }

    public String getLibLong() {
        return libLong;
    }

    public void setLibLong(String libLong) {
        this.libLong = libLong;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRubId() {
        return rubId;
    }

    public void setRubId(int rubId) {
        this.rubId = rubId;
    }

    public int getFouId() {
        return fouId;
    }

    public void setFouId(int fouId) {
        this.fouId = fouId;
    }
    
    

}
