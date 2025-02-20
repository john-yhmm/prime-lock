package authentication;

public abstract class User {
    private String nationalId;
    private String passportNo;
    private String password;

    public User() {

    }

    public User(String nationalId, String passportNo, String password) {
        this.nationalId = nationalId;
        this.passportNo = passportNo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
