package com.fravega.ecommerce.poker.infrastructure.data

import com.fravega.ecommerce.poker.domain.model.*
import java.io.File

class FileHandRepository(path: String, private val handFactory: HandFactory) : HandRepository {

    private val lines: List<String> = File(path).readLines()

    override fun findAll(): List<Pair<Hand, Hand>> {
        return lines.filter { it.isNotBlank() }.map { buildHands(it) }
    }

    private fun buildHands(line: String): Pair<Hand, Hand> {
        return handFactory.clasify(buildHand(line, 0..5)) to
                handFactory.clasify(buildHand(line, 5..10))
    }

    private fun buildHand(line: String, intRange: IntRange): List<Card> {
        return line.split(" ").subList(intRange.first, intRange.last).map {
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