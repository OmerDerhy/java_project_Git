package Omer_Itamar_project;
// עומר דרעי ואיתמר דנקברג
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome Manager");
        System.out.println("Enter name of collage you are studying in: ");
        String CollageName = scn.nextLine();
        String name,knowlege,id,ID,department;
        int amount_of_students;
        Degree degree;
        double salary;
        Manager manager = new Manager(CollageName);
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            int menuNum;
            System.out.println("Choose a number: ");
            menuNum = scn.nextInt();
            scn.nextLine();
            switch (menuNum) {
                case 0:
                    isRunning = false;
                    System.out.println("Good Bye");
                    break;

                case 1:
                    System.out.println("Insert lecturer's name:");
                    name = scn.nextLine();
                    System.out.println("Insert lecturer's ID:");
                    id = scn.nextLine();
                    while (!manager.IdEqual(id)) {
                        System.out.println("This Id is already exist ");
                        System.out.println("Insert new lecturer's ID:");
                        id = scn.nextLine();
                    }
                    System.out.println("Insert lecturer's degree(BA/MA/PHD/PROFESSOR)");
                    knowlege = scn.nextLine();
                    degree = Degree.valueOf(knowlege);
                    System.out.println("Insert lecturer's degree name:");
                    String name_degree = scn.nextLine();
                    System.out.println("Insert lecturer's salary:");
                    salary = scn.nextDouble();
                    System.out.println("Insert lecturer's salary:");
                    department = scn.nextLine();
                    Lecturers Lecturer = new Lecturers(name, id, degree, name_degree, salary,department);
                    manager.addLecturer(Lecturer);
                    break;

                case 2:
                    System.out.println("Insert committee name: ");
                    name = scn.nextLine();
                    while (!manager.committees_name_Equal(name)) {
                        System.out.println("This name is already exist, please Insert a different name: ");
                        name = scn.nextLine();
                    }
                    System.out.println("Insert ID of the leader: ");
                    String leader_ID = scn.nextLine();
                    while (!manager.able_Leader(leader_ID)) {
                        System.out.println("The lecturer doesn't exist or doesn't have the right degree try again");
                        leader_ID = scn.nextLine();
                    }
                    manager.addCommittee(name, leader_ID);
                    System.out.println("The committee added succsesfully!");
                    break;
                case 3:
                    System.out.println("Insert the name of the committee:");
                    String com_name = scn.nextLine();
                    int com_index = manager.Find_committee(com_name);
                    while (com_index == -1) {
                        System.out.println("The Committee doesn't exist try again");
                        com_name = scn.nextLine();
                        com_index = manager.Find_committee(com_name);
                    }
                    System.out.println("Insert the ID of the lecturer:");
                    ID = scn.nextLine();
                    int lec_index = manager.Find_Lecturer(ID);
                    while (lec_index == -1 || manager.is_leader(lec_index,com_index)) {
                        System.out.println("The lecturer doesn't exist or is already a leader try again");
                        ID = scn.nextLine();
                        lec_index = manager.Find_Lecturer(ID);
                    }
                    manager.add_lecturer_to_committe(lec_index,com_index);
                    System.out.println("succeeded!");
                    break;
                case 4:
                    System.out.println("Insert the committee name:");
                    com_name = scn.nextLine();
                    while (manager.committees_name_Equal(com_name)) {
                        System.out.println("The committee doesn't exist, try again: ");
                        com_name = scn.nextLine();
                    }
                    System.out.println("Insert the lecturer ID:");
                    boolean check = true;
                    id = scn.nextLine();
                    while (check) {
                        if (manager.IdEqual(id)) {
                            System.out.println("The lecturer doesn't exist, try again:");
                            id = scn.nextLine();
                        } else if (!manager.able_Leader(id)) {
                            System.out.println("The lecturer is not a PHD/PROFESSOR, try again:");
                            id = scn.nextLine();
                        } else {
                            check = false;
                        }
                    }
                    manager.change_leader(id,com_name);
                    System.out.println("succeed");
                    break;
                case 5:
                    System.out.println("Insert the name of the committee:");
                    String name1 = scn.nextLine();
                    while(manager.Find_committee(name1)==-1){
                        System.out.println("The committee doesn't exist, try again:");
                        name1 = scn.nextLine();
                    }
                    System.out.println("Insert the ID of the lecturer in the committee:");
                    String Id =scn.nextLine();
                    while(manager.Find_Lecturer(Id)==-1){
                        System.out.println("The lecturer doesn't exist, try again:");
                        Id = scn.nextLine();
                    }
                    manager.remove_lecturer_from_committee(Id,name1);
                    System.out.println("Succeed");
                    break;

                case 6:
                    System.out.println("Insert the name of the new department:");
                    department = scn.nextLine();
                    while (manager.Find_Department(department) != -1) {
                        System.out.println("The department's name is already exist try again");
                        department = scn.nextLine();
                    }
                    System.out.println("Insert the amount of student that studying the department:");
                    amount_of_students = scn.nextInt();
                    manager.addDepartment(department,amount_of_students);
                    break;

                case 7:
                    System.out.println("The average salary is: "+manager.get_avg_salary());
                    break;

                case 8:
                    System.out.println("Insert the committee name: ");
                    String committee = scn.nextLine();
                    while(manager.Find_committee(committee)==-1){
                        System.out.println("The committee doesn't exist try again");
                        committee = scn.nextLine();
                    }
                    System.out.println("The average salary is: "+manager.get_avg_salary(manager.Find_committee(committee)));
                    break;
                case 9:
                    manager.displayLecturers();
                    break;
                case 10:
                    manager.displayCommittees();
                    break;

                case 11:
                    System.out.println("Insert the name of the department:");
                    department = scn.nextLine();
                    int dep_index =manager.Find_Department(department);
                    while(dep_index==-1){
                        System.out.println("The Department doesn't exist, try again");
                        department = scn.nextLine();
                        dep_index =manager.Find_Department(department);
                    }
                    System.out.println("Insert the Id of the lecturer:");
                    Id = scn.nextLine();
                    lec_index = manager.Find_Lecturer(Id);
                    while(lec_index==-1){
                        System.out.println("The Lecturer doesn't exist, try again");
                        Id = scn.nextLine();
                        lec_index = manager.Find_Lecturer(Id);
                    }
                    manager.add_lecturer_to_department(dep_index,lec_index);
                    System.out.println("Succeed");
                    break;
                case 12:
                    manager.displayDepartments();
                    break;

                default:
                    System.out.println("Invalid number, try again.");
                    break;
            }

        }

    }

    private static void printMenu(){
        System.out.println("0 - exit");
        System.out.println("1 - add lecturer");
        System.out.println("2 - add committee");
        System.out.println("3 - add a lecturer to a committee");
        System.out.println("4 - change the leader of a committee");
        System.out.println("5 - remove a lecturer from a committee");
        System.out.println("6 - department assign");
        System.out.println("7 - show the average salary in the collage");
        System.out.println("8 - show the average salary in a committee");
        System.out.println("9 - lecturers details");
        System.out.println("10 - committee details");
        System.out.println("11 - add lecturer to department");
        System.out.println("12 - department details");
    }
}