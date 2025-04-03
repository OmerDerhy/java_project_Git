package parkingLot;

import java.util.Objects;

public class car {
    private String brand;
    private String model;
    private String color;
    private int year;
    private String PlateNumber;
    private boolean isHandicapped;

    public car(String brand, String model, String color, int year, String plateNumber, boolean isHandicapped) {
        setBrand(brand);
        setModel(model);
        setColor(color);
        setYear(year);
        setPlateNumber(plateNumber);
        setHandicapped(isHandicapped);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public void setHandicapped(boolean handicapped) {
        isHandicapped = handicapped;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        car car = (car) o;
        return year == car.year && isHandicapped == car.isHandicapped && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(PlateNumber, car.PlateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PlateNumber);
    }

    @Override
    public String toString() {
        return "car{" +
                "PlateNumber='" + PlateNumber + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
