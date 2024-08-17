package com.flashlearn.controller;

import com.flashlearn.entity.FlashCardsGroup;
import com.flashlearn.service.FlashCardsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flashcardsgroups")
public class FlashCardsGroupController {

    @Autowired
    private FlashCardsGroupService flashCardsGroupService;

    @PostMapping
    public FlashCardsGroup createFlashCardsGroup(@RequestBody FlashCardsGroup flashCardsGroup) {
        return flashCardsGroupService.createFlashCardsGroup(flashCardsGroup);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashCardsGroup> getFlashCardsGroupById(@PathVariable Long id) {
        Optional<FlashCardsGroup> flashCardsGroup = flashCardsGroupService.getFlashCardsGroupById(id);
        return flashCardsGroup.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FlashCardsGroup> getAllFlashCardsGroups() {
        return flashCardsGroupService.getAllFlashCardsGroups();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashCardsGroup> updateFlashCardsGroup(@PathVariable Long id, @RequestBody FlashCardsGroup flashCardsGroupDetails) {
        try {
            FlashCardsGroup updatedFlashCardsGroup = flashCardsGroupService.updateFlashCardsGroup(id, flashCardsGroupDetails);
            return ResponseEntity.ok(updatedFlashCardsGroup);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashCardsGroup(@PathVariable Long id) {
        try {
            flashCardsGroupService.deleteFlashCardsGroup(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
