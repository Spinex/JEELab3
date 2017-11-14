package pl.gda.pg.eti.kask.javaee.enterprise.view;

import pl.gda.pg.eti.kask.javaee.enterprise.WizardService;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author psysiu
 */
@ViewScoped
@ManagedBean
public class ListWizards implements Serializable {

    @EJB
    WizardService wizardService;

    private List<Tower> towers;
    private List<Wizard> wizards;

    public List<Tower> getTowers() {
        if (towers == null) {
            towers = wizardService.findAllTowers();
        }
        return towers;
    }

    public List<Wizard> getWizards() {
        if (wizards == null) {
            wizards = wizardService.findAllWizards();
        }
        return wizards;
    }

    public void removeWizards(List<Wizard> wizards) {
        wizards.forEach(x -> wizardService.removeWizard(x));
        towers = null;
    }

    public String removeWizard(Wizard wizard) {
        wizardService.removeWizard(wizard);
        towers = null;
        return "list_wizards?faces-redirect=true";
    }

    public String removeTower(Tower tower) {
        List<Wizard> wizardsToDelete = getWizards().stream().filter( d -> d.getTower().getId() == tower.getId() ).collect(Collectors.toList());
        removeWizards(wizardsToDelete);
        wizardService.removeTower(tower);
        towers = null;
        return "list_wizards?faces-redirect=true";
    }

    public List<Wizard> getWizardsByTower(final Tower tower) {
        getWizards();
        return this.wizards.stream().filter( d -> d.getTower().getId() == tower.getId() ).collect(Collectors.toList());
    }

}
