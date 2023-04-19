import entity.Account;
import handle.AccountHandle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        AccountHandle accountHandle = new AccountHandle();
        int n = 0;
        do {
            try {
                System.out.println("Nhập số lượng tài khoản ban đầu( phải có ít nhất 1 tài khoản): ");
                n = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Nhập số nguyên cơ mà");
            }
        }while (n<0);
        for (int i = 0; i < n; i++) {
            accountHandle.firstAcouts(scanner, accounts);
        }
        accountHandle.login(scanner, accounts);
    }
}