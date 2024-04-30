package com.capaub.msQuizz.service;

import com.capaub.msQuizz.repository.QuizzRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizzService {
    private final QuizzRepository quizzRepository;

    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public String convertListMapToJson(List<Map<String, Object>> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> callUserRepo(int theme, int level){
        return quizzRepository.callSpRandQuestion(theme, level);
    }
}
