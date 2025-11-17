class Athlete extends Hooman {
    private int minutes;

    public Athlete(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public void eat() {
        System.out.println("Athlete Diet: Include foods full of calcium, iron, potassium, and fiber.");
    }

    @Override
    public void exercise() {
        System.out.println("Athlete Activities: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.");
    }

    @Override
    int caloriesBurned() {
        return 15 * minutes;
    }

}
