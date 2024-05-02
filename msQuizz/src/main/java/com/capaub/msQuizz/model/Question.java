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
    private int idQuestion;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Level level;
    @ManyToOne(fetch = FetchType.EAGER)
    private Theme theme;
}
