package main.java.adapter.calendar_adapter;

public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter(2025, 4, 23);
        System.out.println("Initial date: " + date);

        date.advanceDays(10);
        System.out.println("Plus 7 days: " + date);

        date.advanceDays(-2);
        System.out.println("Minus 2 days: " + date);

        date.setDay(22);
        date.setMonth(2);
        date.setYear(2003);
        System.out.println("Reset to: " + date);
    }
}
