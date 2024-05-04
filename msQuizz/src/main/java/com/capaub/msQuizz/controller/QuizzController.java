package com.capaub.msQuizz.controller;

import com.capaub.msQuizz.service.QuizzService;
import org.springframework.web.bind.annotation.*;

@RestController
// pour autoriser l'appel d'angular
@CrossOrigin(origins = "http://localhost:4200")
public class QuizzController {
    private final QuizzService quizzService;

    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @GetMapping("/callSpRandQuestion")
    @ResponseBody
    public String callSp(@RequestParam int theme, int level){
        return quizzService.convertListMapToJson(quizzService.callQuizz(theme, level));
    }
    @GetMapping("/getLabels")
    @ResponseBody
    public String getLabels(){
        return quizzService.convertListMapToJson(quizzService.getLabels());
    }
}