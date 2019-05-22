//package repositories;
//
//import models.CarTracker;
//
//import javax.ejb.Stateless;
//import java.util.List;
//
//@Stateless
//public class CartrackerRepository extends BaseRepo {
//
//    public void createCartracker(CarTracker cartracker) {
//        try {
//            em.persist(cartracker);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public List<CarTracker> getAll() {
//        List<CarTracker> carTrackers;
//        try {
//            System.out.println("GETTING Cartrackers");
//            carTrackers = em.createQuery(
//                    "SELECT c FROM CarTracker c", CarTracker.class).getResultList();
//            System.out.println(carTrackers.size());
//            return carTrackers;
//        } catch (Exception ex){
//            ex.printStackTrace();
//            System.out.println("CATCH exception");
//            return null;
//        }
//    }
//}
