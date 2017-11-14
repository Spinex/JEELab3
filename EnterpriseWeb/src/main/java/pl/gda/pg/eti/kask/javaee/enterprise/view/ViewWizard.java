package pl.gda.pg.eti.kask.javaee.enterprise.view;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.Wizard;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean
public class ViewWizard implements Serializable {

    @Getter
    @Setter
    private Wizard wizard;
}
