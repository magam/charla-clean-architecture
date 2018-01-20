package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.*

internal interface BaseDeckTest {

    fun aHightCard(): List<Card> {
        return listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.TEN, Suit.CLUBS),
                Card(CardValue.EIGHT, Suit.SPADES))
    }

    fun aPairOf(): List<Card> {
        return listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FOUR, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

    fun twoPairs(): List<Card>{
        return listOf(Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    fun aThree(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    fun aStraight(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.EIGHT, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

    fun aFlush(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS))
    }


    fun aFullHouse(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.THREE, Suit.SPADES))
    }

    fun aFourOfAKind(): List<Card> {
        return listOf(Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.SIX, Suit.SPADES))
    }

    fun aStraightFlush(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.EIGHT, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS))
    }

    fun aRoyalFlush(): List<Card> {
        return listOf(Card(CardValue.TEN, Suit.DIAMONDS),
                Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.KING, Suit.DIAMONDS),
                Card(CardValue.ACE, Suit.DIAMONDS))
    }

}