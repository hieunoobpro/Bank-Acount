package handle;

import entity.Account;
import view.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountHandle {
   /* hien thi login*/
    public void login(Scanner scanner, ArrayList<Account> arrayList){
        System.out.println("       Dang nhap     ");
        System.out.println("----------------------");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        Account account = new Account();
        Menu menu = new Menu();
        for (Account account1 : arrayList) {
            if (AccountHandle.isEmailTaken(email, arrayList)&&AccountHandle.isUsernameTaken(username,arrayList)) {
                try {
                    int choice = menu.menuInput(scanner);
                    if (choice == 1) {
                        System.out.println("Nhap so tien muon them");
                        double addMoney = scanner.nextDouble();
                        account.recharge(addMoney);
                        login(scanner,arrayList);
                    } else if (choice == 2) {
                        System.out.println("Nhap email muon doi");
                        String changeEmail = scanner.nextLine();
                        account.changeEmail(changeEmail);
                        login(scanner, arrayList);
                    } else if (choice == 3) {
                        System.out.println(account1.displayInfo());
                    } else {
                        System.out.println("Mhap so tu 1 den 3 thoi");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Mhap so tu 1 den 3 thoi");
                    login(scanner, arrayList);
                }
            }
            else{
                System.out.println("Username hoc Email sai");
                login(scanner, arrayList);
            }
        }
    }
/*    kiem tra su ton tai cua email*/
    static boolean isEmailTaken(String email, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
  /*  tao danh sach dau tien*/
    public ArrayList<Account> firstAcouts (Scanner scanner, ArrayList<Account> accounts) {
        Account account = new Account();
        boolean check = false;
            System.out.println("Nhap Username: ");
            String username = scanner.nextLine();
            account.setName(username);
        do {
            System.out.println("Nhap email: ");
            String email = scanner.nextLine();
            if (AccountHandle.isValidEmail(email) && !AccountHandle.isEmailTaken(email, accounts)) {
                account.setEmail(email);
                check=true;
            } else {
                System.out.println("Emmail da ton tai hoac Email sai cu phap");
            }
        }while (!check);
        do {
            System.out.println("Nhap AcountNumber");
            String accountNumber = scanner.nextLine();
             if (AccountHandle.isValidAcountNumber(accountNumber)){
                 account.setAccountNumber(accountNumber);
                 check = false;
             }
             else {
                 System.out.println("Nhap Acount number lai");
                 check = true;
             }
        }while (check == true);
            System.out.println("Nhap so tien trong tai khoan");
        double money = Double.parseDouble(scanner.nextLine());
        account.setAccountBalance(money);
        accounts.add(account);
        return accounts;
    }
    /*kiem tra dieu kien cua email*/
    static boolean isValidEmail(String email) {
        String regex = "^[a-z][a-zA-Z0-9\\-_]+@[a-zA-z]{2,}(\\.[a-zA-Z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
   /* kiem tra dieu kien cua accountNumber*/
    static boolean isValidAcountNumber(String acountNumber) {
        String regex = "^[0-9]{13}+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(acountNumber);
        return matcher.matches();
    }
 /*   kiem tra su ton tai cua usename*/
    static boolean isUsernameTaken(String username, ArrayList<Account> userList) {
        for (Account user : userList) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
