import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        Set<String> usedNames = new HashSet<>(); // Set to keep track of used names that already been input
        Set<String> usedPhoneNumbers = new HashSet<>(); // Set to keep track of used phone numbers that already been input

        while (true) {
            System.out.println("*************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("*************");
            System.out.print("Please Enter a command: ");

            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "A":
                    // Input name (alphabetical characters only)
                    System.out.print("Enter name (alphabetical characters only): ");
                    String name;
                    do {
                        name = scanner.nextLine();
                        if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid input! Please enter only alphabetical characters.");
                        }
                    } while (!name.matches("[a-zA-Z]+"));

                    // Check if the name already exists
                    if (usedNames.contains(name)) {
                        System.out.println("Name already exists. Please enter a different name.");
                        break;
                    }
                    usedNames.add(name); // Add the name to the used names set

                    // Input phone number (numeric characters only)
                    System.out.print("Enter phone number (numeric characters only): ");
                    String phoneNumber;
                    do {
                        phoneNumber = scanner.nextLine();
                        if (!phoneNumber.matches("\\d+")) {
                            System.out.println("Invalid input! Please enter only numeric characters.");
                        }
                    } while (!phoneNumber.matches("\\d+"));

                    // Check if the phone number already exists
                    if (usedPhoneNumbers.contains(phoneNumber)) {
                        System.out.println("Phone number already exists. Please enter a different phone number.");
                        break;
                    }
                    usedPhoneNumbers.add(phoneNumber); // Add the phone number to the used phone numbers set

                    // Input email (must contain '@gmail.com')
                    String email;
                    do {
                        System.out.print("Enter email (must contain '@gmail.com'): ");
                        email = scanner.nextLine();
                    } while (!isValidEmail(email));

                    // Add the contact to the contact book
                    contactBook.addContact(new Contact(name, phoneNumber, email));
                    break;
                case "P":
                    contactBook.printList();
                    break;
                case "D":
                    System.out.print("Enter the name of the contact you want to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case "S":
                    System.out.print("Enter the name of the contact you want to search: ");
                    String searchName = scanner.nextLine();
                    contactBook.searchContact(searchName);
                    break;
                case "E":
                    System.out.print("Enter the email of the contact you want to search: ");
                    String searchEmail = scanner.nextLine();
                    contactBook.searchByEmail(searchEmail);
                    break;
                case "Q":
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    // Method to validate email format check if its contains @gmail.com
    private static boolean isValidEmail(String email) {
        return email.matches(".*@gmail\\.com$");
    }
}
