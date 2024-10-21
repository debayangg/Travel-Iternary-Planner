package com.example.travelitinerary.repository;

import com.example.travelitinerary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_USER = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

    public User save(User user) {
        jdbcTemplate.update(INSERT_USER, user.getUsername(), user.getPassword());
        return user;
    }

    public Optional<User> findByUsername(String username) {
        List<User> usernameMatches = jdbcTemplate.query(SELECT_USER_BY_USERNAME, new UserRowMapper(), username);
        
        if(usernameMatches.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(usernameMatches.get(0));
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
}