package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class FourOfAKindHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aFourOfAKindVsTheSameFourOfAKindShouldWin() {
        givenAFourOfAKind()
        givenTheSameFourOfAKind()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aFourOfAKindVsAnotherFourOfAKindWithGreaterHighCardShouldLoose() {
        givenAFourOfAKind()
        givenAnotherFourOfAKindWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFourOfAKindVsAStraightFlushShouldLoose() {
        givenAFourOfAKind()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFourOfAKindVsARoyalFlushShouldLoose() {
        givenAFourOfAKind()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }


    private fun givenAFourOfAKind() {
        hand1 = handFactory.classify(aFourOfAKind())
    }

    private fun givenTheSameFourOfAKind() {
        hand2 = handFactory.classify(aFourOfAKind())
    }

    private fun givenAnotherFourOfAKindWithBetterHighCard() {
        hand2 = handFactory.classify(aFourOfAKindWithBetterHighCard())
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

    private fun aFourOfAKindWithBetterHighCard(): List<Card> {
        return listOf(Card(CardValue.JACK, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.HEARTS),
                Card(CardValue.SEVEN, Suit.CLUBS),
                Card(CardValue.SEVEN, Suit.SPADES))
    }

}
