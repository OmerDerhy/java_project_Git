package ItamarAndOmer;
// עומר דרעי-322606674 ואיתמר דנקברג-216284158

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to College Management System");
        System.out.print("Enter college name: ");

        String collegeName = scanner.nextLine();

        College college = new College(collegeName);

        int choice;

        do {
            System.out.println("\n" + college.getName() + " Management System");
            System.out.println("0 - Exit");
            System.out.println("1 - Add lecturer to college");
            System.out.println("2 - Add committee to college");
            System.out.println("3 - Add member to committee");
            System.out.println("4 - Update committee chairperson");
            System.out.println("5 - Remove member from committee");
            System.out.println("6 - Add department");
            System.out.println("7 - Show average salary of all lecturers");
            System.out.println("8 - Show average salary of lecturers in a specific department");
            System.out.println("9 - Show details of all lecturers");
            System.out.println("10 - Show details of all committees");

            System.out.print("\nEnter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    System.out.println("Exiting program");

                    break;
                case 1:
                    addLecturer(scanner, college);

                    break;
                case 2:
                    addCommittee(scanner, college);

                    break;
                case 3:
                    addMemberToCommittee(scanner, college);

                    break;
                case 4:
                    updateCommitteeChairperson(scanner, college);

                    break;
                case 5:
                    removeMemberFromCommittee(scanner, college);

                    break;
                case 6:
                    addDepartment(scanner, college);

                    break;
                case 7:
                    showAverageSalary(college);

                    break;
                case 8:
                    showDepartmentAverageSalary(scanner, college);

                    break;
                case 9:
                    displayAllLecturers(college);

                    break;
                case 10:
                    displayAllCommittees(college);

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayLecturerNames(College college) {
        if (college.getLecturerCount() == 0) {
            System.out.println("No lecturers available.");

            return;
        }

        for (int i = 0; i < college.getLecturerCount(); i++) {
            System.out.println((i + 1) + ". " + college.getLecturers()[i].getName());
        }
    }

    private static void displayAllLecturers(College college) {
        if (college.getLecturerCount() == 0) {
            System.out.println("No lecturers available.");

            return;
        }

        System.out.println("----- All Lecturers -----");

        for (int i = 0; i < college.getLecturerCount(); i++) {
            System.out.println("\n----- Lecturer " + (i + 1) + " -----");
            System.out.println(college.getLecturers()[i]);
        }
    }

    private static boolean displayEligibleChairpersons(College college) {
        boolean found = false;

        for (int i = 0; i < college.getLecturerCount(); i++) {
            if (college.getLecturers()[i].getDegree() == Degree.PHD || college.getLecturers()[i].getDegree() == Degree.PROFESSOR) {
                System.out.println(i + ". " + college.getLecturers()[i].getName() + " (" + college.getLecturers()[i].getDegree() + ")");

                found = true;
            }
        }

        return found;
    }

    private static void displayCommitteeNames(College college) {
        if (college.committeeCount() == 0) {
            System.out.println("No committees available.");

            return;
        }

        for (int i = 0; i < college.committeeCount(); i++) {
            System.out.println((i + 1) + ". " + college.getCommittees()[i].getName());
        }
    }

    private static void displayAllCommittees(College college) {
        if (college.committeeCount() == 0) {
            System.out.println("No committees available.");

            return;
        }

        System.out.println("----- All Committees -----");

        for (int i = 0; i < college.committeeCount(); i++) {
            System.out.println("\n----- Committee " + (i + 1) + " -----");
            System.out.println(college.getCommittees()[i]);
        }
    }

    private static void displayDepartmentNames(College college) {
        if (college.departmentCount() == 0) {
            System.out.println("No departments available.");

            return;
        }

        for (int i = 0; i < college.departmentCount(); i++) {
            System.out.println((i + 1) + ". " + college.getDepartments()[i].getName());
        }
    }

    private static void displayCommitteeMembers(Committee committee) {
        if (committee.getMemberCount() == 0) {
            System.out.println("No members in this committee.");

            return;
        }

        for (int i = 0; i < committee.getMemberCount(); i++) {
            System.out.println((i + 1) + ". " + committee.getMembers()[i].getName());
        }
    }

    private static void addLecturer(Scanner scanner, College college) {
        System.out.print("Enter lecturer name: ");

        String name = scanner.nextLine();

        while (college.lecturerExists(name)) {
            System.out.println("A lecturer with this name already exists.");
            System.out.print("Enter another name: ");

            name = scanner.nextLine();
        }

        System.out.print("Enter ID: ");

        String id = scanner.nextLine();

        System.out.println("Insert Degree type: ");

        Degree degree = addDegree();


        System.out.print("Enter degree name: ");

        String degreeName = scanner.nextLine();

        System.out.print("Enter salary: ");
        boolean check = true;
        double salary = 0;
        while(check){
            try {
                salary = Double.parseDouble(scanner.nextLine());
                check = false;
            }
            catch (IllegalArgumentException e){
                System.out.println("Invalid input, try again:");
            }
            }

        Lecturer lecturer = new Lecturer(name, id, degree, degreeName, salary);

        System.out.print("Assign to department? (y/n): ");

        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            if (college.departmentCount() > 0) {
                System.out.println("Available departments:");

                displayDepartmentNames(college);

                System.out.print("Enter department name: ");

                String deptName = scanner.nextLine();

                Department dept = college.findDepartment(deptName);

                if (dept != null) {
                    lecturer.setDepartment(dept);
                    dept.addLecturer(lecturer);

                    System.out.println("Lecturer assigned to department: " + deptName);
                } else {
                    System.out.println("Department not found");
                }
            } else {
                System.out.println("No departments available");
            }
        }

        college.addLecturer(lecturer);

        System.out.println("Lecturer added");
    }

    private static void addCommittee(Scanner scanner, College college) {
        System.out.print("Enter committee name: ");

        String name = scanner.nextLine();

        while (college.committeeExists(name)) {
            System.out.println("A committee with this name already exists");
            System.out.print("Enter another name: ");

            name = scanner.nextLine();
        }

        System.out.println("Eligible chairpersons (PhD or Professor):");

        boolean hasEligible = displayEligibleChairpersons(college);

        if (!hasEligible) {
            System.out.println("No eligible chairpersons available. Add a lecturer with PhD or Professor degree");

            return;
        }

        System.out.print("Enter chairperson name: ");

        String chairpersonName = scanner.nextLine();
        try {
            Lecturer chairperson = college.findLecturer(chairpersonName);

            if (chairperson == null) {
                System.out.println("Lecturer not found");

                return;
            }

            if (chairperson.getDegree() != Degree.PHD && chairperson.getDegree() != Degree.PROFESSOR) {
                System.out.println("Chairperson must have PhD or Professor degree");

                return;
            }

            Committee committee = new Committee(name, chairperson);
            college.addCommittee(committee);
            chairperson.addCommittee(committee);

            System.out.println("Committee added successfully with " + chairpersonName + " as chairperson");
        } catch (Exception e) {
            System.out.println("The lecturer doesn't exist");
        }
    }


    private static void addMemberToCommittee(Scanner scanner, College college) {
        if (college.committeeCount() == 0) {
            System.out.println("No committees available");

            return;
        }

        System.out.println("Available committees:");

        displayCommitteeNames(college);

        System.out.print("Enter committee name: ");

        String committeeName = scanner.nextLine();

        Committee committee = null;
        try {
            committee = college.findCommittee(committeeName);
        }
        catch (NotExistException e) {
            System.out.println("Committee not found: ");
            return;
        }

        System.out.println("Available lecturers:");
        displayLecturerNames(college);
        System.out.print("Enter lecturer name: ");
        String lecturerName = scanner.nextLine();
        try {
            Lecturer lecturer = college.findLecturer(lecturerName);

            if (committee.getChairperson() == lecturer) {
                System.out.println("This lecturer is already the chairperson and cant be added as a member");
                return;
            }

            if (committee.isMember(lecturer)) {
                System.out.println("This lecturer is already a member of this committee.");
                return;
            }
            committee.addMember(lecturer);
            lecturer.addCommittee(committee);
            System.out.println("Member added to committee");
        }
        catch (NotExistException e) {
                System.out.print("The lecturer "+e.getMessage());
            }
        }


    private static void updateCommitteeChairperson(Scanner scanner, College college) {
        if (college.committeeCount() == 0) {
            System.out.println("No committees available");

            return;
        }

        System.out.println("Available committees:");

        displayCommitteeNames(college);

        System.out.print("Enter committee name: ");

        String committeeName = scanner.nextLine();

        Committee committee = college.findCommittee(committeeName);

        if (committee == null) {
            System.out.println("Committee not found");

            return;
        }

        System.out.println("Eligible chairpersons (PhD or Professor):");

        boolean hasEligible = displayEligibleChairpersons(college);

        if (!hasEligible) {
            System.out.println("No eligible chairpersons available");

            return;
        }

        System.out.print("Enter new chairperson name: ");

        String chairpersonName = scanner.nextLine();

        try {
            Lecturer newChairperson = college.findLecturer(chairpersonName);
            if (newChairperson.getDegree() != Degree.PHD && newChairperson.getDegree() != Degree.PROFESSOR) {
                System.out.println("Chairperson must have PhD or Professor degree");

                return;
            }

            Lecturer currentChairperson = committee.getChairperson();

            currentChairperson.removeCommittee(committee);

            if (committee.isMember(newChairperson)) {
                committee.removeMember(newChairperson);
            }

            committee.setChairperson(newChairperson);
            newChairperson.addCommittee(committee);

            System.out.println("Committee chairperson updated");
        } catch(Exception e) {
            System.out.println("Lecturer doesn't exist");
        }
    }

    private static void removeMemberFromCommittee(Scanner scanner, College college) {
        if (college.committeeCount() == 0) {
            System.out.println("No committees available");

            return;
        }

        System.out.println("Available committees:");

        displayCommitteeNames(college);

        System.out.print("Enter committee name: ");

        String committeeName = scanner.nextLine();

        Committee committee = college.findCommittee(committeeName);

        if (committee == null) {
            System.out.println("Committee not found");

            return;
        }

        if (committee.getMemberCount() == 0) {
            System.out.println("No members in this committee");

            return;
        }

        System.out.println("Committee members:");

        displayCommitteeMembers(committee);

        System.out.print("Enter member name to remove: ");
        String memberName = scanner.nextLine();

        try {
            Lecturer member = college.findLecturer(memberName);

            if (!committee.isMember(member)) {
                System.out.println("This lecturer is not a member of this committee");

                return;
            }

            committee.removeMember(member);
            member.removeCommittee(committee);

            System.out.println("Member removed from committee successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void addDepartment(Scanner scanner, College college) {
        System.out.print("Enter department name: ");

        String name = scanner.nextLine();

        while (college.departmentExists(name)) {
            System.out.println("A department with this name already exists");
            System.out.print("Enter a different name: ");

            name = scanner.nextLine();
        }

        System.out.print("Enter number of students: ");

        int studentCount = 0;
        boolean check = true;
        while(check) {
            try {
                studentCount = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number, try again");
            }
        }

        Department department = new Department(name, studentCount);
        college.addDepartment(department);

        System.out.println("Department added");
    }

    private static void showAverageSalary(College college) {
        double average = college.calculateAverageSalary();

        if (average > 0) {
            System.out.println("Average salary of all lecturers: " + average);
        } else {
            System.out.println("No lecturers available");
        }
    }
    private static Degree addDegree() {
        Scanner scanner = new Scanner(System.in);
        Degree degree;

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                degree = Degree.valueOf(input);
                return degree;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid degree. Please try again.");

            }
        }
    }

    private static void showDepartmentAverageSalary(Scanner scanner, College college) {
        if (college.departmentCount() == 0) {
            System.out.println("No departments available");

            return;
        }

        System.out.println("Available departments:");

        displayDepartmentNames(college);

        System.out.print("Enter department name: ");

        String deptName = scanner.nextLine();

        Department dept = college.findDepartment(deptName);

        if (dept == null) {
            System.out.println("Department not found");

            return;
        }

        double average = dept.calculateAverageSalary();

        if (average > 0) {
            System.out.println("Average salary in department " + deptName + ": " + average);
        } else {
            System.out.println("No lecturers in this department");
        }
    }
}