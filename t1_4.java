import java.util.Scanner;

public class t1_4 {
    private static t1_4 instance;

    private t1_4() { // cjnstructor
    }

    public static t1_4 getInstance() {
        if (instance == null) {
            instance = new e1_4();
        }
        return instance;
    }

    public static void main(String[] args) {
        t1_4 obj1 = t1_4.getInstance(); // two examples
        t1_4 obj2 = t1_4.getInstance();

        if (obj1 == obj2) {
            System.out.println("identical oblects, one example");
        } else {
            System.out.println("different objects...");
        }
    }
}
