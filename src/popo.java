package popo;
// Gabie Mazaltok And Naama Deshet
import java.util.Scanner;
public class popo {
    private static String [] lecturers = new String[1];
    private static String [] committees = new String[1];
    private static String [] departments = new String[1];
    private static int lectureSize = 0, committeeSize = 0, departmentSize = 0;

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome :) ");
        System.out.println("Enter the name of collage: ");
        scn.nextLine();
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            int menuNum;
            System.out.println("Choose a number: ");
            menuNum = scn.nextInt();
            scn.nextLine();
            switch (menuNum){
                case 0:
                    isRunning = false;
                    System.out.println("Good Bye");
                    break;

                case 1:
                    addLecturer(scn,lecturers);
                    break;

                case 2:
                    addCommittee(scn);
                    break;
                case 3:
                    addDepartment(scn);
                    break;
                case 4:
                    assignLecturerToCommittee(scn,scn);
                    break;
                case 5:
                    displayAvgSalary();
                    break;

                case 6:
                    displayAvgSalaryDepartment(scn);
                    break;

                case 7:
                    displayLecturers(lecturers);
                    break;

                case 8:
                    displayCommittees(committees);
                    break;
                default:
                    System.out.println("Invalid number, try again.");
                    break;
            }

        }

    }

    private static void addLecturer(Scanner lecturer, String[] array){
        System.out.println("Enter lecturer name: ");
        String name = lecturer.nextLine();
        while(isEqual(lecturers,name)){
            System.out.println("This name already exist, please enter a different name: ");
            name = lecturer.nextLine();
        }
        if (lectureSize == lecturers.length){
            lecturers = extendArray(lecturers);
        }
        lecturers[lectureSize]=name;
        lectureSize ++;

    }

    private static void addCommittee(Scanner committee){
        System.out.println("Enter committee name: ");
        String name = committee.nextLine();
        while(isEqual(committees,name)){
            System.out.println("This name already exist, please enter a different name: ");
            name = committee.nextLine();
        }
        if (committeeSize == committees.length){
            committees = extendArray(committees);
        }
        committees[committeeSize]=name;
        committeeSize ++;
    }

    private static void addDepartment(Scanner department){
        System.out.println("Enter department name: ");
        String name = department.nextLine();
        while(isEqual(departments,name)){
            System.out.println("This name already exist, please enter a different name: ");
            name = department.nextLine();
        }
        if (departmentSize == departments.length){
            departments = extendArray(departments);
        }
        departments[departmentSize]=name;
        departmentSize ++;
    }
    private static void assignLecturerToCommittee(Scanner lecturer, Scanner committee){
        System.out.println("Enter lecturer name: ");
        String name = lecturer.nextLine();
        if (isEqual(lecturers,name)){
            System.out.println();
        }
        else{
            System.out.println("This lecturer doesn't exist");
        }
        System.out.println("Enter committee name: ");
        String name1 = committee.nextLine();
        if (isEqual(committees,name1)){
            System.out.println();
        }
        else{
            System.out.println("This committee doesn't exist");
        }

    }
    private static void displayAvgSalary(){

    }
    private static void displayAvgSalaryDepartment(Scanner department){
        System.out.println("Enter department name: ");
        String name = department.nextLine();
    }

    private static void displayLecturers(String[] array){
        printArray(lecturers);



    }
    private static void  displayCommittees(String[] array){
        printArray(committees);

    }

    private static void printMenu(){

        System.out.println("0 - exit");
        System.out.println("1 - add lecturer");
        System.out.println("2 - add committee");
        System.out.println("3 - add study department");
        System.out.println("4 - assigning a lecturer to a committee");
        System.out.println("5 - lecturers salary avg");
        System.out.println("6 - lecturers salary avg of study department");
        System.out.println("7 - lecturers information");
        System.out.println("8 - committee information");

    }
    private static String[] extendArray(String [] array){
        String [] temp = new String[array.length*2];
        for (int i=0; i<array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }
    private static boolean isEqual(String[] array,String value){
        for (int i=0; i<array.length;i++){
            if (array[i]!= null && array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
    public static void printArray(String[] array){
        for (int size = 0; size<array.length; size++){
            System.out.print(array[size]+" ");
        }
        System.out.println();
    }
}