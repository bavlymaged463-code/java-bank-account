//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

    class SimpleBanking {
        // Global data structures (Static variables)
        static String[] accountNames = new String[10];
        static int[] accountNumbers = new int[10];
        static double[] balances = new double[10];
        static int totalAccounts = 0;

        static Scanner sc = new Scanner(System.in);


        public static void main(String[] args) {
            int choice;

            do {
                System.out.println("\n--- PROC-BANK SYSTEM ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) createAccount();
                else if (choice == 2) deposit();
                else if (choice == 3) checkBalance();

            } while (choice != 4);

            System.out.println("System closed.");
        }

        // Procedure to add a new account
        static void createAccount() {
            if (totalAccounts < 10) {
                System.out.print("Enter Name: ");
                accountNames[totalAccounts] = sc.next();
                accountNumbers[totalAccounts] = 100 + totalAccounts; // Simple ID generation
                balances[totalAccounts] = 0.0;

                System.out.println("Account created! Your ID is: " + accountNumbers[totalAccounts]);
                totalAccounts++;
            } else {
                System.out.println("Bank full!");
            }
        }

        // Procedure to deposit money
        static void deposit() {
            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            int index = findAccount(id);
            if (index != -1) {
                System.out.print("Amount to deposit: ");
                double amount = sc.nextDouble();
                balances[index] += amount;
                System.out.println("Success. New Balance: $" + balances[index]);
            } else {
                System.out.println("Account not found.");
            }
        }

        // Procedure to view balance
        static void checkBalance() {
            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            int index = findAccount(id);
            if (index != -1) {
                System.out.println("Customer: " + accountNames[index]);
                System.out.println("Balance: $" + balances[index]);
            } else {
                System.out.println("Account not found.");
            }
        }

        // Helper function to search the arrays
        static int findAccount(int id) {
            for (int i = 0; i < totalAccounts; i++) {
                if (accountNumbers[i] == id) return i;
            }
            return -1;
        }

    }