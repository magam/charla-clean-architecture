package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PairHandTest : BaseDeckTest{

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aPairVsTheSamePairShouldWin() {
        givenAPair()
        givenAnotherPair()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }

    @Test
    fun aPairVsTheSamePairWithABetterCardShouldLoose(){
        givenAPair()
        givenAPairWithABetterCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsTwoPairsShouldLoose(){
        givenAPair()
        givenTwoPairs()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAThreeShouldLoose(){
        givenAPair()
        givenAThreeOfSix()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAStraightShouldLoose(){
        givenAPair()
        givenAStraightStartingAtFour()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAFlushShouldLoose(){
        givenAPair()
        givenAFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAFullHouseShouldLoose(){
        givenAPair()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAFourOfAKindShouldLoose(){
        givenAPair()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsAStraightFlushShouldLoose(){
        givenAPair()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aPairVsARoyalFlushShouldLoose(){
        givenAPair()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAPair() {
        hand1 = handFactory.classify(aPairOf())
    }

    private fun givenAnotherPair() {
        hand2 = handFactory.classify(aPairOf())
    }

    private fun givenAPairWithABetterCard(){
        hand2 = handFactory.classify(aPairOfFourWithAnACe())
    }

    private fun givenTwoPairs() {
        hand2 = handFactory.classify(twoPairs())
    }

    private fun givenAThreeOfSix(){
        hand2 = handFactory.classify(aThree())
    }

    private fun givenAStraightStartingAtFour(){
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

    fun aPairOfFourWithAnACe(): List<Card>{
        return listOf(Card(CardValue.TWO, Suit.DIAMONDS),
                Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.FOUR, Suit.CLUBS),
                Card(CardValue.ACE, Suit.SPADES))
    }

}
