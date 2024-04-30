package com.capaub.msQuizz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestion")
    private int idQuestion;
    @Column(name = "description")
    private String description;
    @Column(name = "levelId")
    private int levelId;
    @Column(name = "themeId")
    private int themeId;
}
