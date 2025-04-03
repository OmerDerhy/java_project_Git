package parkingLot;
import java.util.Objects;
public class employee {
    private int id;
    private String fullName;
    private String userName;
    private String password;

    public employee(int id, String fullName, String userName, String password) {
        setId(id);
        setFullName(fullName);
        setPassword(password);
        setUserName(userName);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}



