package controllers;

import models.Movement;
import services.MovementService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("movement")
public class MovementController {

    @EJB
    MovementService movementService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void saveMovements(List<Movement> movements) {
        movementService.saveMovements(movements);
    }

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    public Response getById(@PathParam("id") Long id){
        List<Movement> movements = movementService.getMovementsByCartracker(id);
        return Response.ok(movements).build();
    }

    @GET
    @Path("/month/{monthIndex}")
    @Consumes("application/json")
    public Response getByMonth(@PathParam("monthIndex") Long monthIndex){
        List<Movement> movements = movementService.getMovementsByMonth(monthIndex);
        return Response.ok(movements).build();
    }

    @GET
    @Path("/month/{monthIndex}/cartracker")
    @Consumes("application/json")
    public Response getMovementsByCartrackerAndMonth(@PathParam("monthIndex") Long monthIndex, @QueryParam("id") List<Long> ids){
        List<Movement> movements = movementService.getMovementsByCartrackerAndMonth(monthIndex, ids);
        return Response.ok(movements).build();
    }


    @GET
    @Path("/test")
    @Consumes("application/json")
    public Response getTest(){
        return Response.ok("Hello MonthSplit").build();
    }

    @GET
    @Path("/{start}/{end}")
    @Consumes("application/json")
    public Response getByPeriod(@PathParam("start") String start, @PathParam("end") String end){
        Date begin = refactorDate(start);
        Date stop = refactorDate(end);
        List<Movement> movements = null;

        if (begin != null && stop != null)
            movements = movementService.getMovementsByPeriod(begin, stop);

        return Response.ok(movements).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAll() {
        System.out.println("GET ALL");
        List<Movement> movements = movementService.getAll();
        return Response.ok(movements).build();
//
//        CarTracker ct = new CarTracker();
//        ct.setId(0L);
//
//        for (int i =0;i < 3; i++) {
//
//
//            Movement m = new Movement();
//            m.setAddress("test address");
//            m.setAuthCode("test authcode");
//            m.setCarTracker(ct);
//            m.setDate(new Date());
//            m.setSerialNumber(String.valueOf(i));
//            m.setCoordinate(new Point2D.Double(11.698492, 51.929851));
//            movements.add(m);
//
//        }
    }

    public Date refactorDate(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = sdf.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
