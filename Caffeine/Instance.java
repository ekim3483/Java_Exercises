public class Instance{
    public static void main(String[] args) {
        // Create Cupof object
        Cupof joe1 = new Cupof();

        // Print the value of count

        if (Cupof.getCoffee() < 4) {
            System.out.println("Here's your caffeine fix:");
            System.out.println("   J    a   v     v  a ");
            System.out.println("   J   a a   v   v  a a");
            System.out.println("J  J  aaaaa   V V  aaaaa");
            System.out.println(" JJ  a     a   V  a     a");
        }
        System.out.println("That's enough Java for today. I'll add a menu tomorrow.");

    }
}
