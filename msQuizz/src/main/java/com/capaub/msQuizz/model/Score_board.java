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
    private int idScore_Board;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Theme theme;
    private int score;
    private int timer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Level level;
}
