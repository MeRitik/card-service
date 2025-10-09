package com.ritik.cardsservice.mapper;

import com.ritik.cardsservice.dto.CardDTO;
import com.ritik.cardsservice.entities.Card;

public class CardsMapper {

    public static CardDTO mapToCardsDto(Card card, CardDTO cardDto) {
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAvailableAmount(card.getAvailableLimit());
        cardDto.setAmountUsed(card.getAmountUsed());
        return cardDto;
    }

    public static Card mapToCards(CardDTO cardDto, Card card) {
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAvailableLimit(cardDto.getAvailableAmount());
        card.setAmountUsed(cardDto.getAmountUsed());
        return card;
    }

}