package controllers;

import models.Cartracker;
import services.CartrackerService;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("cartracker")
public class CartrackerController {

    @EJB
    CartrackerService cartrackerService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void createCartracker(Cartracker cartracker) {
        cartrackerService.createCartracker(cartracker);
    }
}
