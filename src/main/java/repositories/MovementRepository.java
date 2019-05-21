package repositories;

import models.Movement;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class MovementRepository extends BaseRepo {

    public void saveMovements(Movement m) {
        try {
            em.persist(m);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Movement> getAllMovements () {
        List<Movement> movements;
        try {
             movements = em.createQuery(
                    "SELECT m FROM Movement m", Movement.class).getResultList();
            return movements;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }



    public List<Movement> getMovementsByCarTracker (Long id) {
        List<Movement> movements;
        try {
            movements = em.createQuery(
                    "select m from Movement m " +
                            "inner join m.carTracker cartracker " +
                            "where cartracker.id in :id")
                    .setParameter("id", id)
                    .getResultList();
            return movements;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Movement> getMovementsByPeriod (Date start, Date stop) {
        List<Movement> movements;
        try {
            movements = em.createQuery(
                    "select m from Movement m " +
                            "where m.date between :start and :stop")
                    .setParameter("start", start)
                    .setParameter("stop", stop)
                    .getResultList();
            return movements;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
