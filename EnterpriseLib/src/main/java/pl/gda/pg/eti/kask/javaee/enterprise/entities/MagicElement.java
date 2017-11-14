package pl.gda.pg.eti.kask.javaee.enterprise.entities;

public enum MagicElement {
    WATER("Woda"),
    FIRE("Ogien"),
    EARTH("Ziemia"),
    WIND("Wiatr");

    public String name;

    MagicElement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
