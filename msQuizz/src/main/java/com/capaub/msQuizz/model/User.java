package com.capaub.msQuizz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
}
