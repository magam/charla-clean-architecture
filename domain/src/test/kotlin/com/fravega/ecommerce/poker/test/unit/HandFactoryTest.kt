package com.fravega.ecommerce.poker.test.unit

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class HandFactoryTest {

    private lateinit var hand: Hand
    private lateinit var cardList: List<Card>
    private val handFactory = HandFactory()

    @Test
    fun aHightestCardShouldBeResolved() {
        givenAListWithHightestCard()

        whenResolveHandValue()

        thenAHightCardWasResolved()
    }

    @Test
    fun aPairShouldBeResolved() {
        givenAHandWithAPair()

        whenResolveHandValue()

        thenAPairWasResolved()
    }

    @Test
    fun aTwoPairsHandShouldBeResolved() {
        givenAHandWithTwoPairs()

        whenResolveHandValue()

        thenTwoPairsWasResolved()
    }

    @Test
    fun aThreeShouldBeResolved() {
        givenAHandWithAThree()

        whenResolveHandValue()

        thenAThreeWasResolved()
    }

    @Test
    fun aStraightShouldBeResolved() {
        givenAHandWithAStraight()

        whenResolveHandValue()

        thenAStraightWasResolved()
    }

    @Test
    fun aFlushShouldBeResolved() {
        givenAHandWithAFlush()

        whenResolveHandValue()

        thenAFlushWasResolved()
    }

    @Test
    fun aFullHouseShouldBeResolved() {
        givenAHandWithAFullHouse()

        whenResolveHandValue()

        thenAFullHouseWasResolved()
    }

    @Test
    fun aFourOfAKindShouldBeResolved() {
        givenAHandWithAFourOfAKind()

        whenResolveHandValue()

        thenAFourOfKindWasResolved()
    }

    @Test
    fun aStraightFlushShouldBeResolved() {
        givenAHandWithAStraightFlush()

        whenResolveHandValue()

        thenAStraightFlushWasResolved()
    }

    @Test
    fun aRoyalFlushShouldBeResolved() {
        givenAHandWithARoyalFlush()

        whenResolveHandValue()

        thenARoyalFlushWasResolved()
    }

    private fun givenAListWithHightestCard() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

    private fun givenAHandWithAPair() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    private fun givenAHandWithTwoPairs() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    private fun givenAHandWithAThree() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    private fun givenAHandWithAStraight() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SIX, Suit.SPADES))
    }

    private fun givenAHandWithAFlush() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS))
    }

    private fun givenAHandWithAFullHouse() {
        cardList = listOf(Card(CardValue.THREE, Suit.CLUBS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

    private fun givenAHandWithAFourOfAKind() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.TWO, Suit.HEARTS),
                Card(CardValue.TWO, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

    private fun givenAHandWithAStraightFlush() {
        cardList = listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.DIAMONDS))
    }

    private fun givenAHandWithARoyalFlush() {
        cardList = listOf(Card(CardValue.ACE, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.KING, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS))
    }

    private fun whenResolveHandValue() {
        hand = handFactory.clasify(cardList)
    }

    private fun thenAHightCardWasResolved() {
        assertThat(hand).isInstanceOf(Hand.HightCard::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.SEVEN, Suit.SPADES),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS)
        )
    }

    private fun thenAPairWasResolved() {
        assertThat(hand).isInstanceOf(Hand.Pair::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS))
    }

    private fun thenTwoPairsWasResolved() {
        assertThat(hand).isInstanceOf(Hand.TwoPairs::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES),
                Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.FOUR, Suit.HEARTS)
        )
    }

    private fun thenAThreeWasResolved() {
        assertThat(hand).isInstanceOf(Hand.Three::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS)
        )
    }

    private fun thenAStraightWasResolved() {
        assertThat(hand).isInstanceOf(Hand.Straight::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.SIX, Suit.SPADES),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS)
        )
    }

    private fun thenAFlushWasResolved() {
        assertThat(hand).isInstanceOf(Hand.Flush::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS)
        )
    }

    private fun thenAFullHouseWasResolved() {
        assertThat(hand).isInstanceOf(Hand.FullHouse::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES),
                Card(CardValue.THREE, Suit.CLUBS),
                Card(CardValue.THREE, Suit.DIAMONDS)
        )
    }

    private fun thenAFourOfKindWasResolved() {
        assertThat(hand).isInstanceOf(Hand.FourOfAKind::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.TWO, Suit.HEARTS),
                Card(CardValue.TWO, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES)
        )
    }

    private fun thenAStraightFlushWasResolved() {
        assertThat(hand).isInstanceOf(Hand.StraightFlush::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS)
        )
    }

    private fun thenARoyalFlushWasResolved() {
        assertThat(hand).isInstanceOf(Hand.RoyalFlush::class.java)
        assertThat(hand.cards).hasSize(5)
        assertThat(hand.sortedCards).hasSize(5)
        assertThat(hand.sortedCards).containsExactly(
                Card(CardValue.ACE, Suit.DIAMONDS),
                Card(CardValue.KING, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS)
        )
    }
}


