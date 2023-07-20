package InsuranceManagement;

import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
        accounts.add(new Enterprise(new User("Melisa","Çevik","melisacevik@hotmail.com","123456m","Developer",24)));
        accounts.add(new Individual(new User("Çağrı","Sabancı","cagrisabanci@hotmail.com","123456c","Developer",25)));
        accounts.add(new Individual(new User("Portakal","Çitos","portakalkalpcitos@hotmail.com","123456k","Kedi",1)));
    }
    public Account login() {
        String[] infos = getLoginInfos();
        Account tempAccount = null;

        for (Account account : accounts) {
            if (account.getUser().getEmail().equals(infos[0])) {
                tempAccount = account;
                break;
            }
        }
        if (tempAccount != null) {
            try {
                tempAccount.login(infos[0], infos[1]);
            } catch (InvalidAuthenticationException e) {
                throw new RuntimeException(e);
            }
        }
        return tempAccount;
    }

    public String[] getLoginInfos() {
        String[] infoLogin = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your credentials to log in:");
        System.out.print("E-mail: ");
        infoLogin[0] = scanner.nextLine();
        System.out.print("Password: ");
        infoLogin[1] = scanner.nextLine();
        scanner.close();
        return infoLogin;
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }
}