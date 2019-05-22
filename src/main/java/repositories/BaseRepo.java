package repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseRepo {
    @PersistenceContext(unitName = "MovementPU")
    protected EntityManager em;
}
