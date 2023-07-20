package InsuranceManagement;

import java.util.*;

public abstract class Account implements Comparable<Account> {
    enum AuthenticationStatus {SUCCESS, FAIL}
    private User user;
    private List<Insurance> insurances;
    private AuthenticationStatus status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public final void showUserInfo() {
        System.out.println("Account Info: " + "\n" +
                "Name: " + user.getFname() + "\n" +
                "Surname: " + user.getLname() + "\n" +
                "E-mail:" + user.getEmail() + "\n" +
                "Job:" + user.getJob() + "\n" +
                "Age: " + user.getAge() + "\n" +
                "Last Login: " + user.getLastlogin());
        for (Address address : user.getAddress()) {
            System.out.println(address.getAddress());
        }
    }

    public void login(String email, String pass) throws InvalidAuthenticationException {
        if (email.equals(getUser().getEmail()) && pass.equals(getUser().getPass())) {
            setStatus(AuthenticationStatus.SUCCESS);
            System.out.println("Login successful.");
        } else {
            setStatus(AuthenticationStatus.FAIL);
            throw new InvalidAuthenticationException("Invalid credentials!");
        }
    }

    public abstract void addAddress(String address);

    // public abstract void removeAddress(Address address);

    public void addInsurance(Insurance insurance) {
        insurance.calculate();
        this.getInsurances().add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return Objects.equals(user, account.user);
    }
}

class Individual extends Account {
    public Individual() {
        this.setStatus(AuthenticationStatus.FAIL);
        this.setInsurances(new ArrayList<>());
    }

    public Individual(User user) {
        this();
        this.setUser(user);
    }

    @Override
    public void addAddress(String address) {
        AddressManager.addAddress(this.getUser(), new HomeAddress(address));
    }
}

class Enterprise extends Account {
    public Enterprise() {
        this.setStatus(AuthenticationStatus.FAIL);
        this.setInsurances(new ArrayList<>());
    }

    public Enterprise(User user) {
        this();
        this.setUser(user);
    }

    @Override
    public void addAddress(String address) {
        AddressManager.addAddress(this.getUser(), new BusinessAddress(address));
    }
}