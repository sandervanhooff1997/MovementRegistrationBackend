package repositories;

import models.Cartracker;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class CartrackerRepository extends BaseRepo {

    public void createCartracker(Cartracker cartracker) {
        try {
            em.persist(cartracker);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
