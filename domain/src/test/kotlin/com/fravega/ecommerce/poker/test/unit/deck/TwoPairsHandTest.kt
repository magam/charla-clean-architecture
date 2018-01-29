package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TwoPairsHandTest : BaseDeckTest{

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun twoPairVsTheSameTwoPairsShouldWin() {
        givenTwoPairs()
        givenAnotherTwoPairs()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun twoPairVsTheSameTwoPairsWithABetterCardShouldLoose(){
        givenTwoPairs()
        givenTwoPairsWithBetterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAThreeShouldLoose(){
        givenTwoPairs()
        givenAThree()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAStraightShouldLoose(){
        givenTwoPairs()
        givenAStraight()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAFlushShouldLoose(){
        givenTwoPairs()
        givenAFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAFullHouseShouldLoose(){
        givenTwoPairs()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAFourOfAKindShouldLoose(){
        givenTwoPairs()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsAStraightFlushShouldLoose(){
        givenTwoPairs()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun twoPairsVsARoyalFlushShouldLoose(){
        givenTwoPairs()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenTwoPairs() {
        hand1 = handFactory.classify(twoPairs())
    }

    private fun givenAnotherTwoPairs() {
        hand2 = handFactory.classify(twoPairs())
    }

    private fun givenTwoPairsWithBetterHighCard() {
        hand2 = handFactory.classify(twoPairsWithBatterHighCard())
    }

    private fun givenAThree(){
        hand2 = handFactory.classify(aThree())
    }

    private fun givenAStraight(){
        hand2 = handFactory.classify(aStraight())
    }

    private fun givenAFlush(){
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
        assertThat(winner).isEqualTo(Player.PLAYER_1)
    }

    private fun thenP2IsTheWinner() {
        assertThat(winner).isEqualTo(Player.PLAYER_2)
    }

    private fun twoPairsWithBatterHighCard(): List<Card> {
        return listOf(Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.HEARTS),
                Card(CardValue.FIVE, Suit.CLUBS),
                Card(CardValue.FIVE, Suit.SPADES))
    }

}
