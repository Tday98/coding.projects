public class Student {
    private String name;
    private int pointsEarned;

    public Student(String name) {
        this.name = name;
        pointsEarned = 0;
    }

    public String getName() {return name;}

    public boolean setPointsEarned(int amt, int total) {
        if (amt < 0 || amt > total) {
            System.out.println("Not a valid score.");
            return false;
        }
        this.pointsEarned += amt;
        return true;
    }
}