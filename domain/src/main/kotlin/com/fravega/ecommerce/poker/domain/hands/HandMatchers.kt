package com.fravega.ecommerce.poker.domain.hands

internal interface HandMatcher {
    fun match(cards: List<Card>): Boolean
    val value: HandValue
}

internal class HighCardHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 5 && !sameSuit(cards)
    }

    override val value = HandValue.HIGH_CARD
}

internal class PairHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        return cards.groupBy { it.cardValue }.count() == 4
    }

    override val value = HandValue.PAIR
}

internal class TwoPairsHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupedCards = cards.groupBy { it.cardValue }
        return groupedCards.size == 3 && groupedCards.filter { it.value.size == 2 }.count() == 2
    }

    override val value: HandValue
        get() = HandValue.TWO_PAIRS
}

internal class ThreeHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupedCards = cards.groupBy { it.cardValue }
        return groupedCards.size == 3 && groupedCards.filter { it.value.size == 3 }.count() == 1
    }

    override val value = HandValue.THREE
}

internal class StraightHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupCount = cards.groupBy { it.cardValue }.size
        return groupCount == 5 && !sameSuit(cards) && areConsecutive(cards)
    }

    override val value = HandValue.STRAIGHT
}

internal class FlushHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        return sameSuit(cards) && !areConsecutive(cards)
    }

    override val value = HandValue.FLUSH
}

internal class FullHouseHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupedCards = cards.groupBy { it.cardValue }
        return groupedCards.size == 2 && groupedCards.filter { it.value.size == 3 }.count() == 1
    }

    override val value = HandValue.FULL_HOUSE
}

internal class FourHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupedCards = cards.groupBy { it.cardValue }
        return groupedCards.size == 2 && groupedCards.filter { it.value.size == 4 }.count() == 1
    }

    override val value = HandValue.FOUR
}

internal class StraightFlushHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        val groupCount = cards.groupBy { it.cardValue }.size
        return groupCount == 5 && sameSuit(cards) && areConsecutive(cards)
                && lowerCardValue(cards) != CardValue.TEN.value
    }

    override val value = HandValue.STRAIGHT_FLUSH
}

internal class RoyalFlushHandMatcher : HandMatcher {
    override fun match(cards: List<Card>): Boolean {
        return sameSuit(cards) && areConsecutive(cards) && lowerCardValue(cards) == CardValue.TEN.value
    }

    override val value = HandValue.ROYAL_FLUSH

}

private fun areConsecutive(cards: List<Card>): Boolean {
    val startValue = lowerCardValue(cards)
    return cards.filter { it.cardValue.value in startValue..startValue + 4 }.size == 5
}

private fun sameSuit(cards: List<Card>): Boolean {
    return cards.groupBy { it.suit }.size == 1
}

private fun lowerCardValue(cards: List<Card>): Int {
    return cards.sortedBy { it.cardValue.value }[0].cardValue.value
}


