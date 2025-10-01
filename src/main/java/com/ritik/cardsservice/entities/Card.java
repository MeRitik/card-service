package com.ritik.cardsservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private double totalLimit;
    private double amountUsed;
    private double availableLimit;
}
