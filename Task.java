/**
 * Created by tristanday on 4/10/17.
 */
public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public boolean getStatus() {return isDone;}

    public String getName() {return name;}

    public void setStatus() {this.isDone = true;}

    public String toString() {
        return name + (isDone?" Y":" N");
    }
}