package Omer_Itamar_project;

import java.util.Arrays;

public class Committees {
    private String name;
    private Lecturers[] lecturers;
    private Lecturers leader = new Lecturers();
    private int lecturerSize = 0;

    public Committees(String name, Lecturers[] lecturers, Lecturers leader, int lecturersSize) {
        this.name = name;
        this.lecturers = new Lecturers[1];
        this.leader = leader;
    }

    public Committees(String name, Lecturers leader) {
        this.name = name;
        this.leader = leader;
        this.lecturers = new Lecturers[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturers[] getLecturers() {
        return lecturers;
    }


    public void setLecturers(Lecturers[] lecturers) {
        this.lecturers = lecturers;
    }

    public Lecturers getLeader() {
        return leader;
    }

    public void setLeader(Lecturers leader) {
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
