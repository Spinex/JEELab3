package pl.gda.pg.eti.kask.javaee.enterprise.view.converters;


import pl.gda.pg.eti.kask.javaee.enterprise.WizardService;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Tower;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@RequestScoped
public class TowerConverter implements Converter {

    @EJB
    WizardService wizardService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Tower tower = wizardService.findTower(Integer.parseInt(value));

        if (tower == null) {
            context.getExternalContext().setResponseStatus(HttpServletResponse.SC_NOT_FOUND);
            context.responseComplete();
        }

        return tower;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Tower tower = (Tower) value;
        return Integer.toString(tower.getHeight());
    }
}
