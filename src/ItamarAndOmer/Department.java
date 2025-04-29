package ItamarAndOmer;

public class Department {
    private String name;
    private int studentCount;
    private Lecturer[] lecturers;
    private int lecturerCount;

    public Department(String name, int studentCount) {
        this.name = name;
        this.studentCount = studentCount;
        this.lecturers = new Lecturer[2];
        this.lecturerCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
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

    public void removeLecturer(Lecturer lecturer) {
        for (int i = 0; i < lecturerCount; i++) {
            if (lecturers[i] == lecturer) {
                for (int j = i; j < lecturerCount - 1; j++) {
                    lecturers[j] = lecturers[j + 1];
                }

                lecturers[--lecturerCount] = null;

                return;
            }
        }
    }

    public int getLecturerCount() {
        return lecturerCount;
    }

    public Lecturer[] getLecturers() {
        Lecturer[] result = new Lecturer[lecturerCount];

        for (int i = 0; i < lecturerCount; i++) {
            result[i] = lecturers[i];
        }

        return result;
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

    @Override
    public String toString() {
        return "Department: " + name + "\nStudent Count: " + studentCount + "\nLecturer Count: " + lecturerCount;
    }
}