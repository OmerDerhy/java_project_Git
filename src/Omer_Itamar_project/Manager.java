package Omer_Itamar_project;

public class Manager {
    private String Collage;
    private Lecturer[] lecturers ;
    private Committee[] committees;
    private Department[] departments;
    private int lecturerSize = 0;
    private int committeeSize = 0;
    private int departmentSize = 0;

    public Manager(String collage) {
        this.Collage = collage;
        this.lecturers = new Lecturer[1];
        this.committees = new Committee[1];
        this.departments = new Department[1];
    }

    public Department[] getDepartments() {
        return departments;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public int getLecturerSize() {
        return lecturerSize;
    }

    public boolean NameEqual(String Name) {
        for (int i = 0; i < lecturerSize; i++) {
            if (lecturers[i] != null && lecturers[i].getName().equals(Name)) {
                return false;
            }
        }
        return true;
    }
    public boolean committeesNameEqual(String name) {
        for (int i = 0; i < committeeSize; i++) {
            if (committees[i] != null && committees[i].getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
    public void addDepartment(String name,int students){
        if(departmentSize == departments.length) {
            departments = extendArray(departments);
        }
        departments[departmentSize] = new Department(name,students);
        departmentSize++;
    }

    public void addLecturer(Lecturer lecturer) {
        if (lecturerSize == lecturers.length){
            lecturers = extendArray(lecturers);
        }
        lecturers[lecturerSize] = lecturer;
        lecturerSize++;
    }
    public boolean ableLeader(String leaderName){
        for(int i=0;i<lecturerSize;i++) {
            if (lecturers[i].getName().equals(leaderName)) {
                if (lecturers[i].getKnowledge() == Degree.PHD || lecturers[i].getKnowledge() == Degree.PROFESSOR) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    public void setLeader(int lec_index, int com_index){
        committees[com_index].setLeader(lecturers[lec_index]);
    }

    public void addCommittee(String name, String leaderName) {
        for(int i=0;i<lecturerSize;i++) {
            if (lecturers[i].getName().equals(leaderName)) {
                if (committeeSize == committees.length){
                    committees = extendArray(committees);
                }
                committees[committeeSize] = new Committee(name, lecturers[i]);
                committeeSize++;
            }
        }
    }
    public int FindLecturer(String Name){
        for(int i =0;i<lecturerSize;i++){
            if(lecturers[i].getName().equals(Name)){
                return i;
            }
        }
        return -1;
    }
    public int FindCommittee(String name){
        for(int i =0;i<committeeSize;i++){
            if(committees[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void addLecturerToCommitte(int lec_index, int com_index) {
        Committee committee = committees[com_index];
        Lecturer lecturer = lecturers[lec_index];

        if (committee.getLecturerSize() >= committee.getLecturers().length) {
            Lecturer[] extendedLecturers = extendArray(committee.getLecturers());
            committee.setLecturers(extendedLecturers);
        }
        committee.getLecturers()[committee.getLecturerSize()] = lecturer;
        committee.setLecturerSize(committee.getLecturerSize() + 1);
        if (lecturer.getCommitteeSize() >= lecturer.getCommittees().length) {
            Committee[] extendedCommittees = extendArray(lecturer.getCommittees());
            lecturer.setCommittees(extendedCommittees);
        }
        lecturer.getCommittees()[lecturer.getCommitteeSize()] = committee;
        lecturer.setCommitteeSize(lecturer.getCommitteeSize() + 1);
    }

    public Lecturer[] helperRemoveLecturerFromCommitte(String Name, String comm) {
        int com_index = FindCommittee(comm);
        int lec_index = FindLecturer(Name);
        Lecturer[] oldLecturers = committees[com_index].getLecturers();
        int size = committees[com_index].getLecturerSize();
        Lecturer[] temp = new Lecturer[size - 1];
        int Index = 0;
        for (int i = 0; i < size; i++) {
            if (!oldLecturers[i].getName().equals(Name)) {
                temp[Index] = oldLecturers[i];
                Index++;
            }
        }
        return temp;
    }
    public Committee[] helperRemoveCommitteeFromLecturer(String Name, String comm){
        int lec_index = FindLecturer(Name);
        Committee[] temp = new Committee[lecturers[lec_index].getCommitteeSize()-1];
        Committee[] oldCommittee =  lecturers[lec_index].getCommittees();
        int size =lecturers[lec_index].getCommitteeSize();
        int Index = 0;
        for(int i=0;i<size;i++){
            if(!oldCommittee[i].getName().equals(comm)){
                temp[Index] = oldCommittee[i];
                Index++;
            }
        }
        return temp;
    }
    public double getAvgSalary(){
        double avg =0;
        for(int i=0;i< lecturerSize;i++){
            avg = lecturers[i].getSalary() + avg;
        }
        avg = avg/(lecturerSize);
        return avg;
    }
    public double getAvgSalary(int index_com) {
        double avg = 0;
        for(int i=0;i<committees[index_com].getLecturerSize();i++){
            avg = avg + committees[index_com].getLecturers()[i].getSalary();
        }
        avg = avg / committees[index_com].getLecturerSize();
        return avg;
    }

    public void RemoveLecturerFromCommittee(String Name, String comm){
        int com_index = FindCommittee(comm);
        int lec_index = FindLecturer(Name);
        Lecturer[] newLecturers = helperRemoveLecturerFromCommitte(Name, comm);
        Committee[] newCommittee = helperRemoveCommitteeFromLecturer(Name,comm);
        committees[com_index].setLecturers(newLecturers);
        committees[com_index].setLecturerSize(committees[com_index].getLecturerSize()-1);
        lecturers[lec_index].setCommittees(newCommittee);
        lecturers[lec_index].setCommitteeSize(lecturers[lec_index].getCommitteeSize()-1);
    }
    public int FindDepartment(String name){
        for(int i =0;i<departmentSize;i++){
            if(departments[i].getDepartment_name().equals(name)){
                return i;            }
        }
        return -1;
    }
    public boolean IsLeader(int lec_index,int com_index){
        if(committees[com_index].getLeader().equals(lecturers[lec_index])){
            return true;
        }
        return false;
    }
    public void AddlecturerToDepartment(int dep_index,int lec_index){
        Department department = departments[dep_index];
        Lecturer lecturer = lecturers[lec_index];
        if (department.getLecturerSize() >= department.getLecturers().length) {
            Lecturer[] extendedLecturers = extendArray(department.getLecturers());
            department.setLecturers(extendedLecturers);
        }
        department.getLecturers()[department.getLecturerSize()] = lecturer;
        department.setLecturerSize(department.getLecturerSize() + 1);
    }
    public boolean lecturerInCommittee(int lec_index, int com_index ){
        Committee committee = committees[com_index];
        Lecturer lecturer = lecturers[lec_index];
        for(int i =0; i<committee.getLecturerSize();i++){
            if(committee.getLecturers()[i] == lecturer){
                return true;
            }
        }
        return false;
    }

    public void displayAll(Object[] items) {
        for (Object item : items) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }
    public Lecturer[] extendArray(Lecturer [] array){
        Lecturer [] temp = new Lecturer[array.length*2];
        for(int i=0; i<array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }
    public Committee[] extendArray(Committee [] array){
        Committee [] temp = new Committee[array.length*2];
        for(int i=0; i<array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }
    public Department[] extendArray(Department [] array){
        Department [] temp = new Department[array.length*2];
        for(int i=0; i<array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }
    public boolean isEqual(Lecturer[] array,String value){
        for (int i=0; i<array.length;i++){
            if (array[i]!= null && array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
