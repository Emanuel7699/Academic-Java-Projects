/** public class Weight extends Object.
 * This class represents a Weight object.
 *
 * @author Emanuel Abraham
 * @version 27/11/2024 (2025a)
 */

public class Weight {
    private int _kilos;
    private int _grams;

    private final byte MIN_KILOS = 1;
    private final byte MIN_GRAMS = 0;
    private final short MAX_GRAMS = 999;
    private final short THOUSAND_IN_MATH = 1000;
    private final byte TEN_IN_MATH = 10;
    private final byte HUNDRED_IN_MATH = 100;
    private final byte ZERO_IN_MATH = 0;

    /** Weight constructor - If the given weight is valid - creates a new Weight object,
     *  otherwise if one of the parameters in not valid initialize it to 1.
     *
     * @param kilos The number of kilos in Weight (greater or equal to 1).
     * @param grams The number of grams in Weight (0-999).
     */
    public Weight(int kilos, int grams){
        if ((kilos > MIN_KILOS) && (grams > MIN_GRAMS && grams < MAX_GRAMS)){
            _kilos = kilos;
            _grams = grams;
        }
        else {
            _kilos = MIN_KILOS;
            _grams = MIN_GRAMS;
        }
    }

    /** Copy constructor.
     *
     * @param other The weight to be copied.
     */
    public Weight (Weight other){
        this(other._kilos, other._grams);
    }

    /** Constructor with only one parameter.
     *
     * @param totalGrams The total number of grams.
     */
    public Weight(int totalGrams){
        if((totalGrams%THOUSAND_IN_MATH < MIN_GRAMS) || (totalGrams%THOUSAND_IN_MATH == MIN_GRAMS && totalGrams/THOUSAND_IN_MATH == MIN_GRAMS)){
            _kilos = MIN_KILOS;
            _grams = MIN_GRAMS;
        }
        else{
            _kilos = totalGrams/THOUSAND_IN_MATH;
            _grams = totalGrams%THOUSAND_IN_MATH;
        }
    }

    /** Gets the kilos.
     *
     * @return The number of kilos for this weight.
     */
    public int getKilos(){
        return _kilos;
    }

    /** Gets the grams.
     *
     * @return The number of grams for this weight.
     */
    public int getGrams(){
        return _grams;
    }

    /** Checks if two weights are the same.
     *
     * @param other The weight to compare this weight to.
     * @return True if the weights are the same.
     */
    public boolean equals (Weight other){
        return (other._kilos == _kilos && other._grams == _grams);
    }

    /** Checks if this weight is lighter than another weight.
     *
     * @param other Weight to compare this weight to.
     * @return True if this weight is lighter than the other weight.
     */
    public boolean lighter (Weight other){
        return ((_kilos < other._kilos) || ((_kilos == other._kilos) && (_grams < other._grams)));
    }

    /** Checks if this weight is heavier than another weight.
     *
     * @param other Weight to compare this weight to.
     * @return True if this weight is heavier than the other weight.
     */
    public boolean heavier (Weight other) {
        return (!(this.lighter(other)) && other.lighter(this));
    }

    /** Returns a String that represents this weight.
     *
     * @Overrides toString in class Object.
     * @return A String that represents this weight in the following format: kiols.grmas(3 digits) for example: 4.07 or 3.055 or 4.005
     */
    public String toString() {
        if (_grams % TEN_IN_MATH != ZERO_IN_MATH){
            if(_grams / HUNDRED_IN_MATH != ZERO_IN_MATH){
                return (_kilos + "." + _grams);//101,111
            }
            else if(_grams / TEN_IN_MATH % TEN_IN_MATH == ZERO_IN_MATH){
                    return (_kilos + ".00" + _grams);//001
            }
            return (_kilos + ".0" + _grams);//011
        }
        else{
            if (_grams / HUNDRED_IN_MATH == ZERO_IN_MATH && _grams / TEN_IN_MATH % TEN_IN_MATH != ZERO_IN_MATH){
                return (_kilos + ".0" + _grams / TEN_IN_MATH);//010
            }
            else if(_grams / TEN_IN_MATH % TEN_IN_MATH != ZERO_IN_MATH){
                return (_kilos + "." + _grams / TEN_IN_MATH);//110
            }
        }
        return (_kilos + "." + _grams / HUNDRED_IN_MATH);//100,000
    }

    /** Return a new weight with the additional grams given as parameter.
     *
     * @param grams The additional grams to add to the new returned weight.
     * @return A new weight with the additional grams given as parameter.
     */
    public Weight add (int grams){
        int newGrams = _grams, newKilos = _kilos;
        if(((_kilos*THOUSAND_IN_MATH + _grams + grams)/THOUSAND_IN_MATH) >= MIN_KILOS){
            newKilos = ((_kilos*THOUSAND_IN_MATH + _grams + grams)/THOUSAND_IN_MATH);
            newGrams = ((_kilos*THOUSAND_IN_MATH + _grams + grams)%THOUSAND_IN_MATH);
        }
        return new Weight(newKilos, newGrams);
    }
}


