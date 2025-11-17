public class ActivateHooman {
  
    public static void main(String[] args) {
        int minutes = 60;
        Hooman Phelps = new Athlete(minutes);
        int hours = 8;
        Hooman Me = new LazyPerson(hours);
    
        Phelps.eat();
        Phelps.exercise();
        System.out.println("Athlete burned " + Phelps.caloriesBurned() + " calories " + "in " + minutes + " minutes.");
    
        Me.eat();
        Me.exercise();
        System.out.println("Couch potato burned " + Me.caloriesBurned() + " calories " + "in " + hours + " hours.");
    }
}
