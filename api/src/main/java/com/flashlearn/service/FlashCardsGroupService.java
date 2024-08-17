package com.flashlearn.service;

import com.flashlearn.entity.FlashCardsGroup;
import com.flashlearn.repository.FlashCardsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashCardsGroupService {

    @Autowired
    private FlashCardsGroupRepository flashCardsGroupRepository;

    public FlashCardsGroup createFlashCardsGroup(FlashCardsGroup flashCardsGroup) {
        return flashCardsGroupRepository.save(flashCardsGroup);
    }

    public Optional<FlashCardsGroup> getFlashCardsGroupById(Long id) {
        return flashCardsGroupRepository.findById(id);
    }

    public List<FlashCardsGroup> getAllFlashCardsGroups() {
        return flashCardsGroupRepository.findAll();
    }

    public FlashCardsGroup updateFlashCardsGroup(Long id, FlashCardsGroup flashCardsGroupUpdated) {
        return flashCardsGroupRepository.findById(id)
            .map(flashCardsGroup -> {
                flashCardsGroup.setName(flashCardsGroupUpdated.getName());
                flashCardsGroup.setDescription(flashCardsGroupUpdated.getDescription());
                return flashCardsGroupRepository.save(flashCardsGroup);
            })
            .orElseThrow(() -> new RuntimeException("Flash Cards Group not found with id " + id));
    }

    public void deleteFlashCardsGroup(Long id) {
        flashCardsGroupRepository.deleteById(id);
    }
}
