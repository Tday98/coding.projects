public class PoliceOfficer extends Person {
    private int precinctNumber;

    public PoliceOfficer(String name, int age, int precinctNumber) {
        super(name,age);
        this.precinctNumber = precinctNumber;
    }

    public String act() {
        return makeAnArrest(new Clown("Bubbles",36,false));
    }

    private String makeAnArrest(Person p) {
        return p + " is under arrest!";
    }
}