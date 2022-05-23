package CRS;

import java.util.ArrayList;
import java.util.List;

public class NewAccountController {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public NewAccountController(Account account) {
        this.account = account;
    }
    public void createAccount(String username, Integer password, String email) {
        List<Object> listCheck;
        
        listCheck = accountValid(username, email);
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1));
        } else {
            Account.getAccounts().update(username, password, email);// memory
            Account.getAccounts().write();
            System.out.println(listCheck.get(1));
        }
        // if(!valid){
        // /
        // }else{
        // tao tai khoan => CSDL
        // }
    }
    public static List<Object> accountValid(String username, String email) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        index = Account.getAccounts().search("un", username);
        if (index != -1) {
            list.add(false);// 0
            list.add("[USERNAME EXISTS] An user with that username already exists.");// 1
            return list;
        }
        index = Account.getAccounts().search("email", email);
        if (index != -1) {
            list.add(false);
            list.add("[EMAIL EXISTS] A mail with that email already exists.");
            return list;
        }
        if (index == -1) {
            list.add(true);
            list.add("[ACCOUNT_CREATED] An account has been created.");
        }
        return list;
    }
    
}
