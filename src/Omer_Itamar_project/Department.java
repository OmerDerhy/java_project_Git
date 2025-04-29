package Omer_Itamar_project;

import java.util.Objects;

public class Department {
    private String department_name;
    private Lecturer[] lecturers;
    private int num_of_students;
    private int lecturerSize = 0;

    public Department(String department_name, int num_of_students) {
        this.department_name = department_name;
        this.num_of_students = num_of_students;
        this.lecturers= new Lecturer[1];
    }


    public int getLecturerSize() {
        return lecturerSize;
    }

    public void setLecturerSize(int lecturerSize) {
        this.lecturerSize = lecturerSize;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    public int getNum_of_students() {
        return num_of_students;
    }

    public void setNum_of_students(int num_of_students) {
        this.num_of_students = num_of_students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(department_name, that.department_name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(department_name);
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_name='" + department_name + '\'' +
                ", num_of_students=" + num_of_students +
                '}';
    }
}
