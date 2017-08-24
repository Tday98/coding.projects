public class PersonRunner {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new PoliceOfficer("Molly",27,11235);
        people[1] = new PoliceOfficer("Walid",32,24816);
        people[2] = new Clown("Doink",45,true);
        people[3] = new Barber("Seville",82);

        for (Person p : people) {
            System.out.println(p);
            System.out.println(p.act());
        }
    }
}