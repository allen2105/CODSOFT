package com.codsoft.atmmachine;

public class BankAccount {
	String userId;
    Float balance;
    int pin;
    
    public String getuserId() {
 	   return userId;
    }
    
    public Float getbalance() {
 	   return balance;
    }
    
    public int getpin() {
 	   return pin;
    }
    public BankAccount(float initialBalance) {
        this.balance = initialBalance;
    }
    
    public void checkBalance() {
		System.out.println("Balance: " + balance);
	}
	
    public boolean withdrawMoney(float amount) {
        if (amount > balance) {
            return false;
        } else {
            balance = balance - amount;
            return true;
        }
    }
	
    public void depositMoney(float amount) {
        balance = balance + amount;
    }
    
    public BankAccount(String userId, Float balance, int pin) {
    	super();
 	   this.userId=userId;
 	   this.balance=balance;
 	   this.pin=pin;
    }
}
