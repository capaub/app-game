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

    public List<Map<String,Object>> getTheme(){
        String sql = "SELECT * FROM `theme`";
        return this.jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> callSpRandQuestion(int theme, int level) {
        String sql = "CALL spRandQuestion(?,?)";
        return jdbcTemplate.queryForList(sql, theme, level);
    }

    public List<Map<String, Object>> getLevel() {
        String sql = "SELECT * FROM `level`";
        return this.jdbcTemplate.queryForList(sql);
    }
}