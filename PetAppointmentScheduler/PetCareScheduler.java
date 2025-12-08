import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Main app to run the PetCare Scheduler.
 */
public class PetCareScheduler {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();
        
    public static void main(String[] args) {
        loadPetsFromFile();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Pet Care Scheduler ===");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display Pets");
            System.out.println("4. Display Pet Appointments");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    displayPets();
                    break;
                case "4":
                    displayPetAppointments();
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    savePetsToFile();
                    running = true;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }

    // Add the methods to handle each choice provided here
    private static void registerPet() {
        // Prompt the user to enter a unique pet ID
        System.out.print("Enter pet ID: ");
        String id = scanner.nextLine().trim();  // Read and trim input

        // Check if a pet with this ID already exists in the map
        if (pets.containsKey(id)) {
            System.out.println("Error: Pet ID already exists.");
            return;  // Stop and return early if duplicate found
        }

        // Prompt the user to enter the pet's name
        System.out.print("Enter pet's name: ");
        String name = scanner.nextLine().trim();

        // Prompt the user to enter the pet's species or breed
        System.out.print("Enter pet's species or breed: ");
        String speciesOrBreed = scanner.nextLine().trim();

        // Prompt the user to enter the pet's age
        System.out.print("Enter pet's age: ");
        String age = scanner.nextLine().trim();

        // Prompt the user to enter the owner's name
        System.out.print("Enter pet owner's name: ");
        String ownerName = scanner.nextLine().trim();

        // Prompt the user to enter the pet owner's contact info
        System.out.print("Enter pet owner's contact info: ");
        String contactInfo = scanner.nextLine().trim();

        // Create a new Pet object using the provided details
        Pet pet = new Pet(id, name, speciesOrBreed, age, ownerName, contactInfo);

        // Add the new pet to the pets map (using ID as the key)
        pets.put(id, pet);

        // Confirm to the user that the pet was registered successfully
        System.out.println("Pet registered successfully on " + pet.getRegistrationDate());
    }

    private static void scheduleAppointment() {
        // Ask the user for the pet ID
        System.out.print("Enter pet ID: ");
        String id = scanner.nextLine().trim();

        // Look up the pet in the map by ID
        Pet pet = pets.get(id);

        // If pet not found, show error and exit
        if (pet == null) {

            System.out.println("Error: Pet ID not found.");
            return;
        }
            // Ask the user for the appointment type needed
        try {
            System.out.print("Enter appointment type: ");
            String appointmentType = scanner.nextLine().trim();
            
            // Ask the user for the appointment date needed
            System.out.print("Enter appointment date (yyyy-MM-dd): ");
            String appointmentDate = scanner.nextLine();
            LocalDate date = LocalDate.parse(appointmentDate);

            // Ask the user for the appointment time needed
            System.out.print("Enter appointment time (HH:mm): ");
            String appointmentTime = scanner.nextLine();
            LocalTime time = LocalTime.parse(appointmentTime);

            // Create a new appointment using the appointment type, date, and time
            if (LocalDate.now().isBefore(date)) {
                Appointment appointment = new Appointment(appointmentType, date, time);

                // Add the new appointment to the pet's file and update
                pet.addAppointment(appointment);

                // Show success message with appointment scheduled
                System.out.println(appointmentType + " appointment scheduled");
            }
            else {
                System.out.println("Please retry by entering a date in the future.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date or time format. Please try again.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
      

    private static void displayPets() {
        // Check if the pets map is empty
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return; // Exit early if there's nothing to show
        }

        // If there are pets, print a header first
        System.out.println("\nRegistered Pets:");

        // Loop through each pet in the map and print its details
        for (Pet p : pets.values()) {
            System.out.println("ID: " + p.getId() +
                               ", Name: " + p.getName() +
                               ", Species or breed: " + p.getSpeciesOrBreed() +
                               ", Joined: " + p.getRegistrationDate());
        }
    }

    private static void displayPetAppointments() {
        // Prompt the user to enter the pet ID
        System.out.print("Enter pet ID: ");
        String id = scanner.nextLine().trim();

        // Look up the pet in the pets map using the ID
        Pet pet = pets.get(id);

        // If pet is not found, show an error and exit
        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        // Print a header with the pet's name
        System.out.println("\nAppointments for " + pet.getName() + ":");

        // Check if the pet has any appointments
        if (pet.getAppointments().isEmpty()) {
            System.out.println("No appointments logged.");
        } else {
            // Loop through all appointments and print each one
            for (Appointment a : pet.getAppointments()) {
                //Print the stringified version of the event
                System.out.println(a);
            }

        }
    }

    private static void generateReports() {
        // Check if there are any pets registered
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return; // Exit if there's nothing to report on
        }
    }

    private static void savePetsToFile() {
        try {
            // Create a FileOutputStream to write to the file named "pets.ser"
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("pets.ser")
            );
            // Write the entire pets map to the file
            out.writeObject(pets);
            out.close();
            // If successful, no message is printed here
        } catch (IOException a) {
            // If something goes wrong while saving, print an error message
            System.out.println("Error saving data: " + a.getMessage());
        }
    }

    @SuppressWarnings("unchecked") // Suppresses unchecked cast warning when reading the object
    private static void loadPetsFromFile() {
        // Use a try-with-resources block to automatically close the input stream
        try (
            // Open an ObjectInputStream to read from the file "households.ser"
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("pets.ser"))
        ) {
            // Read the object from the file and cast it back to the correct type
            pets = (Map<String, Pet>) in.readObject();

            // Confirmation message to let the user know data was loaded
            System.out.println("Pet data loaded.");
        } catch (FileNotFoundException a) {
            // If the file doesn't exist yet, start with empty data
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException a) {
            // Handle other errors (e.g. file corrupted or unreadable)
            System.out.println("Error loading data: " + a.getMessage());
        }
    }
}