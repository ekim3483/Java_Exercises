import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneBookHashMap {
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }
    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }

    public static void main(String s[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Long> phonebook = new HashMap<>();
            while(true) {
                System.out.println("Press 1 to add an entry in the phonebook," +
                    "\n2 to view all the entries" +
                    "\n3 to reverse search by phone number" +
                    "\n4 to delete an entry" +
                    "\nAny other key to exit");
                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter a name");
                    String name = scanner.nextLine();
                    if (!isNameValid(name)) {
                        continue;
                    }
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();
                        if (repChoice.equalsIgnoreCase("n")){
                            continue;
                        }
                    }
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    if (isPhoneNumberValid(phoneNumber)) {
                        Long phonenumber = Long.parseLong(phoneNumber);
                        phonebook.put(name, phonenumber);
                        System.out.println("The name and number have been added to the phonebook.");
                    }
                }
                else if (userAction.equals("2")) {
                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                } 
                else if (userAction.equals("3")) {
                    System.out.println("Enter the phone number you want to look up");
                    Long value = Long.parseLong(scanner.nextLine());
                    if (phonebook.containsValue(value)) {
                        for (Map.Entry<String, Long> entry : phonebook.entrySet()) {
                            if (Objects.equals(entry.getValue(), value)) {
                                System.out.println(entry.getKey());
                            }
                            // we can't compare like this, null will throws exception
                            /*(if (entry.getValue().equals(value)) {
                                result.add(entry.getKey());
                            }*/
                        }
                    }
                }else if (userAction.equals("4")) {
                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();
                    if (phonebook.containsKey(keyName)) {
                        phonebook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                } else {
                    break;
                }
                scanner.close()
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}