package com.fravega.ecommerce.poker.domain

enum class CardValue(val points: Int) {
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
    KING(13),
    ACE(14);

    companion object {
        fun fromValue(value: Int) = CardValue.values().first { it.points == value }
    }
}

enum class Suit(private val code: String) {
    DIAMONDS("D"),
    HEARTS("H"),
    CLUBS("C"),
    SPADES("S");

    companion object {
        fun fromCode(code: String) = Suit.values().first { it.code == code }
    }

}

data class Card(val cardValue: CardValue, val suit: Suit) {
    init {
        check(cardValue.points in 2..14, { "Card points must be between 2 and 14" })
    }
}