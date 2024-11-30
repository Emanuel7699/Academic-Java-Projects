/** public class Date extends Object.
 * This class represents a Date object.
 *
 * @author Emanuel Abraham
 * @version 27/11/2024 (2025a)
 */

public class Baby {
    private String _firstName;
    private String _lastName;
    private String _id;
    private Date _dateOfBirth;
    private Weight _birthWeight;
    private Weight _currentWeight;

    private final byte LENGTH_ID = 9;
    private final String DEFAULT_ID = "000000000";

    public Baby(String fName, String lName, String id,
                int day, int month, int year, int birthWeightInGrams) {
        _firstName = fName;
        _lastName = lName;
        if (id.length() == LENGTH_ID) {
            _id = id;
        } else {
            _id = DEFAULT_ID;
        }
        _dateOfBirth = new Date(day, month, year);
        _birthWeight = new Weight(birthWeightInGrams);
        _currentWeight = _birthWeight;
    }

    public Baby(Baby other) {
        this(other._firstName,
                other._lastName,
                other._id,
                other._dateOfBirth.getDay(),
                other._dateOfBirth.getMonth(),
                other._dateOfBirth.getYear(),
                other._birthWeight.getKilos() * 1000 + other._birthWeight.getGrams());
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getId() {
        return _id;
    }

    public Date getDateOfBirth() {
        return _dateOfBirth;
    }

    public Weight getBirthWeight() {
        return _birthWeight;
    }

    public Weight getCurrentWeight() {
        return _currentWeight;
    }

    public void setCurrentWeight(Weight weightToSet) {
        if (weightToSet.getKilos() >= 1) {
            _currentWeight = new Weight(weightToSet);
        }
    }

    public String toString() {
        return ("Name: " + _firstName + " " + _lastName + "\nId: " + _id + "\nDate Of Birth: " + _dateOfBirth + "\nBirth Weight: " + _birthWeight + "\nCurrent Weight: " + _currentWeight);
    }

    public boolean equals(Baby other) {
        return (other._firstName == _firstName && other._lastName == _lastName && other._id == _id && other._dateOfBirth.getDay() == _dateOfBirth.getDay() && other._dateOfBirth.getMonth() == _dateOfBirth.getMonth() && other._dateOfBirth.getYear() == _dateOfBirth.getYear());
    }

    public boolean areTwins(Baby other) {
        return (_lastName.equals(other._lastName) &&
                !_firstName.equals(other._firstName) &&
                !_id.equals(other._id) &&
                (_dateOfBirth.difference(other._dateOfBirth) <= 1));
    }

    public boolean heavier(Baby other) {
        return (_currentWeight.heavier(other._currentWeight));
    }

    public void updateCurrentWeight(int grams) {
        _currentWeight = _currentWeight.add(grams);
    }

    public boolean older(Baby other) {
        return (_dateOfBirth.before(other._dateOfBirth));
    }

    public int isWeightInValidRange(int numOfDays) {
        if (numOfDays >= 0 && numOfDays <= 7){
            if (_currentWeight.heavier(_birthWeight.add((10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams())/ 700) * numOfDays))){
                    return 3;
            }
            return 2;
        }
        else if (numOfDays >= 8 && numOfDays <= 60){
            if (_currentWeight.heavier((_birthWeight.add((10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams())/ 700) * 7 + 30 * (numOfDays - 8))))){
                return (3);
            }
            return (2);
        }
        else if (numOfDays >= 61 && numOfDays <= 120){
            if (_currentWeight.heavier((_birthWeight.add((10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams())/ 700) * 7 + 30 * 53 + 25 * (numOfDays - 60))))){
                return (3);
            }
            return (2);
        }
        else if (numOfDays >= 121 && numOfDays <= 240){
            if (_currentWeight.heavier((_birthWeight.add((10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams())/ 700) * 7 + 30 * 53 + 25 * 60 + 16 * (numOfDays - 120))))){
                return (3);
            }
            return (2);
        }
        else if (numOfDays >= 241 && numOfDays <= 365){
            if (_currentWeight.heavier((_birthWeight.add((10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams())/ 700) * 7 + 30 * 53 + 25 * 60 + 16 * 120 + 8 * (numOfDays - 240))))){
                return (3);
            }
            return (2);
        }
        else{
            return (1);
        }
    }
}
