package InsuranceManagement;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Account account = accountManager.login();
        System.out.println("Welcome! " + account.getUser().getFname() + " " + account.getUser().getLname());
        account.addAddress("Sarıyer / İstanbul");
        account.addAddress("Antakya / Hatay");
        account.addInsurance(new CarInsurance());
        account.showUserInfo();
    }
}