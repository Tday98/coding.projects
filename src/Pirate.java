/**
 * Created by tristanday on 3/7/17.
 */
import java.util.Random;
public class Pirate {
    Random R = new Random();
    String name;
    int health;
    int swordsmanship;
    int agility;
    boolean hasParrot;
    boolean hasPegLeg;
    int doubloons;
    static int numberOfPirates = 0;

    public Pirate (String name, int swordsmanship, int agility, boolean hasParrot, boolean hasPegLeg) {
        this.name = name;
        this.swordsmanship = swordsmanship;
        this.agility = agility;
        this.hasParrot = hasParrot;
        this.hasPegLeg = hasPegLeg;
        health = 10;
        doubloons = 25;
        numberOfPirates++;
    }

    public Pirate (String name) {
        health = 10;
        doubloons = 25;

        this.name = name;
        this.swordsmanship = R.nextInt(10) + 1;
        this.agility = R.nextInt(10) + 1;
        if (R.nextDouble() <= 0.25)
            this.hasParrot = true;
        else
            this.hasParrot = false;
        if (R.nextDouble() <= 0.1)
            this.hasPegLeg = true;
        else
            this.hasPegLeg = false;
        numberOfPirates++;
    }

    public String swashbuckle (Pirate p) {
        if (p.hasPegLeg == true) {
            if (p.agility - 1 > R.nextInt(21)) {
                return p.name + " dodged yar attack!";
            } else {
                if (this.hasParrot == true) {
                    p.health = p.health - (this.swordsmanship + 1);
                    if (p.health <= 0) {
                        p.health = 0;
                        this.doubloons += p.doubloons;
                        numberOfPirates--;
                    }
                    int x = this.swordsmanship + 1;
                    return this.name + " swabs the deck with " + p.name + " for " + x + "!";
                } else {
                    p.health = p.health - this.swordsmanship;
                    if (p.health <= 0) {
                        p.health = 0;
                        this.doubloons += p.doubloons;
                        numberOfPirates--;
                    }
                    return this.name + " swabs the deck with " + p.name + " for " + this.swordsmanship + "!";
                }
            }
        } else {
            if (p.agility > R.nextInt(21)) {
                return p.name + " dodged yar attack!";
            } else {
                if (this.hasParrot == true) {
                    p.health = p.health - (this.swordsmanship + 1);
                    if (p.health <= 0) {
                        p.health = 0;
                        this.doubloons += p.doubloons;
                        numberOfPirates--;
                    }
                    int x = this.swordsmanship + 1;
                    return this.name + " swabs the deck with " + p.name + " for " + x + "!";
                } else {
                    p.health = p.health - this.swordsmanship;
                    if (p.health <= 0) {
                        p.health = 0;
                        this.doubloons += p.doubloons;
                        numberOfPirates--;
                    }
                    return this.name + " swabs the deck with " + p.name + " for " + this.swordsmanship + "!";
                }
            }
        }
    }

    public boolean isNapping () {
        if (this.health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (this.hasPegLeg == true && this.hasParrot == true) {
            return this.name + "(H: " + this.health + ", S: "
                    + this.swordsmanship + ", A: " + this.agility + ", $" + this.doubloons + ")" + "\n" +
                    "This pirate has a parrot and has a pegleg.";
        } else if (this.hasPegLeg == true && this.hasParrot == false) {
            return this.name + "(H: " + this.health + ", S: "
                    + this.swordsmanship + ", A: " + this.agility + ", $" + this.doubloons + ")" + "\n" +
                    "This pirate does not have a parrot and has a pegleg.";
        } else if (this.hasPegLeg == false && this.hasParrot == true) {
            return this.name + "(H: " + this.health + ", S: "
                    + this.swordsmanship + ", A: " + this.agility + ", $" + this.doubloons + ")" + "\n" +
                    "This pirate has a parrot and does not have a pegleg.";
        } else {
            return this.name + "(H: " + this.health + ", S: "
                    + this.swordsmanship + ", A: " + this.agility + ", $" + this.doubloons + ")" + "\n" +
                    "This pirate does not have a parrot and does not have a pegleg.";
        }

    }

    public static void main (String[] args) {
        Pirate p = new Pirate("MasterRace");
        Pirate s = new Pirate("PC", 10, 10, true, false);
        System.out.println(p.isNapping());
        System.out.println(p.swashbuckle(s));
        System.out.println(p.toString());
        System.out.println(s.toString());
    }
}
