import java.util.Scanner;

public class Instance{
    public static void main(String[] args) {

        Scanner pour = new Scanner(System.in);

        while (Cupof.getCoffee() < 4){
            System.out.println("Press any key to pour a cup");

            // Pour a cup

            String cups = pour.nextLine();

            if (cups != null) {
                Cupof joe = new Cupof();

                System.out.println("Here's your caffeine fix!");
                System.out.println("");
                System.out.println("   J    a   v     v  a ");
                System.out.println("   J   a a   v   v  a a");
                System.out.println("J  J  aaaaa   V V  aaaaa");
                System.out.println(" JJ  a     a   V  a     a");
                System.out.println("");
            }
        }
        System.out.println("That's enough Java for today.");
    }
}
