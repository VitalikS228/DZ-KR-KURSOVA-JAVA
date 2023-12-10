import java.util.Scanner;

public class e1_4 {
    private static e1_4 instance;

    private e1_4() { // cjnstructor
    }

    public static e1_4 getInstance() {
        if (instance == null) {
            instance = new e1_4();
        }
        return instance;
    }

    public static void main(String[] args) {
        e1_4 obj1 = e1_4.getInstance(); // two examples
        e1_4 obj2 = e1_4.getInstance();

        if (obj1 == obj2) {
            System.out.println("identical oblects, one example");
        } else {
            System.out.println("different objects...");
        }
    }
}
