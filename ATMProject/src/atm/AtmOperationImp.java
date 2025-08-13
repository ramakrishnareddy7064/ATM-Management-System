package atm;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtmOperationImp implements ATMInterface {

    ATM atm = new ATM();

    // Using LinkedHashMap<Integer, String> to store transactions in order
    Map<Integer, String> ministmt = new LinkedHashMap<>();
    int transactionId = 1;

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(transactionId++, withdrawAmount + " Amount Withdrawn");
                System.out.println("Collect the cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Please enter the amount in multiples of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(transactionId++, depositAmount + " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        if (ministmt.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("----- Mini Statement -----");
            for (Map.Entry<Integer, String> entry : ministmt.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
        }
    }
}
