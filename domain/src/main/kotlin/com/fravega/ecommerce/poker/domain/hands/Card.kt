package com.fravega.ecommerce.poker.domain.hands

enum class CardValue(val value: Int) {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);
}


data class Card(val cardValue: CardValue) {
    init {
        check(cardValue.value in 2..13, { "Card value must be between 2 and 13" })
    }
}