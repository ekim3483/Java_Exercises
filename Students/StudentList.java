import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            ArrayList<Student> studentList = new ArrayList<Student>();
            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add a student, " +
                    "\n2 to view all the students " +
                    "\n3 to change a student's information " +
                    "\n4 to delete a student " +
                    "\n5 to sort students by age " +
                    "\nAny other key to exit");
                // Read the user's choice
                String userAction = scanner.nextLine();
                // Option 1: Add a task to the to-do list
                if (userAction.equals("1")) {
                    // Prompt the user to enter a student description
                    System.out.println("Enter the student's name: ");
                    String studentName = scanner.nextLine();
                    // Prompt the user to enter the student's age
                    System.out.println("Enter the student's age ");
                    int studentAge = Integer.parseInt(scanner.nextLine());
                    // Prompt the user to enter the student's major
                    System.out.println("Enter the student's major ");
                    String studentMajor = scanner.nextLine();
                    // Create a new Task object and add it to the to-do list
                    studentList.add(new Student(studentName, studentAge, studentMajor));
                    System.out.println("The student has been added to the list");
                }
                // Option 2: View all students in the list
                else if (userAction.equals("2")) {
                    // Use forEach to print each student in the list
                    studentList.forEach(student -> System.out.println(student));
                }
                // Option 3: Change the student's profile
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the index of the record to update
                    System.out.println("Enter the index of the student file you want to change ");
                    int chgIdx = Integer.parseInt(scanner.nextLine());
                    // Check if the index is valid
                    if (chgIdx > (studentList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new information for the student
                        System.out.println("Enter the student's name: ");
                        String studentName = scanner.nextLine();
                        studentList.get(chgIdx).setName(studentName);
                        System.out.println("Enter the student's age: ");
                        int studentAge = Integer.parseInt(scanner.nextLine());
                        studentList.get(chgIdx).setAge(studentAge);
                        System.out.println("Enter the student's major: ");
                        String studentMajor = scanner.nextLine();
                        studentList.get(chgIdx).setMajor(studentMajor);
                    
                    }
                    System.out.println("The student's information has been updated.");
                }
                // Option 4: Delete a student
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the index of the student to delete
                    System.out.println("Enter the index of the student you want to delete: ");
                    int rmvIdx = Integer.parseInt(scanner.nextLine());
                    // Check if the index is valid
                    if (rmvIdx > (studentList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        studentList.remove(rmvIdx);
                        System.out.println("The student has been removed from the list");
                    }
                }
                // Option 5: Sort students by age
                else if (userAction.equals("5")) {
                // Sort the ArrayList by age using a Comparator
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return Integer.compare(s2.getAge(), s1.getAge());
                        }
                    });
                    System.out.println("Students sorted by priority (High to Low):");
                    studentList.forEach(student -> System.out.println(student));
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        }
        catch (NumberFormatException nfe) {
            // Handle invalid number input (e.g., non-integer input for age or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
