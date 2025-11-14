public class Cupof {
    // Static variable to keep track of the count of instances
    private static int coffee = 0;

    // Constructor increments the static variable count
    public Cupof() {
        coffee++;
    }

    // Static method to get the value of count
    public static int getCoffee() {
        return coffee;
    }
}
