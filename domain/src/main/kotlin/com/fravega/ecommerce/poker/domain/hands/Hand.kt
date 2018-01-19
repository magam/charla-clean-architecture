package com.fravega.ecommerce.poker.domain.hands

enum class HandValue(val value: Int) {
    HIGH_CARD(20),
    PAIR(21),
    TWO_PAIRS(22),
    THREE(23),
    STRAIGHT(24),
    FLUSH(25),
    FULL_HOUSE(26),
    FOUR(27),
    STRAIGHT_FLUSH(28),
    ROYAL_FLUSH(29);
}

data class CardList(val cards: List<Card>) {
    init {
        check(cards.size == 5, { "Hand must have 5 cards" })
        check(cards.groupBy { it }.count() == 5, { "Hand can't contain a repeated card" })
    }
}

data class Hand(val cardsList: CardList) {

    val value: HandValue by lazy {
        HAND_MATCHERS.first { it.match(cardsList.cards) }.value
    }

    companion object {
        private val HAND_MATCHERS: List<HandMatcher> = listOf(
                PairHandMatcher(),
                TwoPairsHandMatcher(),
                ThreeHandMatcher(),
                StraightHandMatcher(),
                FlushHandMatcher(),
                FullHouseHandMatcher(),
                FourHandMatcher(),
                StraightFlushHandMatcher(),
                RoyalFlushHandMatcher(),
                HighCardHandMatcher()
        )
    }
}

