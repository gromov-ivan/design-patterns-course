package main.java.adapter.calendar_adapter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    private final Calendar cal;

    public CalendarToNewDateAdapter(int year, int month, int day) {
        this.cal = new GregorianCalendar(year, month - 1, day);
    }

    @Override
    public void setDay(int day) {
        cal.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int m) {
        cal.set(Calendar.MONTH, m - 1);
    }

    @Override
    public void setYear(int year) {
        cal.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return cal.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return cal.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        cal.add(Calendar.DAY_OF_MONTH, days);
    }

    @Override
    public String toString() {
        return "%04d-%02d-%02d".formatted(getYear(), getMonth(), getDay());
    }
}
