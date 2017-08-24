/**
 * Created by tristanday on 4/17/17.
 */
import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<String> programs;
    private int maxSize;

    public Cache(int size) {
        this.programs = new ArrayList<String>();
        this.maxSize = size;
    }

    private int findProgram(String programName) {
        int position = 0;
        while (position < programs.size()) {
            if (programs.get(position).equals(programName)) {
                break;
            }
            position++;
        }
        return position;
    }

    private void addProgram(String programName) {
        programs.add(0,programName);
        if (programs.size() > this.maxSize) {
            programs.remove(maxSize);
        }
    }

    private void useProgram(int position) {
        String s = programs.remove(position);
        programs.add(0,s);
    }

    public void update(String programName) {
        int position = findProgram(programName);
        if (position < programs.size()) {
            useProgram(position);
        } else {
            addProgram(programName);
        }
    }

    public String toString() {
        String out = "Current cache contents:\n----------------------\n";
        for (int i = 0; i < programs.size(); i++) {
            out += String.format("%2d) %s\n",(i+1),programs.get(i));
        }
        return out;
    }
}