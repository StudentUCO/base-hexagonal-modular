package com.demo.infrastructure.common;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Log
@Getter
@Component
public class SqlLoader {

    private final Map<String, String> sqlQueries = new HashMap<>();

    public SqlLoader() {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // Modificado para leer archivos .sql en subdirectorios
            Resource[] resources = resolver.getResources("classpath:sql/**/*.sql");
            for (Resource resource : resources) {
                InputStream inputStream = resource.getInputStream();
                String sql = new BufferedReader(new InputStreamReader(inputStream))
                        .lines().collect(Collectors.joining(" "));
                sqlQueries.put(resource.getFilename(), sql);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load SQL scripts", e);
        }
        log.info("All SQL files were loaded correctly");
    }

    public String getSqlQuery(String filename) {
        return sqlQueries.get(filename);
    }

}
