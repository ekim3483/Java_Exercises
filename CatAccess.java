import java.util.Scanner;

public class CatAccess {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        Cat myCat = new Cat();

        System.out.println("What is kitty's name? ");
        String name = scanner.nextLine();
        myCat.setName(name);

        System.out.println("When is " + myCat.getName() + "'s birthday? ");
        String birthday = scanner.nextLine();
        myCat.setBirthday(birthday);

        System.out.println("Give " + myCat.getName() + " a kitty-kiss for me on " + myCat.getBirthday() + " please.");
    } 
}