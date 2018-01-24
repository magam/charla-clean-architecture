package com.fravega.ecommerce.poker.infrastructure.rest

import com.fravega.ecommerce.poker.domain.actions.CalculatePlayerOneVictories
import javax.inject.Inject
import javax.ws.rs.core.Response
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/player1")
@Produces(MediaType.APPLICATION_JSON_UTF_8)
@Consumes(MediaType.APPLICATION_JSON_UTF_8)
internal class PlayerOneVictoriesResource {

    @Inject
    private lateinit var calculatePlayerOneVictories: CalculatePlayerOneVictories

    @GET
    @Path("/wins")
    fun getPlayer1Wins(): Response {
        return try {
            Response.ok(Player1WinsResponse(calculatePlayerOneVictories.doAction())).build()
        } catch (e: Exception) {
            Response.serverError().entity(e.message).build()
        }
    }

    data class Player1WinsResponse(val amount: Int)

}