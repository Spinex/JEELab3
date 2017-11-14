package pl.gda.pg.eti.kask.javaee.enterprise.view;

import pl.gda.pg.eti.kask.javaee.enterprise.WizardService;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author psysiu
 */
@ViewScoped
@ManagedBean
public class ListTowers implements Serializable {

    @EJB
    WizardService wizardService;

    private List<Tower> towers;

    public List<Tower> getTowers() {
        if (towers == null) {
            towers = wizardService.findAllTowers();
        }
        return towers;
    }
}
