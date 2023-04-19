package entity;

import service.IAcount;

import java.util.Scanner;

public class Account implements IAcount {
    private String name;
    private String accountNumber;
    private String email;
    private double accountBalance;

    public Account() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmil() {
        return email;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    @Override
    /* them tien vao tai khoan*/
    public double recharge(Double add) {
        System.out.println("Thanh cong");
        return add + accountBalance;
    }
    @Override
    /* doi email*/
    public String changeEmail(String emil) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap email muon doi");
        String reEmail = scanner.nextLine();
        return reEmail;
    }


    @Override
/*    hien thi thong tin*/
    public String displayInfo() {
        return getName()+ "\n"+accountBalance+"\n"+email+"\n"+accountBalance;
    }
}
