package com.ritik.cardsservice.service.impl;

import com.ritik.cardsservice.constants.CardConstants;
import com.ritik.cardsservice.dto.CardDTO;
import com.ritik.cardsservice.entities.Card;
import com.ritik.cardsservice.exception.CardAlreadyExistsException;
import com.ritik.cardsservice.exception.ResourceNotFoundException;
import com.ritik.cardsservice.mapper.CardsMapper;
import com.ritik.cardsservice.repository.CardRepository;
import com.ritik.cardsservice.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {
        cardRepository.findByMobileNumber(mobileNumber)
                .ifPresent(card -> {
                    throw new CardAlreadyExistsException("Card already exists for the given mobile number:" + mobileNumber);
                });

        cardRepository.save(createNewCard(mobileNumber));
    }

    private Card createNewCard(String mobileNumber) {
        Card card = new Card();

        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        card.setCardNumber(String.valueOf(randomCardNumber));
        card.setMobileNumber(mobileNumber);
        card.setCardType(CardConstants.CREDIT_CARD);
        card.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        card.setAvailableLimit(CardConstants.NEW_CARD_LIMIT);
        card.setAmountUsed(0.0);
        return card;
    }

    @Override
    public CardDTO fetchCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));

        return CardsMapper.mapToCardsDto(card, new CardDTO());
    }

    @Override
    public boolean updateCard(CardDTO cardDto) {
        Card card = cardRepository.findByMobileNumber(cardDto.getMobileNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", cardDto.getMobileNumber()));

        CardsMapper.mapToCards(cardDto, card);
        cardRepository.save(card);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));

        cardRepository.deleteById(card.getCardId());
        return true;
    }
}
