package nl.fhict.ovp2.zalando.model.warehouse;

import java.text.MessageFormat;

public class Coordinate {

    private final double x;
    private final double y;
    private final double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return MessageFormat.format("x={0}, y={1}, z={2}", x, y, z);
    }
}
