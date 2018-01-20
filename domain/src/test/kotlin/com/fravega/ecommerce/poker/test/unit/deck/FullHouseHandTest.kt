package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class FullHouseHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aFullHouseVsTheSameFullHouseShouldWin() {
        givenAFullHouse()
        givenTheSameFullHouse()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aFullHouseVsAnotherFullHouseWithGreaterHighCardShouldLoose() {
        givenAFullHouse()
        givenAnotherFullHouseWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFullHouseVsAFourOfAKindShouldLoose() {
        givenAFullHouse()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }


    @Test
    fun aFullHouseVsAStraightFlushShouldLoose() {
        givenAFullHouse()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aFullHouseVsARoyalFlushShouldLoose() {
        givenAFullHouse()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAFullHouse() {
        hand1 = handFactory.clasify(aFullHouse())
    }

    private fun givenTheSameFullHouse() {
        hand2 = handFactory.clasify(aFullHouse())
    }

    private fun givenAnotherFullHouseWithBetterHighCard() {
        hand2 = handFactory.clasify(aFullHouseWithBetterHighCard())
    }

    private fun givenAFourOfAKind() {
        hand2 = handFactory.clasify(aFourOfAKind())
    }

    private fun givenAStraigtFlush() {
        hand2 = handFactory.clasify(aStraightFlush())
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

    private fun aFullHouseWithBetterHighCard(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.FOUR, Suit.SPADES))
    }

}
