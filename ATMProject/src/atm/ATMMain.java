package atm;

import java.util.Scanner;

public class ATMMain {

    public static void main(String[] args) {
        AtmOperationImp op = new AtmOperationImp();
        final int ATM_NUMBER = 12345;
        final int ATM_PIN = 123;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ATM Machine!");
        System.out.print("Enter ATM number: ");
        int enteredNumber = sc.nextInt();
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (ATM_NUMBER == enteredNumber && ATM_PIN == enteredPin) {
            while (true) {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        op.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        op.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM Card");
                        System.out.println("Thank you for using our ATM Machine.");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN");
            sc.close();
            System.exit(0);
        }
    }
}
