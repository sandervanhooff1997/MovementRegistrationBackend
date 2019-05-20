package repositories;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class BaseRepo {
    @PersistenceContext(unitName = "MovementPU")
    protected EntityManager em;
}
