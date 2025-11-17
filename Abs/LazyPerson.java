class LazyPerson extends Hooman {
    private int hours;

    public LazyPerson(int hours) {
        this.hours = hours;
    }

    @Override
    public void eat() {
        System.out.println("Couch Potato Diet: Eating while watching TV also prolongs the time period that we're eating.");
    }

    @Override
    public void exercise() {
        System.out.println("Couch Potato Activities: Rarely exercising or being physically active.");
    }

    @Override
    int caloriesBurned() {
        return 50 * hours;
    }
} 
