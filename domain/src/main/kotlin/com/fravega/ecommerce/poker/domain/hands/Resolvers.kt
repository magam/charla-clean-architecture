package com.fravega.ecommerce.poker.domain.hands

internal interface HandMatcher {
    fun match(cards: List<Card>): Boolean
    fun value(): HandValue
}

internal class PairHandMatcher : HandMatcher {

    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 4
    }

    override fun value() = HandValue.PAIR
}

