package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class StraightHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aStraightVsTheSameStraightShouldWin() {
        givenAStraight()
        givenTheSameStraight()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aStraightVsTheAnotherStraightWithGreaterHighCardShouldLoose() {
        givenAStraight()
        givenAnotherStraightWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraightVsAFlushShouldLoose() {
        givenAStraight()
        givenAFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraighVsAFullHouseShouldLoose() {
        givenAStraight()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraighVsAFourOfAKindShouldLoose() {
        givenAStraight()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraighVsAStraightFlushShouldLoose() {
        givenAStraight()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraighVsARoyalFlushShouldLoose() {
        givenAStraight()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAStraight() {
        hand1 = handFactory.classify(aStraight())
    }

    private fun givenTheSameStraight() {
        hand2 = handFactory.classify(aStraight())
    }

    private fun givenAnotherStraightWithBetterHighCard() {
        hand2 = handFactory.classify(aStraightWithBatterHighCard())
    }

    private fun givenAFlush() {
        hand2 = handFactory.classify(aFlush())
    }

    private fun givenAFullHouse() {
        hand2 = handFactory.classify(aFullHouse())
    }

    private fun givenAFourOfAKind() {
        hand2 = handFactory.classify(aFourOfAKind())
    }

    private fun givenAStraigtFlush() {
        hand2 = handFactory.classify(aStraightFlush())
    }

    private fun givenARoyalFlush() {
        hand2 = handFactory.classify(aRoyalFlush())
    }

    private fun whenDeckChooseAWinner() {
        winner = deck.chooseAWinner(hand1 to hand2)
    }

    private fun thenP1IsTheWinner() {
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_1)
    }

    private fun thenP2IsTheWinner() {
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_2)
    }

    private fun aStraightWithBatterHighCard(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.NINE, Suit.DIAMONDS),
                Card(CardValue.EIGHT, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

}
