package services;

import models.CarTracker;
import repositories.CartrackerRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CartrackerService {

    @EJB
    private CartrackerRepository cartrackerRepository;

    public void createCartracker(CarTracker cartracker) {
        cartrackerRepository.createCartracker(cartracker);
    }
}
