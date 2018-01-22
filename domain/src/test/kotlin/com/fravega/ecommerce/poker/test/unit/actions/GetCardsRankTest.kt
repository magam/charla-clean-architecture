package com.fravega.ecommerce.poker.test.unit.actions

import com.fravega.ecommerce.poker.domain.actions.GetCardsRank
import com.fravega.ecommerce.poker.domain.model.Card
import com.fravega.ecommerce.poker.domain.model.CardValue
import com.fravega.ecommerce.poker.domain.model.HandRepository
import com.fravega.ecommerce.poker.domain.model.Suit
import com.fravega.ecommerce.poker.test.doubles.InMemoryHandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class GetCardsRankTest {

    private lateinit var aHandRepository: HandRepository
    private lateinit var aGetRankAction: GetCardsRank
    private lateinit var aRankMap: Map<Card, Int>


    @Test
    fun aThreeOfDiamondsShouldCountSixteenTimes() {
        givenAHandRepository()
        givenAConfiguredAction()

        whenRankIsCalculed()

        thenThreeOfDiamondsAppearsSixteenTimes()
    }

    @Test
    fun aSixOfClubsShouldCountEightTimes() {
        givenAHandRepository()
        givenAConfiguredAction()

        whenRankIsCalculed()

        thenSixOfClubsAppearsEightTimes()
    }

    private fun givenAHandRepository() {
        aHandRepository = InMemoryHandRepository()
    }

    private fun givenAConfiguredAction() {
        aGetRankAction = GetCardsRank(aHandRepository)
    }

    private fun whenRankIsCalculed() {
        aRankMap = aGetRankAction.doAction()
    }

    private fun thenThreeOfDiamondsAppearsSixteenTimes() {
        assertThat(aRankMap.get(Card(CardValue.THREE, Suit.DIAMONDS))).isEqualTo(16)
    }

    private fun thenSixOfClubsAppearsEightTimes() {
        assertThat(aRankMap.get(Card(CardValue.SIX, Suit.CLUBS))).isEqualTo(8)
    }

}
