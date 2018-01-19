package com.fravega.ecommerce.poker.test.unit.hands

import com.fravega.ecommerce.poker.domain.hands.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class HandValueTest {

    private lateinit var hand: Hand
    private lateinit var handValue: HandValue

    @Test
    fun aHightestCardShouldBeResolved(){
        givenAHandWithHightestCard()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.HIGH_CARD)
    }

    @Test
    fun aPairShouldBeResolved() {
        givenAHandWithAPair()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.PAIR)
    }

    @Test
    fun aTwoPairsHandShouldBeResolved(){
        givenAHandWithTwoPairs()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.TWO_PAIRS)
    }

    @Test
    fun AThreeShoulBeReolved(){
        givenAHandWithAThree()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.THREE)
    }

    @Test
    fun aStraightShouldBeResolved(){
        givenAHandWithAStraight()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.STRAIGHT)
    }

    @Test
    fun aFlushShouldBeResolved(){
        givenAHandWithAFlush()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.FLUSH)
    }

    @Test
    fun aFullHouseShouldBeResolved(){
        givenAHandWithAFullHouse()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.FULL_HOUSE)
    }

    @Test
    fun aFourShouldBeResolved(){
        givenAHandWithAFour()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.FOUR)
    }

    @Test
    fun aStraightFlushShouldBeResolved(){
        givenAHandWithAStraightFlush()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.STRAIGHT_FLUSH)
    }

    @Test
    fun aRoyalFlushShouldBeResolved(){
        givenAHandWithARoyalFlush()

        whenResolveHandValue()

        thenCorrectValueWasResolved(HandValue.ROYAL_FLUSH)
    }

    private fun givenAHandWithHightestCard() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))))
    }

    private fun givenAHandWithAPair() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))))
    }

    private fun givenAHandWithTwoPairs() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))))
    }

    private fun givenAHandWithAThree() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))))
    }

    private fun givenAHandWithAStraight() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SIX, Suit.SPADES))))
    }

    private fun givenAHandWithAFlush() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS))))
    }

    private fun givenAHandWithAFullHouse() {
        hand = Hand(CardList(listOf(Card(CardValue.THREE, Suit.CLUBS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))))
    }

    private fun givenAHandWithAFour() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.SPADES),
                Card(CardValue.TWO, Suit.HEARTS),
                Card(CardValue.TWO, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))))
    }

    private fun givenAHandWithAStraightFlush() {
        hand = Hand(CardList(listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.DIAMONDS))))
    }

    private fun givenAHandWithARoyalFlush() {
        hand = Hand(CardList(listOf(Card(CardValue.ACE, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.KING, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS))))
    }

    private fun whenResolveHandValue() {
        handValue = hand.value
    }

    private fun thenCorrectValueWasResolved(value: HandValue) {
        assertThat(handValue).isEqualTo(value)
    }

}


