package dibenedetto.valentin.tp.models;

import android.graphics.drawable.Icon;

public class Contact {
    private Icon image;
    private String nom;
    private String prenom;
    private int tel;
    private String mail;
    private String ville;
    private boolean isFav;

    public Contact(String nom, String prenom, int tel, String mail, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.ville = ville;
    }

    public Contact(Icon image, String nom, String prenom, int tel, String mail, String ville, boolean isFav) {
        this.image = image;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.ville = ville;
        this.isFav = isFav;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean getFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }


}
