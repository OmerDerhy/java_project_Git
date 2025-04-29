package ItamarAndOmer;

import java.io.IOException;
import java.util.NoSuchElementException;

public class College {
    private String name;
    private Lecturer[] lecturers;
    private int lecturerCount;
    private Committee[] committees;
    private int committeeCount;
    private Department[] departments;
    private int departmentCount;

    public College(String name) {
        this.name = name;
        this.lecturers = new Lecturer[2];
        this.lecturerCount = 0;
        this.committees = new Committee[2];
        this.committeeCount = 0;
        this.departments = new Department[2];
        this.departmentCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addLecturer(Lecturer lecturer) {
        if (lecturerCount == lecturers.length) {
            Lecturer[] newLecturers = new Lecturer[lecturers.length * 2];

            for (int i = 0; i < lecturerCount; i++) {
                newLecturers[i] = lecturers[i];
            }

            lecturers = newLecturers;
        }

        lecturers[lecturerCount++] = lecturer;
    }

    public boolean lecturerExists(String name) {
        for (int i = 0; i < lecturerCount; i++) {
            if (lecturers[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public Lecturer findLecturer(String name) throws NotExistException {
        for (int i = 0; i < lecturerCount; i++) {
            if (lecturers[i].getName().equals(name)) {
                return lecturers[i];
            }
        }
        throw new NotExistException();
    }

    public void addCommittee(Committee committee) {
        if (committeeCount == committees.length) {
            Committee[] newCommittees = new Committee[committees.length * 2];

            for (int i = 0; i < committeeCount; i++) {
                newCommittees[i] = committees[i];
            }

            committees = newCommittees;
        }

        committees[committeeCount++] = committee;
    }

    public boolean committeeExists(String name) {
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public Committee findCommittee(String name) throws NotExistException{
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i].getName().equals(name)) {
                return committees[i];
            }
        }

        throw new NotExistException();
    }

    public int committeeCount() {
        return committeeCount;
    }

    public void addDepartment(Department department) {
        if (departmentCount == departments.length) {
            Department[] newDepartments = new Department[departments.length * 2];

            for (int i = 0; i < departmentCount; i++) {
                newDepartments[i] = departments[i];
            }

            departments = newDepartments;
        }

        departments[departmentCount++] = department;
    }

    public boolean departmentExists(String name) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public Department findDepartment(String name) {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i].getName().equals(name)) {
                return departments[i];
            }
        }

        return null;
    }

    public int departmentCount() {
        return departmentCount;
    }

    public double calculateAverageSalary() {
        if (lecturerCount == 0) {
            return 0;
        }

        double sum = 0;

        for (int i = 0; i < lecturerCount; i++) {
            sum += lecturers[i].getSalary();
        }

        return sum / lecturerCount;
    }

    public Lecturer[] getLecturers() {
        Lecturer[] result = new Lecturer[lecturerCount];

        for (int i = 0; i < lecturerCount; i++) {
            result[i] = lecturers[i];
        }

        return result;
    }

    public int getLecturerCount() {
        return lecturerCount;
    }

    public Committee[] getCommittees() {
        Committee[] result = new Committee[committeeCount];

        for (int i = 0; i < committeeCount; i++) {
            result[i] = committees[i];
        }

        return result;
    }

    public Department[] getDepartments() {
        Department[] result = new Department[departmentCount];

        for (int i = 0; i < departmentCount; i++) {
            result[i] = departments[i];
        }

        return result;
    }
}