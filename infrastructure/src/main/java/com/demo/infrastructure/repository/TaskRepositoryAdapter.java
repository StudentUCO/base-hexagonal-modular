package com.demo.infrastructure.repository;

import com.demo.domain.model.Task;
import com.demo.domain.port.out.TaskRepositoryPort;
import com.demo.infrastructure.common.SqlLoader;
import com.demo.infrastructure.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {
    private final SqlLoader sqlLoader;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = new TaskEntity();
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        String sql = sqlLoader.getSqlQuery("getAllTasks.sql");
        RowMapper<Task> rowMapper = new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Task.rebuild(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getTimestamp("creation_date").toLocalDateTime(),
                        rs.getBoolean("completed")
                );
            }
        };
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
