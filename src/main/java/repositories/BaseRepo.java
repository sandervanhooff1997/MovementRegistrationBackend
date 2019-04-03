package repositories;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Local
@Stateless
public class BaseRepo {

    @PersistenceContext(unitName = "MovementPU")
    protected EntityManager em;

    protected Logger logger = Logger.getLogger(this.getClass().getName());
}
