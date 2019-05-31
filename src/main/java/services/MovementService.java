package services;

import models.Movement;
import repositories.MovementRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

@Stateless
public class MovementService {

    @EJB
    private MovementRepository movementRepository;

    public void saveMovements(List<Movement> movements) {
        for (Movement m : movements) {
            logMovement(m);
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

        list.sort(Comparator.naturalOrder());

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

    public void logMovement(Movement m){
        try{
            // Create file
            FileWriter fstream = new FileWriter("D:\\log.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.newLine();
            out.write(new Date() + " " + m.toString() +"\n");
            //Close the output stream
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<Movement> getMovementsByMonth(Long monthIndex) {
        return sortByMonth(monthIndex, getAll());
    }

    public List<Movement> sortByMonth(Long monthIndex, List<Movement> movements){
        List<Movement> movementsByMonth = new ArrayList<>();
        for (Movement m : movements){
            System.out.println(m.getDate().getMonth());
            if (m.getDate().getMonth() == monthIndex){
                movementsByMonth.add(m);
            }
        }
        return movementsByMonth;
    }

    public List<Movement> getMovementsByCartrackerAndMonth(Long monthIndex, List<Long> ids) {
        List<Movement> movements = sortByMonth(monthIndex, movementRepository.getMovementsByCarTrackers(ids));

        return movements;

    }
}
