package CRS;

import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

        System.out.println("Welcome to the Cinema Reservation System!!\n (To exit type 'exit') \n");

        while (true) {
            Thread.sleep(3000);
            String prompt = getPrompt(newAccountController);
            System.out.println(prompt);
            displayOptions(newAccountController);

            String rep = scanner.nextLine();

            // LI
            String resCMD;
            if (rep.toUpperCase().equals(Actions.CA.toString())) {
                resCMD = newAccountUI.handleCommands(rep);
                System.out.println(resCMD);

                if (resCMD != null && !resCMD.equals("Unknown command.")) {
                    newAccountUI.handleInputs();
                }
            } else if (rep.toUpperCase().equals(Actions.LI.toString())
                    || rep.toUpperCase().equals(Actions.LO.toString())) {

                resCMD = loginAccountUI.handleCommands(rep);

                if (resCMD != null && !resCMD.equals("Unknown command.")) {
                    loginAccountUI.handleInputs();
                }
            }
        }
    }

    public static void displayOptions(NewAccountController newAccountController) {
        System.out.println("======== MENU ========");
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {

            str = "Enter one of the commands in the brackets:\n" +
                    "[CA] Create Account\n" +
                    "[LI] Login";
            System.out.println(str);
        } else {

            System.out.println("Enter on of the commands in brackets:\n" + 
                    "[LO] Logout");
        }
    }

    public static String getPrompt(NewAccountController newAccountController){

        if(!newAccountController.getAccount().checkLoggedIn()){
            return "";
        }
        return "LOGGED IN AS: " + newAccountController.getAccount().getUsername();
    }

}
