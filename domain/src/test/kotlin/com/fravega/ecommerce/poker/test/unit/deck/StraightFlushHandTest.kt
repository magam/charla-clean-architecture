package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class StraightFlushHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aStraightFlushVsTheSameStraightFlushShouldWin() {
        givenAStraigtFlush()
        givenTheSameStraightFlush()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aStraightFlushVsAnotherStraightFlushWithGreaterHighCardShouldLoose() {
        givenAStraigtFlush()
        givenAnotherStraightFlushWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aStraightFlushVsARoyalFlushShouldLoose() {
        givenAStraigtFlush()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAStraigtFlush() {
        hand1 = handFactory.clasify(aStraightFlush())
    }

    private fun givenTheSameStraightFlush() {
        hand2 = handFactory.clasify(aStraightFlush())
    }

    private fun givenAnotherStraightFlushWithBetterHighCard() {
        hand2 = handFactory.clasify(aStraightFlushWithBetterHighCard())
    }

    private fun givenARoyalFlush() {
        hand2 = handFactory.clasify(aRoyalFlush())
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

    private fun aStraightFlushWithBetterHighCard(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.NINE, Suit.DIAMONDS),
                Card(CardValue.EIGHT, Suit.DIAMONDS),
                Card(CardValue.FIVE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS))
    }

}
