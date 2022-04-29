package controller.absCommand;

import controller.Data;
import controller.absCommand.command.Script;
import model.*;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ElementCreator
{
    String s;
    Vehicle vehicle;
    Long Lmax;

    public ElementCreator() {
        vehicle = new Vehicle();
        Lmax = 0L;
    }

    public void setId(){
        Root root=Root.getInstance();
        for (Long l : root.getRoot().keySet()) {
            if (Lmax < root.getRoot().get(l).getId()) {
                Lmax = root.getRoot().get(l).getId();
            }
        }
        vehicle.setId(Lmax + 1L);
    }
    public void setName(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите имя");
        while (true) {
            s = scanner.nextLine();
            if (!s.equals("")) {
                break;
            }
            System.out.println("неверный тип данных. Поле обязательно для ввода");
        }
        vehicle.setName(s);
    }
    public void setCoordinates(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите координаты");
        Coordinates coordinates = new Coordinates();
        if(!Script.getInstance().isScriptStart())System.out.println("Введите x");
        while (true) {
            s = scanner.nextLine();
            try {
                coordinates.setX(Float.parseFloat(s));
                if (Float.parseFloat(s) < 286.0f) {
                    break;
                }
                System.out.println("х должен быть меньше 286");
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных. Поле обязательно для ввода");
            }
        }
        if(!Script.getInstance().isScriptStart())System.out.println("Введите y");
        while (true) {
            s = scanner.nextLine();
            try {
                coordinates.setY(Double.parseDouble(s));
                if (Double.parseDouble(s) < 53.0) {
                    break;
                }
                System.out.println("у должен быть меньше 53");
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных. Поле обязательно для ввода");
            }
        }
        vehicle.setCoordinates(coordinates);
    }

    public void setEnginePower(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите силу двигателя");
        while (true) {
            s = scanner.nextLine();
            try {
                if (s.equals("")) {
                    vehicle.setEnginePower(null);
                }
                else if (Float.parseFloat(s) > 0.0f) {
                    vehicle.setEnginePower(Float.parseFloat(s));
                }
                else {
                    System.out.println("сила двигателя должна быть больше 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
                continue;
            }
            break;
        }
    }

    public void setNumberOfWheels(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите кол-во колес");
        while (true) {
            s = scanner.nextLine();
            try {
                if (s.equals("")) {
                    vehicle.setNumberOfWheels(null);
                }
                else if (Integer.parseInt(s) > 0) {
                    vehicle.setNumberOfWheels(Integer.parseInt(s));
                }
                else {
                    System.out.println("кол-во колес должно быть больше 0");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("неверный тип данных");
                continue;
            }
            break;
        }
    }

    public void setType(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите тип транспорта:\n    CAR,\n    PLANE,\n    DRONE,\n    MOTORCYCLE,\n    SPACESHIP");
        while (true) {
            s = scanner.nextLine();
            if (s.equals("")) {
                vehicle.setType(null);
                break;
            }
            if (s.equals("CAR") | s.equals("PLANE") | s.equals("DRONE") | s.equals("MOTORCYCLE") | s.equals("SPACESHIP")) {
                vehicle.setType(VehicleType.valueOf(s));
                break;
            }
            System.out.println("неверный тип данных, введит что-то из списка:\n    CAR,\n    PLANE,\n    DRONE,\n    MOTORCYCLE,\n    SPACESHIP");
        }
    }

    public void setFuelType(Scanner scanner){
        if(!Script.getInstance().isScriptStart())System.out.println("Введите тип топлива\n    ELECTRICITY,\n    NUCLEAR,\n    ANTIMATTER");
        while (true) {
            s = scanner.nextLine();
            if (s.equals("ELECTRICITY") | s.equals("NUCLEAR") | s.equals("ANTIMATTER")) {
                break;
            }
            System.out.println("Неверный тип данных, введит что-то из списка:\n    ELECTRICITY,\n    NUCLEAR,\n    ANTIMATTER");
        }
        vehicle.setFuelType(FuelType.valueOf(s));
    }

    public Vehicle createElement(Data data) {
        try {
            System.out.println("Создание, изменение или удаление объекта с номером "+data.getSecondWord());
            Data dataInstance = Data.getInstance();
            Scanner scanner = dataInstance.getScanner();
            setId();
            setName(scanner);
            setCoordinates(scanner);
            vehicle.setCreationDate(new Date());
            setEnginePower(scanner);
            setNumberOfWheels(scanner);
            setType(scanner);
            setFuelType(scanner);
            return vehicle;
        }catch (NoSuchElementException e){
            System.out.println("Команда с вводом Vehicle имеет неполные или некорректны данные. Дополните скрипт");
            Script.getInstance().setCorrectScript(false);
        }
        return null;
    }
}
