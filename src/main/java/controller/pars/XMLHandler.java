package controller.pars;

import model.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class XMLHandler extends DefaultHandler
{
    @Override
    public void startElement( String uri,  String localName,  String qName,  Attributes attributes) {
        try {
            Root root=Root.getInstance();
            if (qName.equals("vehicle")) {
                Long key = Long.parseLong(attributes.getValue("key"));
                Long id = Long.parseLong(attributes.getValue("id"));
                String name = attributes.getValue("name");
                float x = Float.parseFloat(attributes.getValue("x"));
                double y = Double.parseDouble(attributes.getValue("y"));
                Date creationDate = Date.from(Instant.parse(attributes.getValue("creationDate")));
                Float enginePower = null;
                if (!attributes.getValue("enginePower").equals("null")) {
                    enginePower = Float.parseFloat(attributes.getValue("enginePower"));
                }
                Integer numberOfWheels = null;
                if (!attributes.getValue("numberOfWheels").equals("null")) {
                    numberOfWheels = Integer.parseInt(attributes.getValue("numberOfWheels"));
                }
                VehicleType type = null;
                if (!attributes.getValue("VehicleType").equals("null")) {
                    type = VehicleType.valueOf(attributes.getValue("VehicleType"));
                }
                FuelType fuelType = FuelType.valueOf(attributes.getValue("FuelType"));
                Coordinates coordinates = new Coordinates(x, y);
                Vehicle vehicle = new Vehicle(id, name, coordinates, creationDate, enginePower, numberOfWheels, type, fuelType);
                root.add(key, vehicle);
                root.setDate(new Date());
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("в файле неверные данные");
            System.exit(0);
        }
    }
}
