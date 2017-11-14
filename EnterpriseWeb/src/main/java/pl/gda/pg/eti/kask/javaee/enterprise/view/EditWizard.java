package pl.gda.pg.eti.kask.javaee.enterprise.view;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import pl.gda.pg.eti.kask.javaee.enterprise.WizardService;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.MagicElement;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;

@ViewScoped
@ManagedBean
@Log
public class EditWizard implements Serializable {

    @EJB
    WizardService wizardService;

    @Getter
    @Setter
    private Wizard wizard;

    List<Tower> availableTowers;

    public List<Tower> getAvailableTowers() {
        if (availableTowers == null) {
            availableTowers = wizardService.findAllTowers();
        }

        return availableTowers;
    }

    public MagicElement[] getMagicElementTypes() {
        return MagicElement.values();
    }

    public void init() {
        if (wizard == null) {
            wizard = new Wizard();
        }
    }

    public String saveWizard() {
        log.log(Level.WARNING, "SAVING WIZARD!");
        wizardService.saveWizard(wizard);
        log.log(Level.WARNING, "SAVED WIZARD!");
        return "list_wizards?faces-redirect=true";
    }
}
