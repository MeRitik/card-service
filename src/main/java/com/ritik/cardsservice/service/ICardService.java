package com.ritik.cardsservice.service;

import com.ritik.cardsservice.dto.CardDTO;

public interface ICardService {

    /**
     * Creates a new card associated with the provided mobile number.
     *
     * @param mobileNumber the mobile number to associate with the card
     */
    void createCard(String mobileNumber);

    /**
     * Retrieves the card details associated with the given mobile number.
     *
     * @param mobileNumber the mobile number linked to the card being fetched
     * @return a {@code CardDTO} object containing the card details
     */
    CardDTO fetchCard(String mobileNumber);

    /**
     * Updates the card details using the provided CardDTO object.
     *
     * @param cardDto the CardDTO object containing updated card details such as card number, card type,
     *                total limit, amount used, and available amount
     * @return {@code true} if the update is successful, {@code false} otherwise
     */
    boolean updateCard(CardDTO cardDto);

    /**
     * Deletes the card linked to the provided mobile number.
     *
     * @param mobileNumber the mobile number associated with the card to be deleted
     * @return {@code true} if the card is successfully deleted, {@code false} otherwise
     */
    boolean deleteCard(String mobileNumber);
}
