package CRS;

public class Account {
    private static StoredFiles accounts = new StoredFiles("accounts.json");

    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;

    public Account() {
        this.username = null;
        this.loggedIn = false;
        this.password = null;
        this.email = null;

    }

    public Account(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean checkLoggedIn() {
        return loggedIn;
    }

    public void setAccount(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = true;
    }

    public void logout() {
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }

    public static StoredFiles getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}