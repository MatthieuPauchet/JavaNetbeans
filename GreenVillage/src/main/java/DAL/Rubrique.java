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
public class Rubrique {
    
    private int id;
    private String nom;
    private String libelle;
    private String photo;
    private int Id1;

    public Rubrique() {
    }

    public Rubrique(int id, String nom, String libelle, String photo, int rubId) {
        this.id = id;
        this.nom = nom;
        this.libelle = libelle;
        this.photo = photo;
        this.Id1 = rubId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId1() {
        return Id1;
    }

    public void setId1(int Id1) {
        this.Id1 = Id1;
    }
    
    
}
