package project1;

import java.util.Scanner;

class Bank {
    private String Acno;
    private String Name;
    private long Balance;

    Scanner BANK = new Scanner(System.in);

  
    void openAccount() {
        System.out.print("Enter Account No: ");
        Acno = BANK.next();
        System.out.print("Enter Name: ");
        Name = BANK.next();
        System.out.print("Enter Balance: ");
        Balance = BANK.nextLong();
    }

 
    void showAccount() {
        System.out.println("Account number: "+Acno +"\n"+"Name: "+ Name+"\n"+"Balance: "+ Balance+"\n");
    }

    
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = BANK.nextLong();
        Balance = Balance + amt;
    }

    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = BANK.nextLong();
        if (Balance >= amt) {
            Balance = Balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

   
    boolean search(String acn) {
        if (Acno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankManagment {
    public static void main(String arg[]) {
        Scanner BANK = new Scanner(System.in);

       
        System.out.print("Give number of accounts u want to create : ");
        int n = BANK.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

       
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
                System.out.println("Ur Choice :"); ch = BANK.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = BANK.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = BANK.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = BANK.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 5);
        }
    }
