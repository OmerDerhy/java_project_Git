package parkingLot;

import java.util.Arrays;
import java.util.Objects;

public class ParkingLot {
    private int id;
    private String name;
    private String address;
    private car[] regularParking;
    private car[] handicappedParking;
    private int numofregularcars;
    private int numofhandicappedcars;

    public ParkingLot(int id, String name, String address, int numofregularcars, int numofhandicappedcars) {
        setId(id);
        setName(name);
        setAddress(address);
        setNumofregularcars(numofregularcars);
        setNumofhandicappedcars(numofhandicappedcars);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public car[] getRegularParking() {
        return regularParking;
    }

    public void setRegularParking(car[] regularParking) {
        this.regularParking = regularParking;
    }

    public car[] getHandicappedParking() {
        return handicappedParking;
    }

    public void setHandicappedParking(car[] handicappedParking) {
        this.handicappedParking = handicappedParking;
    }

    public int getNumofregularcars() {
        return numofregularcars;
    }

    public void setNumofregularcars(int numofregularcars) {
        this.numofregularcars = numofregularcars;
    }

    public int getNumofhandicappedcars() {
        return numofhandicappedcars;
    }

    public void setNumofhandicappedcars(int numofhandicappedcars) {
        this.numofhandicappedcars = numofhandicappedcars;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "regularParking=" + Arrays.toString(regularParking) +
                ", handicappedParking=" + Arrays.toString(handicappedParking) +
                ", numofregularcars=" + numofregularcars +
                ", numofhandicappedcars=" + numofhandicappedcars +
                '}';
    }
    public boolean park(car cars, boolean isHandicapped){
        int index = getNextCarParkingSpot(isHandicapped);
        if(isHandicapped){
            handicappedParking[index] = cars;
            numofhandicappedcars++;
        }else{
            regularParking[index] = cars;
            numofregularcars++;
        }
        return true;
    }
    public car exit(String plateNumber, boolean isHandicapped){
        int index = findByPlateNumber(plateNumber,isHandicapped);
        car cars = null;
        if(index !=-1){
            cars = handicappedParking[index];
            handicappedParking[index] = null;
            numofhandicappedcars++;
        }else{
            cars = regularParking[index];
            regularParking[index] = null;
            numofregularcars++;
        }
        return cars;
    }
    public int findByPlateNumber(String plateNumber, boolean isHandicapped){
        return isHandicapped? getIndexByPlateNumber(handicappedParking,plateNumber) : getIndexByPlateNumber(regularParking,plateNumber)
    }
    public int getIndexByPlateNumber(car[] parkingspots,String plateNumber){
        for(int i = 0; i<parkingspots.length;i++){
            if (parkingspots[i].)
        }
    }
    public int size(){

    }
    public int size(boolean isHandicapped){

    }
    public int getNumOCars(){
        return getNumOfCars(true) + getNumOfCars(false);
    }
    public int getNumOfCars(boolean isHandicapped){
        return isHandicapped? numofhandicappedcars : numofregularcars;
    }
    public int getNextCarParkingSpot(boolean isHandicapped){
        return isHandicapped? getEmptySpotIndex(handicappedParking) : getEmptySpotIndex(regularParking);
    }
    public int getEmptySpotIndex(car[] carspots){
        for (int i =0;i<carspots.length;i++){
            if (carspots[i]==null){
                return i;
            }
        }
        return -1;
    }
    public boolean isFull() {
        return isFull(true) && isFull(false);
    }
    public boolean isFull(boolean isHandicapped){
        return isHandicapped? getNumofhandicappedcars()==handicappedParking.length : getNumofregularcars()==regularParking.length;
    }


}
