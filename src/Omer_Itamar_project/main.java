package Omer_Itamar_project;
// עומר דרעי ואיתמר דנקברג
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome Manager");
        System.out.println("Enter name of collage you are studying in: ");
        String CollageName = scn.nextLine();
        String name,knowlege,id,department,salary;
        int amount_of_students;
        int dep_index,lec_index,com_index;
        boolean check;
        Degree degree;
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
                    while (!manager.NameEqual(name)) {
                        System.out.println("This name is already exist ");
                        System.out.println("Insert new lecturer's name:");
                        name = scn.nextLine();
                    }
                    System.out.println("Insert lecturer's ID:");
                    id = scn.nextLine();
                    System.out.println("Insert lecturer's degree(BA/MA/PHD/PROFESSOR)");
                    knowlege = scn.nextLine();
                    degree = Degree.valueOf(knowlege);
                    System.out.println("Insert lecturer's degree name:");
                    String name_degree = scn.nextLine();
                    System.out.println("Insert lecturer's salary:");
                    salary = scn.nextLine();
                    double Salary = Double.parseDouble(salary);
                    while(Salary<0){
                        System.out.println("Insert valid salary:");
                        Salary = scn.nextDouble();
                    }
                    System.out.println("Insert lecturer's Department. (enter 0 if the lecturer doesn't have a department)");
                    department = scn.nextLine();
                    if(!department.equals("0")) {
                        dep_index = manager.FindDepartment(department);
                        while (dep_index == -1) {
                            System.out.println("The department doesn't exist, try again:");
                            department = scn.nextLine();
                            dep_index = manager.FindDepartment(department);
                        }
                        Department dep = manager.getDepartments()[dep_index];
                        Lecturer Lecturer = new Lecturer(name, id, degree, name_degree, Salary,dep);
                        manager.addLecturer(Lecturer);
                        manager.AddlecturerToDepartment(dep_index,manager.getLecturerSize()-1);
                    }
                    else{
                        Lecturer Lecturer = new Lecturer(name, id, degree, name_degree, Salary,null);
                        manager.addLecturer(Lecturer);
                    }
                    break;

                case 2:
                    System.out.println("Insert committee name: ");
                    name = scn.nextLine();
                    while (!manager.committeesNameEqual(name)) {
                        System.out.println("This name is already exist, please Insert a different name: ");
                        name = scn.nextLine();
                    }
                    System.out.println("Insert the name of the leader: ");
                    String leader_Name = scn.nextLine();
                    while (!manager.ableLeader(leader_Name)) {
                        System.out.println("The lecturer doesn't exist or doesn't have the right degree try again");
                        leader_Name = scn.nextLine();
                    }
                    manager.addCommittee(name, leader_Name);
                    System.out.println("The committee added succsesfully!");
                    break;
                case 3:
                    System.out.println("Insert the name of the committee:");
                    String com_name = scn.nextLine();
                    com_index = manager.FindCommittee(com_name);
                    while (com_index == -1) {
                        System.out.println("The Committee doesn't exist try again");
                        com_name = scn.nextLine();
                        com_index = manager.FindCommittee(com_name);
                    }
                    System.out.println("Insert the name of the lecturer:");
                    name = scn.nextLine();
                    lec_index = manager.FindLecturer(name);
                    check = true;
                    while(check) {
                        if (lec_index == -1) {
                            System.out.println("The lecturer doesn't exist, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        } else if (manager.IsLeader(lec_index, com_index)) {
                            System.out.println("The lecturer is already the leader, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        }
                        else if (manager.lecturerInCommittee(lec_index,com_index)){
                            System.out.println("The lecturer is already in the committee, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        }
                        else
                            check = false;
                    }
                    manager.addLecturerToCommitte(lec_index,com_index);
                    System.out.println("succeeded!");
                    break;
                case 4:
                    System.out.println("Insert the committee name:");
                    com_name = scn.nextLine();
                    com_index = manager.FindCommittee(com_name);
                    while (com_index==-1) {
                        System.out.println("The committee doesn't exist, try again: ");
                        com_name = scn.nextLine();
                        com_index = manager.FindCommittee(com_name);
                    }
                    System.out.println("Insert the lecturer name:");
                    check = true;
                    name = scn.nextLine();
                    lec_index = manager.FindLecturer(name);
                    while (check) {
                        if (lec_index==-1) {
                            System.out.println("The lecturer doesn't exist, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        } else if (!manager.ableLeader(name)) {
                            System.out.println("The lecturer is not a PHD/PROFESSOR, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        } else {
                            check = false;
                        }
                    }
                    manager.setLeader(lec_index,com_index);
                    System.out.println("succeed");
                    break;
                case 5:
                    System.out.println("Insert the name of the committee:");
                    String nameC = scn.nextLine();
                    while(manager.FindCommittee(nameC)==-1){
                        System.out.println("The committee doesn't exist, try again:");
                        nameC = scn.nextLine();
                    }
                    System.out.println("Insert the name of the lecturer in the committee:");
                    name =scn.nextLine();
                    check = true;
                    lec_index = manager.FindLecturer(name);
                    com_index = manager.FindCommittee(nameC);
                    while(check){
                        if(lec_index==-1){
                            System.out.println("The lecturer doesn't exist, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        }
                        else if(manager.IsLeader(manager.FindLecturer(name), manager.FindCommittee(nameC))){
                            System.out.println("The lecturer is the leader, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        }
                        else if(!manager.lecturerInCommittee(lec_index,com_index)){
                            System.out.println("The lecturer isn't in the committee, try again:");
                            name = scn.nextLine();
                            lec_index = manager.FindLecturer(name);
                        }
                        else
                            check = false;
                    }
                    manager.RemoveLecturerFromCommittee(name,nameC);
                    System.out.println("Succeed");
                    break;

                case 6:
                    System.out.println("Insert the name of the new department:");
                    department = scn.nextLine();
                    while (manager.FindDepartment(department) != -1) {
                        System.out.println("The department's name is already exist try again");
                        department = scn.nextLine();
                    }
                    System.out.println("Insert the amount of student that studying the department:");
                    amount_of_students = scn.nextInt();
                    manager.addDepartment(department,amount_of_students);
                    break;

                case 7:
                    System.out.println("The average salary is: "+manager.getAvgSalary());
                    break;

                case 8:
                    System.out.println("Insert the committee name: ");
                    String committee = scn.nextLine();
                    while(manager.FindCommittee(committee)==-1){
                        System.out.println("The committee doesn't exist try again");
                        committee = scn.nextLine();
                    }
                    System.out.println("The average salary is: "+manager.getAvgSalary(manager.FindCommittee(committee)));
                    break;
                case 9:
                    manager.displayAll(manager.getLecturers());
                    break;
                case 10:
                    manager.displayAll(manager.getCommittees());
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
    }
}