package repositories;

import models.CarTracker;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class CartrackerRepository extends BaseRepo {

    public void createCartracker(CarTracker cartracker) {
        try {
            em.persist(cartracker);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
