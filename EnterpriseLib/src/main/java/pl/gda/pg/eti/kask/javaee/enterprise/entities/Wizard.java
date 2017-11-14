package pl.gda.pg.eti.kask.javaee.enterprise.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.gda.pg.eti.kask.javaee.enterprise.entities.validators.InPast;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@ToString(of = "name")
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = Wizard.Queries.FIND_ALL, query = "SELECT b FROM Wizard b"),
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Wizard extends Audit implements Serializable {

    public static class Queries {
        public static final String FIND_ALL = "Wizard.findAll";
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private Integer mana = 0;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private MagicElement magicElement = MagicElement.FIRE;

    @Getter
    @Setter
    @ManyToOne(cascade = {MERGE, DETACH})
    private Tower tower;

    public Wizard(String name, MagicElement magicElement, int mana, Tower tower) {
        this.name = name;
        this.magicElement = magicElement;
        this.mana = mana;
        this.tower = tower;
    }
}
