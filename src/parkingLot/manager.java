package parkingLot;
import java.util.Scanner;
public class manager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initSystem(scanner);
        ParkingLot parkinglot = new ParkingLot(101, "Arlozorov", "Arlozorov , 101, Tel-Aviv", 20, 6);
        boolean isRunning = true;
    }
    public static void initSystem(Scanner scan){
        System.out.println("Hello manager!");
        System.out.println("__________________");
        System.out.println("Enter adminstraitor information:");
        employee emp = new employee(getId(scan,"id"),getStrFromUser(scan,"FullName"),get)


    }
}
