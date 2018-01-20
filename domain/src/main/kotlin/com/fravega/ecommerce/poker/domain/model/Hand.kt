package com.fravega.ecommerce.poker.domain.model

sealed class Hand {
    data class HightCard (override val cards: List<Card>) : Hand() {
        override val points = 20

        override val sortedCards: List<Card> by lazy {
            cards.sortedByDescending { it.cardValue.points }
        }
    }

    data class Pair(override val cards: List<Card>) : Hand() {
        override val points = 21

        override val sortedCards: List<Card> by lazy {
            val pair = cards.groupBy { it.cardValue.points }.filter { it.value.size == 2 }.values.flatten()
            pair.plus(cards.filterNot { pair.contains(it) }.sortedByDescending { it.cardValue.points })
        }
    }

    data class TwoPairs(override val cards: List<Card>) : Hand() {
        override val points = 22

        override val sortedCards: List<Card> by lazy {
            val pair = cards.groupBy { it.cardValue.points }.filter { it.value.size == 2 }.values.flatten()
                    .sortedByDescending { it.cardValue.points }
            pair.plus(cards.filterNot { pair.contains(it) })
        }
    }

    data class Three(override val cards: List<Card>) : Hand() {
        override val points = 23

        override val sortedCards: List<Card> by lazy {
            val three = cards.groupBy { it.cardValue.points }.filter { it.value.size == 3 }.values.flatten()
            three.plus(cards.filterNot { three.contains(it) }.sortedByDescending { it.cardValue.points })
        }
    }

    data class Straight(override val cards: List<Card>) : Hand() {
        override val points = 24

        override val sortedCards: List<Card> by lazy {
            cards.sortedByDescending { it.cardValue.points }
        }
    }

    data class Flush(override val cards: List<Card>) : Hand() {
        override val points = 25

        override val sortedCards: List<Card> by lazy {
            cards.sortedByDescending { it.cardValue.points }
        }
    }

    data class FullHouse(override val cards: List<Card>) : Hand() {
        override val points = 26

        override val sortedCards: List<Card> by lazy {
            val three = cards.groupBy { it.cardValue.points }.filter { it.value.size == 3 }.values.flatten()
            three.plus(cards.filterNot { three.contains(it) })
        }
    }

    data class FourOfAKind(override val cards: List<Card>) : Hand() {
        override val points = 27

        override val sortedCards: List<Card> by lazy {
            val four = cards.groupBy { it.cardValue.points }.filter { it.value.size == 4 }.values.flatten()
            four.plus(cards.filterNot { four.contains(it) })
        }
    }

    data class StraightFlush(override val cards: List<Card>) : Hand() {
        override val points = 28

        override val sortedCards: List<Card> by lazy {
            cards.sortedByDescending { it.cardValue.points }
        }
    }

    data class RoyalFlush(override val cards: List<Card>) : Hand() {
        override val points = 29

        override val sortedCards: List<Card> by lazy {
            cards.sortedByDescending { it.cardValue.points }
        }
    }


    abstract val points: Int
    abstract val cards: List<Card>
    abstract val sortedCards: List<Card>
}


