package com.example.travelitinerary.controller;

import com.example.travelitinerary.model.ItineraryItem;
import com.example.travelitinerary.repository.ItineraryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {

    @Autowired
    private ItineraryItemRepository itineraryItemRepository;

    @GetMapping
    public List<ItineraryItem> getAllItems() {
        Long userId = getCurrentUserId();
        return itineraryItemRepository.findAllByUserId(userId);
    }

    @PostMapping
    public ItineraryItem createItem(@RequestBody ItineraryItem item) {
        item.setUserId(getCurrentUserId());
        return itineraryItemRepository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItineraryItem> updateItem(@PathVariable Long id, @RequestBody ItineraryItem itemDetails) {
        Long userId = getCurrentUserId();
        return itineraryItemRepository.findByIdAndUserId(id, userId)
                .map(existingItem -> {
                    existingItem.setTitle(itemDetails.getTitle());
                    existingItem.setDescription(itemDetails.getDescription());
                    existingItem.setStartTime(itemDetails.getStartTime());
                    existingItem.setEndTime(itemDetails.getEndTime());
                    return ResponseEntity.ok(itineraryItemRepository.update(existingItem));
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Long userId = getCurrentUserId();
        return itineraryItemRepository.findByIdAndUserId(id, userId)
                .map(item -> {
                    itineraryItemRepository.delete(id, userId);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    private Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Long.parseLong(authentication.getName());
    }
}