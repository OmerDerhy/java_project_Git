package Omer_Itamar_project;

import java.util.Objects;

public class Lecturer {
    private String name;
    private String Id;
    private Degree knowledge;
    private String name_degree;
    private double salary;
    private Committee[] committees;
    private Department department;
    private int committeeSize = 0;

    public Lecturer() {
        this.committees = new Committee[1];
    }

    public Lecturer(String name, String id, Degree knowledge, String name_degree, double salary,Department department) {
        this.name = name;
        Id = id;
        this.knowledge = knowledge;
        this.name_degree = name_degree;
        this.salary = salary;
        this.department = department;
        this.committees = new Committee[1];
    }
    public Lecturer(String name, String id, Degree knowledge, String name_degree, double salary) {
        this.name = name;
        Id = id;
        this.knowledge = knowledge;
        this.name_degree = name_degree;
        this.salary = salary;
        this.committees = new Committee[1];
    }

    public int getCommitteeSize() {
        return committeeSize;
    }

    public void setCommitteeSize(int committeeSize) {
        this.committeeSize = committeeSize;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Degree getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Degree knowledge) {
        this.knowledge = knowledge;
    }

    public String getName_degree() {
        return name_degree;
    }

    public void setName_degree(String name_degree) {
        this.name_degree = name_degree;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public void setCommittees(Committee[] committees) {
        this.committees = committees;
    }

    public Department getDepartment() {
        return department;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturers = (Lecturer) o;
        return Objects.equals(name, lecturers.name);
    }
    public String getCommittees_names(){
        String prompt="";
        if (committeeSize==0){
            return "null";
        }
        for(int i=0;i<committeeSize;i++){
            if(committeeSize-1 == i){
                prompt = prompt + committees[i].getName();
            }
            else {
                prompt= prompt + committees[i].getName() + ", ";
            }
        }
        return prompt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Id);
    }

    @Override
    public String toString() {
        String prompt = getCommittees_names();
        return "Lecturers{" +
                "name='" + name + '\'' +
                ", knowledge=" + knowledge +
                ", salary=" + salary +
                ", committees="+ prompt +
                ", department='" + department+ '\'' +
                '}';
    }
}
