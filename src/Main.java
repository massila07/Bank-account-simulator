import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Account Simulator ---");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show all accounts");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Entrez le numéro de compte : ");
                    int accNum = Integer.parseInt(scanner.nextLine());

                    System.out.print("Entrez le nom du titulaire : ");
                    String name = scanner.nextLine();

                    System.out.print("Entrez le solde initial : ");
                    double balance = Double.parseDouble(scanner.nextLine());

                    Account newAccount = new Account(accNum, name, balance);
                    accounts.add(newAccount);

                    System.out.println("Compte créé avec succès !");
                    break;

                case "2":
                    System.out.print("Entrez le numéro de compte pour le dépôt : ");
                    int depAccNum = Integer.parseInt(scanner.nextLine());
                    Account depAcc = null;

                    // Cherche le compte
                    for (Account a : accounts) {
                        if (a.getAccountNumber() == depAccNum) {
                            depAcc = a;
                            break;
                        }
                    }

                    if (depAcc == null) {
                        System.out.println("Compte non trouvé !");
                    } else {
                        System.out.print("Montant à déposer : ");
                        double depAmount = Double.parseDouble(scanner.nextLine());
                        depAcc.deposit(depAmount);
                    }
                    break;


                case "3":
                    System.out.print("Entrez le numéro de compte pour le retrait : ");
                    int witAccNum = Integer.parseInt(scanner.nextLine());
                    Account witAcc = null;

                    for (Account a : accounts) {
                        if (a.getAccountNumber() == witAccNum) {
                            witAcc = a;
                            break;
                        }
                    }

                    if (witAcc == null) {
                        System.out.println("Compte non trouvé !");
                    } else {
                        System.out.print("Montant à retirer : ");
                        double witAmount = Double.parseDouble(scanner.nextLine());
                        witAcc.withdraw(witAmount);
                    }
                    break;


                case "4":
                    System.out.print("Entrez le numéro du compte source : ");
                    int srcAccNum = Integer.parseInt(scanner.nextLine());
                    Account srcAcc = null;

                    System.out.print("Entrez le numéro du compte destination : ");
                    int destAccNum = Integer.parseInt(scanner.nextLine());
                    Account destAcc = null;

                    // Cherche les comptes
                    for (Account a : accounts) {
                        if (a.getAccountNumber() == srcAccNum) srcAcc = a;
                        if (a.getAccountNumber() == destAccNum) destAcc = a;
                    }

                    if (srcAcc == null || destAcc == null) {
                        System.out.println("Un ou plusieurs comptes introuvables !");
                    } else {
                        System.out.print("Montant à transférer : ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        srcAcc.transfer(destAcc, amount);
                    }
                    break;


                case "5":
                    System.out.println("Liste des comptes :");
                    for (Account a : accounts) {
                        System.out.println(a);
                    }
                    break;


                case "6":
                    System.out.println("Goodbye 👋");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
