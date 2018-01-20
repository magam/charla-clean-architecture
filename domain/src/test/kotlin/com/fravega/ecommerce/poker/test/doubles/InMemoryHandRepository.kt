package com.fravega.ecommerce.poker.test.doubles

import com.fravega.ecommerce.poker.domain.model.*

internal class InMemoryHandRepository : HandRepository {

    private val handFactory = HandFactory()

    override fun findAll(): List<Pair<Hand, Hand>> {
        return listOf(
                aPairOfHandsWinningPlayer1(),
                aPairOfHandsWinningPlayer2(),
                aPairOfHandsWinningPlayer2(),
                aPairOfHandsWinningPlayer1(),
                aPairOfHandsWinningPlayer1(),
                aPairOfHandsWinningPlayer2(),
                aPairOfHandsWinningPlayer2(),
                aPairOfHandsWinningPlayer2()
        )
    }

    private fun aPairOfHandsWinningPlayer1(): Pair<Hand, Hand> {
        return handFactory.clasify(aFlush()) to handFactory.clasify(aThree())
    }

    private fun aPairOfHandsWinningPlayer2(): Pair<Hand, Hand> {
        return handFactory.clasify(aThree()) to handFactory.clasify(aFlush())
    }


    private fun aFlush(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.QUEEN, Suit.DIAMONDS),
                Card(CardValue.TEN, Suit.DIAMONDS),
                Card(CardValue.TWO, Suit.DIAMONDS))
    }

    private fun aThree(): List<Card> {
        return listOf(Card(CardValue.SIX, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.SIX, Suit.HEARTS),
                Card(CardValue.SIX, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }
}