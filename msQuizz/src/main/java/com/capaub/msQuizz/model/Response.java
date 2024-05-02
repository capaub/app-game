package com.capaub.msQuizz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResponse;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;
    private boolean isTrue;
}