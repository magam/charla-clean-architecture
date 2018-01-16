package com.fravega.ecommerce.poker.domain.hands

internal interface HandMatcher {
    fun match(cards: List<Card>): Boolean
    val value: HandValue
}

internal class HighCardHandMatcher : HandMatcher {

    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 5
    }

    override val value = HandValue.HIGH_CARD
}


internal class PairHandMatcher : HandMatcher {

    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 4
    }

    override val value = HandValue.PAIR
}

internal class ThreeHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 3
    }

    override val value = HandValue.THREE
}


