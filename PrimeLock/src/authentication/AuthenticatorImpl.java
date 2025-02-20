package authentication;

public class AuthenticatorImpl implements Authenticator {
    @Override
    public boolean login(Employee e) {
        Employee validEmp = new Employee("ABC3456789", "EEE6789", "Emp001", "asdfghjkl");

        boolean isValidId = e.getNationalId().equals(validEmp.getNationalId());
        boolean isValidPassNo = e.getPassportNo().equals(validEmp.getPassportNo());
        boolean isValidEmp = e.getEmployeeId().equals(validEmp.getEmployeeId());
        boolean isPswCorrect = e.getPassword().equals(validEmp.getPassword());

        return (isValidId || isValidPassNo) && isValidEmp && isPswCorrect;
    }
}
