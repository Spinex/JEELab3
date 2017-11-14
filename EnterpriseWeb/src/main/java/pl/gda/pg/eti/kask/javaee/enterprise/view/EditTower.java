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
public class EditTower implements Serializable {

    @EJB
    WizardService wizardService;

    @Getter
    @Setter
    private Tower tower;

    public void init() {
        if (tower == null) {
            tower = new Tower();
        }
    }

    public String saveTower() {
        wizardService.saveTower(tower);
        return "list_wizards?faces-redirect=true";
    }
}
