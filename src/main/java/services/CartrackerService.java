package services;

import models.Cartracker;
import repositories.CartrackerRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CartrackerService {

    @EJB
    private CartrackerRepository cartrackerRepository;

    public void createCartracker(Cartracker cartracker) {
        cartrackerRepository.createCartracker(cartracker);
    }
}
