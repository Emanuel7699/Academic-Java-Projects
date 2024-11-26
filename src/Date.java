/** public class Date extends Object.
 * This class represents a Date object.
 *
 * @author Emanuel Abraham
 * @version 27/11/2024 (2025a)
 */

public class Date {
    private int _day;
    private int _month;
    private int _year;

    private static final int MIN_DAY = 1;
    private static final int MIN_MONTH = 1;
    private final int MIN_YEAR = 1000;
    private final int MAX_MONTH = 12;
    private final int MAX_YEAR = 9999;
    private static final int THIS_year = 2024;


    /** Date constructor - If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2024.
     *
     * @param day The day in the month (1-31).
     * @param month The month in the year (1-12).
     * @param year The year (4 digits).
     */
    public Date(int day, int month, int year) {

        if ((day >= MIN_DAY && day <= maxDay(day, month)) && (month >= MIN_MONTH && month <= MAX_MONTH) && (year >= MIN_YEAR && year <= MAX_YEAR)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = MIN_DAY;
            _month = MIN_MONTH;
            _year = THIS_year;
        }
    }

    /** Date constructor- Default constructor, creates the date 01/01/2024.
     */
    public Date() {
        this(MIN_DAY, MIN_MONTH, THIS_year);
    }

    /** Date constructor- Copy constructor.
     *
     * @param other Other date.
     */
    public Date(Date other) {
        this(other._day, other._month, other._year);
    }


    /** Check what is the maximum day of each month.
     *
     * @param month The month in the year (1-12).
     * @param year The year (4 digits).
     * @return The maximum day of each month.
     */
    private int maxDay(int month, int year) {
        switch (month) {
            case 4,6,9,11: return 30; // April, June, September, November
            case 2: return isLeapYear(year); // February with leap year check
            default: return 31; // All other months
        }
    }

    /** checks if the year is a leap year in order to set the maximum day of february.
     *
     * @param y The year (4 digits).
     * @return The maximum day of february.
     */
    private int isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? 29 : 28;
    }

    /** Gets the day.
     *
     * @return The day of this date.
     */
    public int getDay() {
        return _day;
    }

    /** Gets the month.
     *
     * @return The month of this date.
     */
    public int getMonth() {
        return _month;
    }

    /** Gets the year.
     *
     * @return The year of this date.
     */
    public int getYear() {
        return _year;
    }


    public void setDay(int dayToSet) {
        if (dayToSet >= MIN_DAY && dayToSet <= maxDay(_month, _year)) {
            _day = dayToSet;
        }
    }


    public void setMonth(int monthToSet) {
        if (monthToSet >= MIN_MONTH && monthToSet <= MAX_MONTH && _day <= maxDay(monthToSet, _year)) {
                _month = monthToSet;
        }
    }


    public void setYear(int yearToSet) {
        if (yearToSet >= MIN_YEAR && yearToSet <= MAX_YEAR && _day <= maxDay(_month, yearToSet)){
                _year = yearToSet;
        }
    }

    /** Checks if two dates are the same
     *
     * @param other The date to compare this date to.
     * @return True if the dates are the same.
     */
    public boolean equals(Date other) {
        return ((_day == other._day) && (_month == other._month) && (_year == other._year));
    }

    /** Checks if this date comes before another date
     *
     * @param other Date to compare this date to.
     * @return True if this date is before the other date.
     */
    public boolean before(Date other) {
        return ((calculateDate(_day, _month, _year)) < (calculateDate(other._day, other._month, other._year)));
    }

    /** Checks if this date comes after another date
     *
     * @param other Date to compare this date to.
     * @return True if this date is after the other date.
     */
    public boolean after(Date other) {
        return (!(this.before(other)) && !(this.equals(other)));
    }

    /** Calculates the difference in days between two dates
     *
     * @param other The date to calculate the difference between.
     * @return The number of days between the dates (non-negative value).
     */
    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }


    /** Computes the day number since the beginning of the Christian counting of years.
     *
     * @param day the day in the month (1-31)
     * @param month The month in the year (1-12).
     * @param year The year (4 digits).
     * @return The day number since the beginning of the Christian counting of years.
     */
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

    /** Returns a String that represents this date.
     *
     * @return A String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998.
     */
    public String toString() {
        if (_day < 10 && _month < 10) {
            return "0" + _day + "/0" + _month + "/" + _year;
        } else if (_day < 10) {
            return "0" + _day + "/" + _month + "/" + _year;
        } else if (_month < 10) {
            return _day + "/0" + _month + "/" + _year;
        }
        return _day + "/" + _month + "/" + _year;
    }


    public Date tomorrow() {
        int newDay = _day, newMonth = _month, newYear = _year;
        if (_day < maxDay(_day, _month)) {
            newDay += 1;
        } else if (_month < MAX_MONTH) {
            newMonth += 1;
            newDay = MIN_DAY;
        } else {
            newYear += 1;
            newMonth = MIN_MONTH;
            newDay = MIN_DAY;
        }
        return new Date(newDay,newMonth, newYear);
    }
}
