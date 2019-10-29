package nl.fhict.ovp2.zalando.model.warehouse;

import java.text.MessageFormat;

public class Aisle {

    private final String stackCode;
    private final String railCode;
    private final Coordinate coordinate;

    public Aisle(String stackCode, String railCode, Coordinate coordinate) {
        this.stackCode = stackCode;
        this.railCode = railCode;
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        if(railCode.startsWith("3") || railCode.startsWith("6") || railCode.startsWith("7")){
            return MessageFormat.format("stackCode={0}, railCode={1}, coordinate={2}", stackCode, "xx", coordinate);
        }else {
            return MessageFormat.format("stackCode={0}, railCode={1}, coordinate={2}", stackCode, railCode, coordinate);
        }
    }
}
