import java.util.Scanner;

public class Gradebook {
    Student[] students;
    int totalPoints;

    public Gradebook(int numStudents) {
        this.students = new Student[numStudents];
        for (int x = 0; x < numStudents; x++) {
            students[x] = new Student("" + (char)(x+65));
        }
        totalPoints = 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Gradebook g = new Gradebook(5);

        System.out.print("Enter the total points for this assignment: ");
        int total = s.nextInt();
        g.totalPoints += total;

        for (Student x : g.students) {
            do {
                System.out.print("Enter the points earned for " + x.getName() + ": ");
            } while(!x.setPointsEarned(s.nextInt(),total));
        }
    }
}