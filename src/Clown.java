public class Clown extends Person {
    private boolean isScary;

    public Clown(String name, int age, boolean isScary) {
        super(name,age);
        this.isScary = isScary;
    }

    public String act() {
        return "Honk honk!";
    }

    public String toString() {
        if (this.isScary) {
            return "Mwahaha! " + super.toString();
        }
        return "Teeheehee! " + super.toString();
    }
}