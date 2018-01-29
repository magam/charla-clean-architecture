package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.Deck
import com.fravega.ecommerce.poker.domain.model.Hand
import com.fravega.ecommerce.poker.domain.model.HandFactory
import com.fravega.ecommerce.poker.domain.model.Player
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
        hand1 = handFactory.classify(aRoyalFlush())
    }

    private fun givenAnotherRoyalFlush() {
        hand2 = handFactory.classify(aRoyalFlush())
    }

    private fun whenDeckChooseAWinner() {
        winner = deck.chooseAWinner(hand1 to hand2)
    }

    private fun thenP1IsTheWinner() {
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_1)
    }

}
