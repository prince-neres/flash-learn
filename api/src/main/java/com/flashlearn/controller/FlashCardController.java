package com.flashlearn.controller;

import com.flashlearn.entity.FlashCard;
import com.flashlearn.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flashcards")
public class FlashCardController {

    @Autowired
    private FlashCardService flashCardService;

    @PostMapping
    public FlashCard createFlashCard(@RequestBody FlashCard flashCard) {
        return flashCardService.createFlashCard(flashCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashCard> getFlashCardById(@PathVariable Long id) {
        Optional<FlashCard> flashCard = flashCardService.getFlashCardById(id);
        return flashCard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FlashCard> getAllFlashCards() {
        return flashCardService.getAllFlashCards();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashCard> updateFlashCard(@PathVariable Long id, @RequestBody FlashCard flashCardDetails) {
        try {
            FlashCard updatedFlashCard = flashCardService.updateFlashCard(id, flashCardDetails);
            return ResponseEntity.ok(updatedFlashCard);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashCard(@PathVariable Long id) {
        try {
            flashCardService.deleteFlashCard(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
