package pl.gda.pg.eti.kask.javaee.enterprise;

import lombok.extern.java.Log;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.util.Arrays.asList;
import static pl.gda.pg.eti.kask.javaee.enterprise.entities.MagicElement.FIRE;
import static pl.gda.pg.eti.kask.javaee.enterprise.entities.MagicElement.WATER;
import static pl.gda.pg.eti.kask.javaee.enterprise.entities.MagicElement.WIND;
import static pl.gda.pg.eti.kask.javaee.enterprise.entities.MagicElement.EARTH;

@Singleton
@Startup
@Log
public class InitialFixture {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init() {
        Long towersCount = em.createNamedQuery(Tower.Queries.COUNT_ALL, Long.class).getSingleResult();

        if (towersCount == 0) {
                List<Tower> towers = asList(
                        new Tower(120),
                        new Tower(227),
                        new Tower(331),
                        new Tower(15),
                        new Tower(12)
                );

                towers.forEach(tower -> em.persist(tower));
                em.flush();

                List<Wizard> wizards = asList(
                        new Wizard("Xardas", FIRE, 100, towers.get(0)),
                        new Wizard("Milten", WATER, 120, towers.get(1)),
                        new Wizard("Corristo", WIND, 130, towers.get(3)),
                        new Wizard("Rangar", EARTH, 140, towers.get(3)),
                        new Wizard("Torrez", FIRE, 150, towers.get(4))
                );

                wizards.forEach(wizard -> em.persist(wizard));
        }
    }

}
