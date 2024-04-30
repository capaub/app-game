package com.yohanlambeau.msuser.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private int idUser;
    private String pseudo;
    private String mail;
    private String password;

    public User(int idUser, String pseudo, String mail, String password) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
