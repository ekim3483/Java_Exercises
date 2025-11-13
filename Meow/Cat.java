public class Cat {
    private String name;
    private String birthday;

    public Cat() {
        this.name = "Unnamed kitty :(";
        this.birthday = "dunno :*(";
    }

    public Cat(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }


}
