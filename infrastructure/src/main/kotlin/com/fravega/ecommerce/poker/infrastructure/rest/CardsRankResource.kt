package com.fravega.ecommerce.poker.infrastructure.rest

import com.fravega.ecommerce.poker.domain.actions.GetCardsRank
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON_UTF_8)
@Consumes(MediaType.APPLICATION_JSON_UTF_8)
class CardsRankResource(private val getCardsRank: GetCardsRank) {

    @GET
    @Path("/rank")
    fun getRank(): Response {
        return try {
            val responseValue = getCardsRank.doAction().map {
                CardRankResponse(it.key.cardValue.name, it.key.suit.name, it.value)
            }
            Response.ok(responseValue).build()
        } catch (e: Exception) {
            Response.serverError().entity(e.message).build()
        }
    }

    data class CardRankResponse(val card: String, val suit: String, val count: Int)

}