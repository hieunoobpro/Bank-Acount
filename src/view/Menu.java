package view;

import java.util.Scanner;

public class Menu {
    public int menuInput(Scanner scanner){
        System.out.println("Nhap lua chon cua ban: ");
        System.out.println("1. Nap tien");
        System.out.println("2. Doi mat khau");
        System.out.println("3. Xem thong tin tai khoan");
        return scanner.nextInt();
    }
}
