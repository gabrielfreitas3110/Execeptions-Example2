/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Account;
import exceptions.BusinessException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Gabriel Augusto
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account acc = null;    
        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        try {
            acc = new Account(number,holder,balance,withdrawLimit);
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
            System.out.println("New balance: " + acc.getBalance());
        } catch(BusinessException e) {
            System.out.println("Withdraw error: " + e.getMessage());
    
        } catch(RuntimeException e) {
            System.out.println("Unexpected Error.");
        } 
        System.out.println();
        System.out.println(acc);
        sc.close();
    }
}
