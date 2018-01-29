package com.fravega.ecommerce.poker.infrastructure.data

import com.fravega.ecommerce.poker.domain.model.*
import com.fravega.ecommerce.poker.infrastructure.data.model.CardEntity
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import javax.persistence.EntityManager


internal class SQLHandRepository(private val entityManager: EntityManager, private val handFactory: HandFactory) : HandRepository {

    private val repo = SimpleJpaRepository<CardEntity, Long>(CardEntity::class.java, entityManager)

    override fun findAll(): List<Pair<Hand, Hand>> {
        return repo.findAll().map {
            handFactory.classify(buildHand(it.card1, it.card2, it.card3, it.card4, it.card5)) to
                    handFactory.classify(buildHand(it.card6, it.card7, it.card8, it.card9, it.card10))
        }
    }

    private fun buildHand(vararg values: String): List<Card> {
        return values.map {
            val card = it[0]
            val suit = it[1]
            Card(CardValue.fromValue(getValueOf(card.toString())), Suit.fromCode(suit.toString()))
        }
    }

    private fun getValueOf(text: String): Int = when (text) {
        "A" -> 14
        "K" -> 13
        "Q" -> 12
        "J" -> 11
        "T" -> 10
        else -> text.toInt()
    }

}