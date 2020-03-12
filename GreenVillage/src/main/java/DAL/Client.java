/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Matthieu Pauchet Février 2020
 */
public class Client {

    private int cli_id;
    private String cli_nom;
    private String cli_prenom;
    private String cli_rue;
    private String cli_code_postal;
    private String cli_ville;
    private String cli_pays;
    private String cli_mail;
    private String cli_password;
    private String cli_telephone;
    private String cli_statut;
    private int cli_coefficient;

    public Client(int cli_id, String cli_nom, String cli_prenom, String cli_rue, String cli_code_postal, String cli_ville, String cli_pays, String cli_mail, String cli_password, String cli_telephone, String cli_statut, int cli_coefficient) {
        this.cli_id = cli_id;
        this.cli_nom = cli_nom;
        this.cli_prenom = cli_prenom;
        this.cli_rue = cli_rue;
        this.cli_code_postal = cli_code_postal;
        this.cli_ville = cli_ville;
        this.cli_pays = cli_pays;
        this.cli_mail = cli_mail;
        this.cli_password = cli_password;
        this.cli_telephone = cli_telephone;
        this.cli_statut = cli_statut;
        this.cli_coefficient = cli_coefficient;
    }

    public Client() {
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nom() {
        return cli_nom;
    }

    public void setCli_nom(String cli_nom) {
        this.cli_nom = cli_nom;
    }

    public String getCli_prenom() {
        return cli_prenom;
    }

    public void setCli_prenom(String cli_prenom) {
        this.cli_prenom = cli_prenom;
    }

    public String getCli_rue() {
        return cli_rue;
    }

    public void setCli_rue(String cli_rue) {
        this.cli_rue = cli_rue;
    }

    public String getCli_code_postal() {
        return cli_code_postal;
    }

    public void setCli_code_postal(String cli_code_postal) {
        this.cli_code_postal = cli_code_postal;
    }

    public String getCli_ville() {
        return cli_ville;
    }

    public void setCli_ville(String cli_ville) {
        this.cli_ville = cli_ville;
    }

    public String getCli_pays() {
        return cli_pays;
    }

    public void setCli_pays(String cli_pays) {
        this.cli_pays = cli_pays;
    }

    public String getCli_mail() {
        return cli_mail;
    }

    public void setCli_mail(String cli_mail) {
        this.cli_mail = cli_mail;
    }

    public String getCli_password() {
        return cli_password;
    }

    public void setCli_password(String cli_password) {
        this.cli_password = cli_password;
    }

    public String getCli_telephone() {
        return cli_telephone;
    }

    public void setCli_telephone(String cli_telephone) {
        this.cli_telephone = cli_telephone;
    }

    public String getCli_statut() {
        return cli_statut;
    }

    public void setCli_statut(String cli_statut) {
        this.cli_statut = cli_statut;
    }

    public int getCli_coefficient() {
        return cli_coefficient;
    }

    public void setCli_coefficient(int cli_coefficient) {
        this.cli_coefficient = cli_coefficient;
    }
    
    

}
