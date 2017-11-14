package pl.gda.pg.eti.kask.javaee.enterprise;

import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Stateless
public class WizardService implements Serializable {

    @PersistenceContext
    EntityManager em;

    public List<Wizard> findAllWizards() {
        return em.createNamedQuery(Wizard.Queries.FIND_ALL, Wizard.class).getResultList();
    }

    public Wizard findWizard(int id) {
        return em.find(Wizard.class, id);
    }

    public void removeWizard(Wizard wizard) {
        em.remove(em.merge(wizard));
    }

    public void removeTower(Tower tower) {
        em.remove(em.merge(tower));
    }

    public void saveWizard(Wizard wizard) {
        if (wizard.getId() == null) {
            em.persist(wizard);
        } else {
            em.merge(wizard);
        }
    }

    public void saveTower(Tower tower) {
        if (tower.getId() == null) {
            em.persist(tower);
        } else {
            em.merge(tower);
        }
    }

    public List<Tower> findAllTowers() {
        return em.createNamedQuery(Tower.Queries.FIND_ALL, Tower.class).getResultList();
    }

    public Tower findTower(int id) {
        return em.find(Tower.class, id);
    }
}
