package pl.gda.pg.eti.kask.javaee.enterprise.view.converters;

import pl.gda.pg.eti.kask.javaee.enterprise.WizardService;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@RequestScoped
public class WizardConverter implements Converter {

    @EJB
    WizardService wizardService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        Wizard wizard = wizardService.findWizard(Integer.parseInt(value));

        if (wizard == null) {
            context.getExternalContext().setResponseStatus(HttpServletResponse.SC_NOT_FOUND);
            context.responseComplete();
        }

        return wizard;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Wizard wizard = (Wizard) value;
        return wizard.getId() != null ? Integer.toString(wizard.getId()) : null;
    }
}
