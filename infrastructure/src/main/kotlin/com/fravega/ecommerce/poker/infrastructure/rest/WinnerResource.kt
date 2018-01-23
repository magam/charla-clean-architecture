package com.fravega.ecommerce.poker.infrastructure.rest

import com.fravega.ecommerce.poker.domain.actions.CalculateWinner
import com.fravega.ecommerce.poker.domain.model.Player
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/players")
@Produces(MediaType.APPLICATION_JSON_UTF_8)
@Consumes(MediaType.APPLICATION_JSON_UTF_8)
internal class WinnerResource {

    @Inject
    private lateinit var calculateWinner: CalculateWinner

    @Path("/winner")
    @GET
    fun getTheWinner(): Response {
        return try {
            Response.ok(WinnerResponse(calculateWinner.doAction())).build()
        } catch (e: Exception) {
            Response.serverError().entity(e.message).build()
        }
    }

    data class WinnerResponse(val winner: Player)
}