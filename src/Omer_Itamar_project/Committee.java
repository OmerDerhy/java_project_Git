package Omer_Itamar_project;

import java.util.Arrays;

public class Committee {
    private String name;
    private Lecturer[] lecturers;
    private Lecturer leader = new Lecturer();
    private int lecturerSize = 0;


    public Committee(String name, Lecturer leader) {
        this.name = name;
        this.leader = leader;
        this.lecturers = new Lecturer[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }


    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    public Lecturer getLeader() {
        return leader;
    }

    public void setLeader(Lecturer leader) {
        this.leader = leader;
    }

    public int getLecturerSize() {
        return lecturerSize;
    }

    public void setLecturerSize(int lecturerSize) {
        this.lecturerSize = lecturerSize;
    }

    @Override
    public String toString() {
        return "Committees{" +
                "name='" + name + '\'' +
                ", lecturers=" + Arrays.toString(lecturers) +
                ", leader=" + leader.getName() +
                '}';
    }
}
