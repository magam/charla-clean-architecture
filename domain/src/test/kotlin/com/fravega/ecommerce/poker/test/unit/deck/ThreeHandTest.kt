package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class ThreeHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aThreeVsTheSameThreeShouldWin() {
        givenAThree()
        givenTheSameThree()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aThreeVsTheSameThreeWithGreaterHighCardShouldLoose() {
        givenAThree()
        givenATheSameThreeWithGreaterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsAStraightShouldLoose() {
        givenAThree()
        givenAStraight()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsAFlushShouldLoose() {
        givenAThree()
        givenAFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsAFullHouseShouldLoose() {
        givenAThree()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsAFourOfAKindShouldLoose() {
        givenAThree()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsAStraightFlushShouldLoose() {
        givenAThree()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aThreeVsARoyalFlushShouldLoose() {
        givenAThree()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAThree() {
        hand1 = handFactory.classify(aThree())
    }

    private fun givenTheSameThree() {
        hand2 = handFactory.classify(aThree())
    }

    private fun givenATheSameThreeWithGreaterHighCard() {
        hand2 = handFactory.classify(aThreeWithGreaterHighCard())
    }

    private fun givenAStraight() {
        hand2 = handFactory.classify(aStraight())
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

    private fun aThreeWithGreaterHighCard(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

}