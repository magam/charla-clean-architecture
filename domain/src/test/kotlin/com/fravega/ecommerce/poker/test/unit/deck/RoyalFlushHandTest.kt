package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.*
import org.assertj.core.api.Assertions
import org.junit.Test

internal class RoyalFlushHandTest : BaseDeckTest {

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aRoyalFlushVsAnotherRoyalFlushShouldWin() {
        givenARoyalFlush()
        givenAnotherRoyalFlush()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    private fun givenARoyalFlush() {
        hand1 = handFactory.clasify(aRoyalFlush())
    }

    private fun givenAnotherRoyalFlush() {
        hand2 = handFactory.clasify(aRoyalFlush())
    }

    private fun whenDeckChooseAWinner() {
        winner = deck.chooseAWinner(hand1 to hand2)
    }

    private fun thenP1IsTheWinner() {
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_1)
    }

}