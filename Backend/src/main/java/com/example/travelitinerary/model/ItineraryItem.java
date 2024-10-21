package com.example.travelitinerary.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItineraryItem {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}