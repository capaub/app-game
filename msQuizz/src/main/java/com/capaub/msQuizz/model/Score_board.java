package com.capaub.msQuizz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Score_board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore_Board")
    private int idScore_Board;
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "idTheme")
    private int idTheme;
    @Column(name = "score")
    private int score;
    @Column(name = "timer")
    private int timer;
    @Column(name = "levelId")
    private int levelId;
}
