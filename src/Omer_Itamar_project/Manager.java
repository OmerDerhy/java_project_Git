package Omer_Itamar_project;

public class Manager {
    private String Collage;
    private Lecturers[] lecturers ;
    private Committees[] committees;
    private Department[] departments;
    private int lecturerSize = 0;
    private int committeeSize = 0;
    private int departmentSize = 0;

    public Manager(String collage) {
        this.Collage = collage;
        this.lecturers = new Lecturers[1];
        this.committees = new Committees[1];
        this.departments = new Department[1];
    }

    public boolean IdEqual(String Id) {
        for (int i = 0; i < lecturerSize; i++) {
            if (lecturers[i] != null && lecturers[i].getId().equals(Id)) {
                return false;
            }
        }
        return true;
    }
    public boolean committees_name_Equal(String name) {
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

    public void addLecturer(Lecturers lecturer) {
        if (lecturerSize == lecturers.length){
            lecturers = extendArray(lecturers);
        }
        lecturers[lecturerSize] = new Lecturers(lecturer.getName(), lecturer.getId(), lecturer.getKnowledge(), lecturer.getName_degree(), lecturer.getSalary());
        lecturerSize++;
    }
    public boolean able_Leader(String leader_ID){
        for(int i=0;i<lecturerSize;i++) {


            if (lecturers[i].getId().equals(leader_ID)) {
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
    public void change_leader(String id, String com_name){
        int com_index = Find_committee(com_name);
        int lec_index = Find_Lecturer(id);
        committees[com_index].setLeader(lecturers[lec_index]);
    }

    public void addCommittee(String name, String leader_ID) {
        for(int i=0;i<lecturerSize;i++) {
            if (lecturers[i].getId().equals(leader_ID)) {
                if (committeeSize == committees.length){
                    committees = extendArray(committees);
                }
                committees[committeeSize] = new Committees(name, lecturers[i]);
                committeeSize++;
            }
        }
    }
    public int Find_Lecturer(String ID){
        for(int i =0;i<lecturerSize;i++){
            if(lecturers[i].getId().equals(ID)){
                return i;
            }
        }
        return -1;
    }
    public int Find_committee(String name){
        for(int i =0;i<committeeSize;i++){
            if(committees[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void add_lecturer_to_committe(int lec_index, int com_index) {
        Committees committee = committees[com_index];
        Lecturers lecturer = lecturers[lec_index];

        if (committee.getLecturerSize() >= committee.getLecturers().length) {
            Lecturers[] extendedLecturers = extendArray(committee.getLecturers());
            committee.setLecturers(extendedLecturers);
        }
        committee.getLecturers()[committee.getLecturerSize()] = lecturer;
        committee.setLecturerSize(committee.getLecturerSize() + 1);
        if (lecturer.getCommitteeSize() >= lecturer.getCommittees().length) {
            Committees[] extendedCommittees = extendArray(lecturer.getCommittees());
            lecturer.setCommittees(extendedCommittees);
        }
        lecturer.getCommittees()[lecturer.getCommitteeSize()] = committee;
        lecturer.setCommitteeSize(lecturer.getCommitteeSize() + 1);
    }

    public Lecturers[] helper_remove_lecturer_from_committe(String ID, String comm) {
        int com_index = Find_committee(comm);

        Lecturers[] oldLecturers = committees[com_index].getLecturers();
        int size = committees[com_index].getLecturerSize();

        Lecturers[] temp = new Lecturers[size - 1];
        int tempIndex = 0;

        for (int i = 0; i < size; i++) {
            if (!oldLecturers[i].getId().equals(ID)) {
                temp[tempIndex] = oldLecturers[i];
                tempIndex++;
            }
        }
        return temp;
    }
    public double get_avg_salary(){
        double avg =0;
        for(int i=0;i< lecturerSize;i++){
            avg = lecturers[i].getSalary() + avg;
        }
        avg = avg/(lecturerSize);
        return avg;
    }
    public double get_avg_salary(int index_com) {
        double avg = 0;
        for(int i=0;i<committees[index_com].getLecturerSize();i++){
            avg = avg + committees[index_com].getLecturers()[i].getSalary();
        }
        avg = avg / committees[index_com].getLecturerSize();
        return avg;
    }

    public void remove_lecturer_from_committee(String ID, String comm){
        int com_index = Find_committee(comm);
        Lecturers[] newLecturers = helper_remove_lecturer_from_committe(ID, comm);
        committees[com_index].setLecturers(newLecturers);
    }
    public int Find_Department(String name){
        for(int i =0;i<departmentSize;i++){
            if(departments[i].getDepartment_name().equals(name)){
                return i;            }
        }
        return -1;
    }
    public boolean is_leader(int lec_index,int com_index){
        if(committees[com_index].getLeader().equals(lecturers[lec_index])){
            return true;
        }
        return false;
    }
    public void add_lecturer_to_department(int dep_index,int lec_index){
        Department department = departments[dep_index];
        Lecturers lecturer = lecturers[lec_index];
        if (department.getLecturerSize() >= department.getLecturers().length) {
            Lecturers[] extendedLecturers = extendArray(department.getLecturers());
            department.setLecturers(extendedLecturers);
        }
        department.getLecturers()[department.getLecturerSize()] = lecturer;
        department.setLecturerSize(department.getLecturerSize() + 1);
    }

    public void displayLecturers() {
        for (int i = 0; i < lecturerSize; i++) {
            System.out.println(lecturers[i].toString());
        }
    }
    public void displayCommittees() {
        for (int i = 0; i < committeeSize; i++) {
            System.out.println(committees[i].toString());
        }
    }
    public void displayDepartments() {
        for (int i = 0; i < departmentSize; i++) {
            System.out.println(departments[i].toString());
        }
    }
    public Lecturers[] extendArray(Lecturers [] array){
        Lecturers [] temp = new Lecturers[array.length*2];
        for(int i=0; i<array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }
    public Committees[] extendArray(Committees [] array){
        Committees [] temp = new Committees[array.length*2];
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
    public boolean isEqual(Lecturers[] array,String value){
        for (int i=0; i<array.length;i++){
            if (array[i]!= null && array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
