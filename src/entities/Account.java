/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import exceptions.BusinessException;

/**
 *
 * @author Gabriel Augusto
 */
public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        checkAmount(balance);
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }
    
    public void deposit(Double amount) {
        checkAmount(amount);
        checkProcess(amount);
        balance += amount;
    }
    
    public void withdraw(Double amount) {
        checkAmount(amount);
        checkProcess(amount);
        balance -= amount;
    }
    
    private void checkAmount(Double amount) {
        if(amount < 0.0)
            throw new BusinessException("Balance need to be positive amount");
        
    }
    private void checkProcess(Double amount) {
        if(amount > balance)
            throw new BusinessException("Non sufficient funds to withdraw");
        if(amount > withDrawLimit)
            throw new BusinessException("The amount exceeds withdraw limit.");
    }

    @Override
    public String toString() {
        /*
        return "Room " + roomNumber + ", check-in: " 
                + sdf.format(checkIn) + ", check-out: " 
                + sdf.format(checkOut) + ", duration: " 
                + duration() + " nights";*/
        return "Account: " + number + ", "
            + "Holder: " + holder + ", "
            + "Balance: " + balance + ", "
            + "Withdraw limit: " + withDrawLimit;
    }
    
    
}
