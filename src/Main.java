import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

class Date implements Comparable<Date> {
     private int day;
     private int month;
     private int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1) return false;
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date update attempt");
        }
    }

    public String getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int calculateDifference(Date otherDate) {
        LocalDate date1 = LocalDate.of(this.year, this.month, this.day);
        LocalDate date2 = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return Math.abs((int) java.time.temporal.ChronoUnit.DAYS.between(date1, date2));
    }

    public void printDate() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(monthNames[month - 1] + " " + day + ", " + year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Date> dates = new ArrayList<>();

        System.out.print("Enter the number of dates: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter date (day month year): ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            try {
                dates.add(new Date(day, month, year));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date, try again.");
                i--;
            }
        }

        System.out.println("Before sorting:");
        for (Date d : dates) d.printDate();

        Collections.sort(dates);

        System.out.println("After sorting:");
        for (Date d : dates) d.printDate();

        System.out.print("Enter two dates to find difference (index starting from 1): ");
        int idx1 = scanner.nextInt() - 1;
        int idx2 = scanner.nextInt() - 1;

        if (idx1 >= 0 && idx1 < dates.size() && idx2 >= 0 && idx2 < dates.size()) {
            System.out.println("Difference in days: " + dates.get(idx1).calculateDifference(dates.get(idx2)));
            System.out.println("Day of week for first date: " + dates.get(idx1).getDayOfWeek());
        } else {
            System.out.println("Invalid indices.");
        }

        scanner.close();
    }
}