package authentication;

public class User {
    private String nationalId;
    private String passportNo;
    private String employeeId;
    private String password;

    public User() {

    }

    public User(String nationalId, String passportNo, String employeeId, String password) {
        this.nationalId = nationalId;
        this.passportNo = passportNo;
        this.employeeId = employeeId;
        this.password = password;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
