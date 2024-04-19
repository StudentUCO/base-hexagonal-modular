package com.demo.infrastructure.adapter.out;

import com.demo.domain.model.Task;
import com.demo.domain.port.out.TaskRepositoryPort;
import com.demo.infrastructure.common.SqlLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {
    private final SqlLoader sqlLoader;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Task save(Task task) {
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        String sql = sqlLoader.getSqlQuery("getAllTasks.sql");
        RowMapper<Task> rowMapper = (rs, rowNum) -> Task.rebuild(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getTimestamp("creation_date").toLocalDateTime(),
                rs.getBoolean("completed")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Task> update(Task task) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
