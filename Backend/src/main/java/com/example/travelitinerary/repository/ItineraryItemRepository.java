package com.example.travelitinerary.repository;

import com.example.travelitinerary.model.ItineraryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ItineraryItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_ITEM = "INSERT INTO itinerary_items (user_id, title, description, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ITEMS_BY_USER = "SELECT * FROM itinerary_items WHERE user_id = ?";
    private static final String SELECT_ITEM_BY_ID_AND_USER = "SELECT * FROM itinerary_items WHERE id = ? AND user_id = ?";
    private static final String UPDATE_ITEM = "UPDATE itinerary_items SET title = ?, description = ?, start_time = ?, end_time = ? WHERE id = ? AND user_id = ?";
    private static final String DELETE_ITEM = "DELETE FROM itinerary_items WHERE id = ? AND user_id = ?";

    public List<ItineraryItem> findAllByUserId(Long userId) {
        return jdbcTemplate.query(SELECT_ALL_ITEMS_BY_USER, new ItineraryItemRowMapper(), userId);
    }

    public Optional<ItineraryItem> findByIdAndUserId(Long id, Long userId) {
        List<ItineraryItem> itineraryItemsMatches =  jdbcTemplate.query(SELECT_ITEM_BY_ID_AND_USER, new ItineraryItemRowMapper(), id, userId);

        if(itineraryItemsMatches.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(itineraryItemsMatches.get(0));
    }

    public ItineraryItem save(ItineraryItem item) {
        jdbcTemplate.update(INSERT_ITEM, item.getUserId(), item.getTitle(), item.getDescription(), item.getStartTime(), item.getEndTime());
        return item;
    }

    public ItineraryItem update(ItineraryItem item) {
        jdbcTemplate.update(UPDATE_ITEM, item.getTitle(), item.getDescription(), item.getStartTime(), item.getEndTime(), item.getId(), item.getUserId());
        return item;
    }

    public void delete(Long id, Long userId) {
        jdbcTemplate.update(DELETE_ITEM, id, userId);
    }

    private static class ItineraryItemRowMapper implements RowMapper<ItineraryItem> {
        @Override
        public ItineraryItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            ItineraryItem item = new ItineraryItem();
            item.setId(rs.getLong("id"));
            item.setUserId(rs.getLong("user_id"));
            item.setTitle(rs.getString("title"));
            item.setDescription(rs.getString("description"));
            item.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
            item.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
            return item;
        }
    }
}