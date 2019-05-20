package services;

import models.Movement;
import repositories.MovementRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Stateless
public class MovementService {

    @EJB
    private MovementRepository movementRepository;

    public void saveMovements(List<Movement> movements) {
        for (Movement m : movements) {
            if (checkAuthcode(m))
                movementRepository.saveMovements(m);
        }

        logMissingSerialnumber(movements);
    }

    public boolean checkAuthcode(Movement m){
        if (m.getAuthCode().equals("SIMULATION"))
            return true;

        System.out.println("checkAuthCode invalid code: " + m.getAuthCode());
        return false;
    }

    public boolean logMissingSerialnumber(List<Movement> movements){
        List<Integer> list = new ArrayList<>();
        for (Movement m : movements){
            list.add(Integer.parseInt(m.getSerialNumber()));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = list.get(0); i < list.get(list.size() - 1); i++) {
            set.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            set.remove(list.get(i));
        }

        for (int x : set) {
            System.out.print(x);

        }

        if (!set.isEmpty()){
            return true;
        }
        return false;
    }

    public List<Movement> getAll() {
        return movementRepository.getAllMovements();
    }

    public List<Movement> getMovementsByCartracker(Long id) {
        return movementRepository.getMovementsByCarTracker(id);
    }

    public List<Movement> getMovementsByPeriod(Date start, Date end) {
        return movementRepository.getMovementsByPeriod(start, end);
    }
}
