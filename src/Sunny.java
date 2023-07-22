import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sunny {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("sunny.dat"));
        ArrayList<Course> list = new ArrayList<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            list.add(new Course(line.substring(0, line.indexOf(" ")), line.substring(line.indexOf(" ") + 1)));
        }

        Collections.sort(list);

        for (Course a: list) {
            System.out.println(a.course + " (" + a.id + ")");
        }
    }
}

class Course implements Comparable<Course> {
    String id, course;

    Course(String id, String course) {
        this.id = id;
        this.course = course;
    }


    @Override
    public int compareTo(Course o) {
        int c = course.compareTo(o.course);

        if (c == 0)
            return id.compareTo(o.id);

        return c;
    }
}
