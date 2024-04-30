package com.capaub.msQuizz.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QuizzRepository {
    private final JdbcTemplate jdbcTemplate;

    public QuizzRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Map<String, Object>> callspRandQuestion(int theme, int level) {
        String sql = "CALL spRandQuestion(?,?)";
        return jdbcTemplate.queryForList(sql, theme, level);
    }
}
