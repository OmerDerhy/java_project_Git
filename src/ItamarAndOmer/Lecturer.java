package ItamarAndOmer;

public class Lecturer {
    private String name;
    private String id;
    private Degree degree;
    private String degreeTitle;
    private double salary;
    private Department department;
    private Committee[] committees;
    private int committeeCount;

    public Lecturer(String name, String id, Degree degree, String degreeTitle, double salary) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.degreeTitle = degreeTitle;
        this.salary = salary;
        this.department = null;
        this.committees = new Committee[2];
        this.committeeCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public void removeCommittee(Committee committee) {
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i] == committee) {
                for (int j = i; j < committeeCount - 1; j++) {
                    committees[j] = committees[j + 1];
                }

                committees[--committeeCount] = null;

                return;
            }
        }
    }

    public boolean isInCommittee(Committee committee) {
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i] == committee) {
                return true;
            }
        }
        
        return false;
    }

    public String getDepartmentName() {
        return department == null ? "No department" : department.getName();
    }

    public String getCommitteesList() {
        if (committeeCount == 0) {
            return "No committees";
        }

        String list = "";
        
        for (int i = 0; i < committeeCount; i++) {
            list += committees[i].getName();
            
            if (i < committeeCount - 1) {
                list += ", ";
            }
        }
        
        return list;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nID: " + id +
                "\nDegree: " + degree +
                "\nDegree Title: " + degreeTitle +
                "\nSalary: " + salary +
                "\nDepartment: " + getDepartmentName() +
                "\nCommittees: " + getCommitteesList();
    }
}