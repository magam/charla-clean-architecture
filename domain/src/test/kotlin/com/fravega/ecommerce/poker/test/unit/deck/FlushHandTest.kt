package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class FlushHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aFlushVsTheSameFlushShouldWin() {
        givenAFlush()
        givenTheSameFlush()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aFlushVsAnotherFlushWithGreaterHighCardShouldLoose() {
        givenAFlush()
        givenAnotherFlushWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }


    @Test
    fun aFlushVsAFullHouseShouldLoose() {
        givenAFlush()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFlushVsAFourOfAKindShouldLoose() {
        givenAFlush()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFlushVsAStraightFlushShouldLoose() {
        givenAFlush()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFlushVsARoyalFlushShouldLoose() {
        givenAFlush()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAFlush() {
        hand1 = handFactory.classify(aFlush())
    }

    private fun givenTheSameFlush() {
        hand2 = handFactory.classify(aFlush())
    }

    private fun givenAnotherFlushWithBetterHighCard() {
        hand2 = handFactory.classify(aFlushWithBetterHighCard())
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

    private fun aFlushWithBetterHighCard(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.ACE, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS))
    }

}
