package com.fravega.ecommerce.poker.domain

internal class HandFactory {

    fun clasify(cards: List<Card>): Hand {
        require(cards.size == 5, { "Hand must have 5 cards" })
        require(cards.groupBy { it }.count() == 5, { "Hand can't contain a repeated card" })

        return HAND_MATCHERS.first { it.match(cards) }.build(cards)
    }


    private interface HandMatcher {
        fun match(cards: List<Card>): Boolean
        fun build(cards:List<Card>): Hand
    }

    private class HighCardHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            return cards.groupBy { it.cardValue }.count() == 5 && !sameSuit(cards)
        }

        override fun build(cards: List<Card>) = Hand.HightCard(cards)
    }

    private class PairHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            return cards.groupBy { it.cardValue }.count() == 4
        }

        override fun build(cards: List<Card>) = Hand.Pair(cards)
    }

    private class TwoPairsHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupedCards = cards.groupBy { it.cardValue }
            return groupedCards.size == 3 && groupedCards.filter { it.value.size == 2 }.count() == 2
        }

        override fun build(cards: List<Card>) = Hand.TwoPairs(cards)
    }

    private class ThreeHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupedCards = cards.groupBy { it.cardValue }
            return groupedCards.size == 3 && groupedCards.filter { it.value.size == 3 }.count() == 1
        }

        override fun build(cards: List<Card>) = Hand.Three(cards)
    }

    private class StraightHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupCount = cards.groupBy { it.cardValue }.size
            return groupCount == 5 && !sameSuit(cards) && areConsecutive(cards)
        }

        override fun build(cards: List<Card>) = Hand.Straight(cards)
    }

    private class FlushHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            return sameSuit(cards) && !areConsecutive(cards)
        }

        override fun build(cards: List<Card>) = Hand.Flush(cards)
    }

    private class FullHouseHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupedCards = cards.groupBy { it.cardValue }
            return groupedCards.size == 2 && groupedCards.filter { it.value.size == 3 }.count() == 1
        }

        override fun build(cards: List<Card>) = Hand.FullHouse(cards)
    }

    private class FourHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupedCards = cards.groupBy { it.cardValue }
            return groupedCards.size == 2 && groupedCards.filter { it.value.size == 4 }.count() == 1
        }

        override fun build(cards: List<Card>) = Hand.FourOfAKind(cards)
    }

    private class StraightFlushHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            val groupCount = cards.groupBy { it.cardValue }.size
            return groupCount == 5 && sameSuit(cards) && areConsecutive(cards)
                    && lowerCardValue(cards) != CardValue.TEN.points
        }

        override fun build(cards: List<Card>) = Hand.StraightFlush(cards)
    }

    private class RoyalFlushHandMatcher : HandMatcher {
        override fun match(cards: List<Card>): Boolean {
            return sameSuit(cards) && areConsecutive(cards) && lowerCardValue(cards) == CardValue.TEN.points
        }

        override fun build(cards: List<Card>) = Hand.RoyalFlush(cards)

    }

    companion object {
        private fun areConsecutive(cards: List<Card>): Boolean {
            val startValue = lowerCardValue(cards)
            return cards.filter { it.cardValue.points in startValue..startValue + 4 }.size == 5
        }

        private fun sameSuit(cards: List<Card>): Boolean {
            return cards.groupBy { it.suit }.size == 1
        }

        private fun lowerCardValue(cards: List<Card>): Int {
            return cards.sortedBy { it.cardValue.points }[0].cardValue.points
        }

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