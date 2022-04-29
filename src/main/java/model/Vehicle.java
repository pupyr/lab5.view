package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle
{
    private Long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Float enginePower;
    private Integer numberOfWheels;
    private VehicleType type;
    private FuelType fuelType;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Float getEnginePower() {
        return this.enginePower;
    }

    public void setEnginePower(Float enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public void setNumberOfWheels(Integer numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public VehicleType getType() {
        return this.type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Vehicle(Long id, String name, Coordinates coordinates, Date creationDate, Float enginePower, Integer numberOfWheels, VehicleType type, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.numberOfWheels = numberOfWheels;
        this.type = type;
        this.fuelType = fuelType;
    }

    public Vehicle() {
    }

    public String write(int i) {
        DateFormat df = new SimpleDateFormat("dd MMM yyy HH:mm:ss");
        if (i == 0) {
            return " id=" + id  + " Имя=" + name + " " + coordinates.write(0) + " дата создания=" + df.format(creationDate)  + " сила двигателя=" + enginePower + " кол-во колес=" + numberOfWheels  + " тип транспорта=" + type +  " тип топлива=" + fuelType ;
        }
        return " id=\"" + id + '\"' + " name=\"" + name + "\" " + coordinates.write(1) + " creationDate=\"" + creationDate.toInstant() + '\"' + " enginePower=\"" + enginePower + '\"' + " numberOfWheels=\"" + numberOfWheels + '\"' + " VehicleType=\"" + type + '\"' + " FuelType=\"" + fuelType + '\"' + "/>";
    }
}
