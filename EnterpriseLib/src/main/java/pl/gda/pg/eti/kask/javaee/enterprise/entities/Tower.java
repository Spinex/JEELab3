package pl.gda.pg.eti.kask.javaee.enterprise.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = Tower.Queries.FIND_ALL, query = "SELECT a FROM Tower a"),
        @NamedQuery(name = Tower.Queries.COUNT_ALL, query = "SELECT COUNT(a) FROM Tower a"),
})
public class Tower extends Audit implements Serializable {

    public static class Queries {
        public static final String FIND_ALL = "Tower.findAll";
        public static final String COUNT_ALL = "Tower.countAll";
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private int height;

    public Tower(int height) {
        this.height = height;
    }
}
