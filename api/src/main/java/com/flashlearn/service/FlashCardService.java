package com.flashlearn.service;

import com.flashlearn.entity.FlashCard;
import com.flashlearn.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashCardService {

    @Autowired
    private FlashCardRepository flashCardRepository;

    public FlashCard createFlashCard(FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    public Optional<FlashCard> getFlashCardById(Long id) {
        return flashCardRepository.findById(id);
    }

    public List<FlashCard> getAllFlashCards() {
        return flashCardRepository.findAll();
    }

    public FlashCard updateFlashCard(Long id, FlashCard flashCardDetails) {
        return flashCardRepository.findById(id)
                .map(flashCard -> {
                    flashCard.setFrontText(flashCardDetails.getFrontText());
                    flashCard.setBackText(flashCardDetails.getBackText());
                    flashCard.setGroupId(flashCardDetails.getGroupId());
                    return flashCardRepository.save(flashCard);
                })
                .orElseThrow(() -> new RuntimeException("FlashCard not found with id " + id));
    }

    public void deleteFlashCard(Long id) {
        flashCardRepository.deleteById(id);
    }
}
