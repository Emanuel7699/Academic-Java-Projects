public class Date {
    private int _day;
    private int _month;
    private int _year;

    private static final int MIN_day = 1;
    private static final int MIN_month = 1;
    private final int MIN_year = 1000;
    private final int MAX_month = 12;
    private final int MAX_year = 9999;
    private static final int THIS_year = 2024;

    public Date(int day, int month, int year) {

        if ((day >= MIN_day && day <= MAX_day(day, month)) && (month >= MIN_month && month <= MAX_month) && (year >= MIN_year && year <= MAX_year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = MIN_day;
            _month = MIN_month;
            _year = THIS_year;
        }
    }

    public Date() {
        this(MIN_day, MIN_month, THIS_year);
    }

    public Date(Date other) {
        this(other._day, other._month, other._year);
    }


    private int MAX_day(int month, int year) {
        switch (month) {
            case 4,6,9,11: return 30; // April, June, September, November
            case 2: return isLeapYear(year); // February with leap year check
            default: return 31; // All other months
        }
    }

    // checks if the year is a leap year
    private int isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? 29 : 28;
    }

    public int getDay() {
        return _day;
    }

    public int getMonth() {
        return _month;
    }

    public int getYear() {
        return _year;
    }

    public void setDay(int dayToSet) {
        _day = dayToSet;
    }

    public void setMonth(int monthToSet) {
        _month = monthToSet;
    }

    public void setYear(int yearToSet) {
        _year = yearToSet;
    }


    public boolean equals(Date other) {
        return ((_day == other._day) && (_month == other._month) && (_year == other._year));
    }

    public boolean before(Date other) {
        return ((calculateDate(_day, _month, _year)) < (calculateDate(other._day, other._month, other._year)));
    }

    public boolean after(Date other) {
        return (!(this.before(other)) && !(this.equals(other)));
    }

    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }


    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }


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
        if (_day < MAX_day(_day, _month)) {
            _day += 1;
        } else if (_month < MAX_month) {
            _month += 1;
            _day = MIN_day;
        } else {
            _year += 1;
            _month = MIN_month;
            _day = MIN_day;
        }
        return this;
    }
}
