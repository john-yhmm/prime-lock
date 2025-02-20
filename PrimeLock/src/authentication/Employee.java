package authentication;

public class Employee extends User {
    private String employeeId;

    public Employee(String nationalId, String passportNo, String password, String employeeId) {
        super(nationalId, passportNo, password);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
