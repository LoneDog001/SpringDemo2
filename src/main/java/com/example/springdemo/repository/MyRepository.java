package com.example.springdemo.repository;


import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String sqlScript;

    public MyRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.sqlScript = read();
    }

    public String getProductName(String name) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject(sqlScript, mapSqlParameterSource, String.class);
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("myScripts.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
