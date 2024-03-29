package com.fravega.ecommerce.poker.test.unit.deck

import com.fravega.ecommerce.poker.domain.model.*
import org.assertj.core.api.Assertions
import org.junit.Test

class HighCardTest : BaseDeckTest{

    private lateinit var hand1: Hand
    private lateinit var hand2: Hand
    private lateinit var winner: Player
    private val handFactory = HandFactory()
    private val deck = Deck()

    @Test
    fun aHighCardVsTheSameHighCardShouldWin(){
        givenAHighCard()
        givenTheSameHighCard()

        whenDeckChooseAWinner()

        thenP1IsTheWinner()
    }
    @Test
    fun aHighCardVsAGreaterHighCardShouldLoose(){
        givenAHighCard()
        givenAGreaterHighCard()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAPairsShouldLoose(){
        givenAHighCard()
        givenAPair()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsTwoPairsShouldLoose(){
        givenAHighCard()
        givenTwoPairs()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAThreeShouldLoose(){
        givenAHighCard()
        givenAThreeOfSix()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAStraightShouldLoose(){
        givenAHighCard()
        givenAStraightStartingAtFour()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAFlushShouldLoose(){
        givenAHighCard()
        givenAFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAFullHouseShouldLoose(){
        givenAHighCard()
        givenAFullHouse()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAFourOfAKindShouldLoose(){
        givenAHighCard()
        givenAFourOfAKind()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsAStraightFlushShouldLoose(){
        givenAHighCard()
        givenAStraigtFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    @Test
    fun aHighCardVsARoyalFlushShouldLoose(){
        givenAHighCard()
        givenARoyalFlush()

        whenDeckChooseAWinner()

        thenP2IsTheWinner()
    }

    private fun givenAHighCard() {
        hand1 = handFactory.classify(aHightCard())
    }

    private fun givenTheSameHighCard() {
        hand2 = handFactory.classify(aHightCard())
    }

    private fun givenAGreaterHighCard() {
        hand2 = handFactory.classify(aGreaterHightCard())
    }


    private fun givenAPair() {
        hand2 = handFactory.classify(aPairOf())
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
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_1)
    }

    private fun thenP2IsTheWinner() {
        Assertions.assertThat(winner).isEqualTo(Player.PLAYER_2)
    }

    private fun aGreaterHightCard(): List<Card> {
        return listOf(Card(CardValue.THREE, Suit.DIAMONDS),
                Card(CardValue.SEVEN, Suit.DIAMONDS),
                Card(CardValue.FOUR, Suit.HEARTS),
                Card(CardValue.TEN, Suit.CLUBS),
                Card(CardValue.EIGHT, Suit.SPADES))
    }

}
