//               ATM Machine

package com.codsoft.atmmachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    
    public static ArrayList<BankAccount> l1 = new ArrayList<BankAccount>();
    
    public static void main(String[] args) {
    	//Creating predefined records(considering in order to use an atm machine, you have registered already.)
    	//use of ArrayList to store registered accounts
        BankAccount r1 = new BankAccount("rohan", 1000.0f, 9487);
        BankAccount r2 = new BankAccount("mohan", 2000.0f, 9142);
        BankAccount r3 = new BankAccount("rahul", 5000.0f, 8651);
        BankAccount r4 = new BankAccount("jatin", 4000.0f, 7983);

        l1.add(r1);
        l1.add(r2);
        l1.add(r3);
        l1.add(r4);
        Scanner scn = new Scanner(System.in);
        userLogin(scn);
        scn.close();
    }
    public static void userLogin(Scanner scn) {
    	System.out.println("User Log In ");
        System.out.print("Enter a userId:");
        
        String checkname = scn.next();
        System.out.print("Enter a Pin:");
        int checkpin = scn.nextInt();
        
        BankAccount account = authenticate(checkname, checkpin);
        
        if (account != null) {
            System.out.println("Welcome " + account.getuserId() + "!");
            menu(account, scn); // Pass the authenticated account to the menu
        } else {
            System.out.println("Invalid User!");
            userLogin(scn);
        }
    }

    public static BankAccount authenticate(String userId, int pin) {
        for (BankAccount e : l1) {
            if (e.getuserId().equalsIgnoreCase(userId) && e.getpin() == pin) {
                return e;
            }
        }
        return null;
    }
    
    public static void menu(BankAccount bankAccount, Scanner scn) {
        
        while (true) {
        	System.out.println("=================");
        	System.out.println("Options:");
            System.out.println("1. Check A/C Balance ");
            System.out.println("2. Withdraw Money ");
            System.out.println("3. Deposit Money ");
            System.out.println("4. Exit ");
            System.out.print("Enter your Choice: ");

            
            int UserChoice = scn.nextInt();
            
            if (UserChoice == 1) {
                bankAccount.checkBalance();
            } else if (UserChoice == 2) {
                withdrawMoney(bankAccount,scn);
            } else if (UserChoice == 3) {
                depositMoney(bankAccount,scn);
            } else if (UserChoice == 4) {
                System.out.println("Thank you for using ATM!");
            	System.out.println("=================");
                  userLogin(scn);
            } else {
                System.out.println("Enter a valid choice! ");
            }
        }
    }

    public static void withdrawMoney(BankAccount bankAccount, Scanner scn) {
        System.out.println("Enter the amount to be withdrawn: ");
        float amount = scn.nextFloat();

        if (bankAccount.withdrawMoney(amount)) {
            System.out.println("Money Withdrawn Successfully! ");
        } else {
            System.out.println("Insufficient Balance!!!");
        }
    }

    public static void depositMoney(BankAccount bankAccount, Scanner scn) {
        System.out.println("Enter the amount to be deposited: ");
        float depamount = scn.nextFloat();
        bankAccount.depositMoney(depamount);
        System.out.println("Money Deposited Successfully! ");

    }
}
