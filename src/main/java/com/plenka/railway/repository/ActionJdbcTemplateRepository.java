package com.plenka.railway.repository;

import com.plenka.railway.model.Action;
import com.plenka.railway.model.Status;
import com.plenka.railway.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
public class ActionJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;
    private static Action mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Action(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("date_updated",LocalDateTime.class),
                rs.getString("url"));
    }

    public List<Action> findAll() {
        String sql = "SELECT * FROM Actions";
        List<Action> actions = jdbcTemplate.query(sql, ActionJdbcTemplateRepository::mapRow);
        return actions;
    }

    public void saveOne(String title, String description, String status, String contentType, String URL) {
        String sql = "INSERT INTO Actions (title, description, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, description, status, contentType, URL);
    }

    public void updateOne(int id, String title, String description, String status, String contentType, String URL) {
        String sql = "UPDATE Actions SET title=?, description=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, description, status, contentType, URL, id);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM Actions WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Action findById(int id) {
        String sql = "SELECT * FROM Actions WHERE id=?";
        Action action = jdbcTemplate.queryForObject(sql, new Object[]{id}, ActionJdbcTemplateRepository::mapRow);
        return action;
    }
}
