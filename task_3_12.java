import java.util.Scanner;


public class task_3_12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть координати які задають перший прямокутник через пробіл: ");
        String A1x = sc.next();
        String A1y = sc.next();
        String B1x = sc.next();
        String B1y = sc.next();
        double a1x = Double.parseDouble(A1x);
        double a1y = Double.parseDouble(A1y);
        double b1x = Double.parseDouble(B1x);
        double b1y = Double.parseDouble(B1y);
        System.out.println("Введіть координати які задають другий прямокутник через пробіл: ");
        String A2x = sc.next();
        String A2y = sc.next();
        String B2x = sc.next();
        String B2y = sc.next();
        double a2x = Double.parseDouble(A2x);
        double a2y = Double.parseDouble(A2y);
        double b2x = Double.parseDouble(B2x);
        double b2y = Double.parseDouble(B2y);

        double a3x = Math.min(a1x, a2x);
        double a3y = Math.min(a1y, a2y);
        double b3x = Math.max(b1x, b2x);
        double b3y = Math.max(b1y, b2y);
        System.out.println("Координати лівого нижнього та правого верхнього кутів прямокутника = ("
                + a3x + ", " + a3y + "); (" + b3x + ", " + b3y + ")");
    }
}