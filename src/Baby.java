/** public class Baby extends Object.
 * This class represents a Baby object.
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

    /** Baby constructor - If the given id and birthWeightInGrams are valid - creates a new Baby object with the parameters,
     * otherwise, if the id is not valid creates the Baby with id = "000000000" and all other parameters.
     *
     * @param fName The first name of the baby.
     * @param lName The last name of the baby.
     * @param id The id of the baby (9 characters).
     * @param day The day of the baby's birth.
     * @param month The month of the baby's birth.
     * @param year The year of the baby's birth.
     * @param birthWeightInGrams The weight of the baby at birth in grams (should be minimum 1KG).
     */
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

    /** Copy constructor.
     *
     * @param other  The baby to be copied.
     */
    public Baby(Baby other) {
        this(other._firstName,
                other._lastName,
                other._id,
                other._dateOfBirth.getDay(),
                other._dateOfBirth.getMonth(),
                other._dateOfBirth.getYear(),
                other._birthWeight.getKilos() * 1000 + other._birthWeight.getGrams());
    }

    /** Gets the first name.
     *
     * @return The first name of this baby.
     */
    public String getFirstName() {
        return _firstName;
    }

    /** Gets the last name.
     *
     * @return The last name of this baby.
     */
    public String getLastName() {
        return _lastName;
    }

    /** Gets the id.
     *
     * @return The id of this baby.
     */
    public String getId() {
        return _id;
    }

    /** Gets the date of birth.
     *
     * @return The date of birth of this baby.
     */
    public Date getDateOfBirth() {
        return new Date(_dateOfBirth);
    }

    /** Gets the birth weight.
     *
     * @return The weight of this baby at birth.
     */
    public Weight getBirthWeight() {
        return new Weight(_birthWeight);
    }

    /** Gets the current weight.
     *
     * @return The current weight of this baby.
     */
    public Weight getCurrentWeight() {
        return _currentWeight;
    }

    /** Sets the current weight if the given parameter is valid.
     *
     * @param weightToSet The new current weight.
     */
    public void setCurrentWeight(Weight weightToSet) {
        if (weightToSet.getKilos() >= 1) {
            _currentWeight = new Weight(weightToSet);
        }
    }

    /** Returns a String that represents this baby.
     *
     * @Overrides toString in class Object.
     * @return A String that represents this baby.
     */
    public String toString() {
        return ("Name: " + _firstName + " " + _lastName + "\nId: " + _id + "\nDate Of Birth: " + _dateOfBirth + "\nBirth Weight: " + _birthWeight + "\nCurrent Weight: " + _currentWeight);
    }

    /** Checks if two babies are the same.
     *
     * @param other The baby to compare this baby with.
     * @return True if the babies are the same
     */
    public boolean equals(Baby other) {
        return (other._firstName == _firstName && other._lastName == _lastName && other._id == _id && other._dateOfBirth.getDay() == _dateOfBirth.getDay() && other._dateOfBirth.getMonth() == _dateOfBirth.getMonth() && other._dateOfBirth.getYear() == _dateOfBirth.getYear());
    }

    /** Checks if two babies are twins.
     *
     * @param other The baby to compare this baby with.
     * @return True if the babies are twins.
     */
    public boolean areTwins(Baby other) {
        return (_lastName.equals(other._lastName) &&
                !_firstName.equals(other._firstName) &&
                !_id.equals(other._id) &&
                (_dateOfBirth.difference(other._dateOfBirth) <= 1));
    }

    /** Checks if the weight of this baby is heavier than the weight of another baby.
     *
     * @param other Baby to compare this baby's weight to.
     * @return True if the weight of this baby is heavier than the weight of the other baby.
     */
    public boolean heavier(Baby other) {
        return (_currentWeight.heavier(other._currentWeight));
    }

    /** Updates the baby's current weight by adding the additional grams.
     *
     * @param grams The number of grams to add to he baby's current weight (can be negative).
     */
    public void updateCurrentWeight(int grams) {
        _currentWeight = _currentWeight.add(grams);
    }

    /** Checks if the date of birth of this baby is before than the date of birth of another baby.
     *
     * @param other Baby to compare this baby's date of birth to.
     * @return True if the date of birth of this baby is before the date of birth of the other baby.
     */
    public boolean older(Baby other) {
        return (_dateOfBirth.before(other._dateOfBirth));
    }

    /** Checks if the current weight of this baby is within the valid range.
     *
     * @param numOfDays Of days passed since the baby was born.
     * @return 1- If the date given as a parameter is less than a week or more than a year.
     * 2- If the progress is not correct according to the rules.
     * 3- If the progress is correct according to the rules.
     */
    public int isWeightInValidRange(int numOfDays) {
        int dailyGrams = (10 * (_birthWeight.getKilos() * 1000 + _birthWeight.getGrams()) / 700);
        int baseWeight = dailyGrams * 7;
        int weightUntil60 = baseWeight + 30 * 53;
        int weightUntil120 = weightUntil60 + 25 * 60;
        int weightUntil240 = weightUntil120 + 16 * 120;

        if (numOfDays >= 0 && numOfDays <= 7) {
            return (_currentWeight.heavier(_birthWeight.add(dailyGrams * numOfDays))) ? 3 : 2;
        } else if (numOfDays >= 8 && numOfDays <= 60) {
            return (_currentWeight.heavier((_birthWeight.add(baseWeight + 30 * (numOfDays - 8))))) ? 3 : 2;
        } else if (numOfDays >= 61 && numOfDays <= 120) {
            return (_currentWeight.heavier((_birthWeight.add(weightUntil60 + 25 * (numOfDays - 60))))) ? 3 : 2;
        } else if (numOfDays >= 121 && numOfDays <= 240) {
            return (_currentWeight.heavier((_birthWeight.add(weightUntil120 + 16 * (numOfDays - 120))))) ? 3 : 2;
        } else if (numOfDays >= 241 && numOfDays <= 365) {
            return (_currentWeight.heavier((_birthWeight.add(weightUntil240 + 8 * (numOfDays - 240))))) ? 3 : 2;
        } else {
            return 1;
        }
    }
}