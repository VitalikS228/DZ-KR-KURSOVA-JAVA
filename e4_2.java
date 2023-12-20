import java.util.Calendar;

public class e4_2 {
    public static void main(String[] args) {
        int n = days_count();
        System.out.printf("Max number of days without friday 13 - %d", n);
    }

    public static int days_count() {
        Calendar calendar = Calendar.getInstance();
        int max = 0;
        int days = 0;
        for (int year = 1999 - 400; year < 1999; year++) {
            for (int month = 0; month < 12; month++) {
                calendar.set(year, month, 13);
                int m = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                days += m;

                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    days--;
                    max = Math.max(max, days);
                    days = 0;
                }
            }
        }
        return max;
    }
}