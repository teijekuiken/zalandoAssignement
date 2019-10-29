package nl.fhict.ovp2.zalando.model.warehouse;

import java.text.MessageFormat;

public class Location {

    private final String path;
    private final Aisle aisle;

    public Location(String path, Aisle aisle) {
        this.path = path;
        this.aisle = aisle;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return MessageFormat.format("location path={0}, aisle={1}", path, aisle);
    }
}
