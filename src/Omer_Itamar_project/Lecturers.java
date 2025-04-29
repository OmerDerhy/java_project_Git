package Omer_Itamar_project;

import java.util.Objects;

public class Lecturers {
    private String name;
    private String Id;
    private Degree knowledge;
    private String name_degree;
    private double salary;
    private Committees[] committees;
    private String department;
    private int committeeSize = 0;

    public Lecturers() {
        this.committees = new Committees[1];
    }

    public Lecturers(String name, String id, Degree knowledge, String name_degree, double salary,String department) {
        this.name = name;
        Id = id;
        this.knowledge = knowledge;
        this.name_degree = name_degree;
        this.salary = salary;
        this.department = department;
        this.committees = new Committees[1];
    }
    public Lecturers(String name, String id, Degree knowledge, String name_degree, double salary) {
        this.name = name;
        Id = id;
        this.knowledge = knowledge;
        this.name_degree = name_degree;
        this.salary = salary;
        this.committees = new Committees[1];
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

    public Committees[] getCommittees() {
        return committees;
    }

    public void setCommittees(Committees[] committees) {
        this.committees = committees;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lecturers lecturers = (Lecturers) o;
        return Objects.equals(name, lecturers.name);
    }
    public String getCommittees_names(){
        String prompt="";
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
                ", Id='" + Id + '\'' +
                ", knowledge=" + knowledge +
                ", salary=" + salary +
                ", committees="+ prompt +
                ", department='" + department + '\'' +
                '}';
    }
}
