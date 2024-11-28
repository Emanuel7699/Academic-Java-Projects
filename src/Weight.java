/** public class Date extends Object.
 * This class represents a Date object.
 *
 * @author Emanuel Abraham
 * @version 27/11/2024 (2025a)
 */

public class Weight {
    private int _kilos;
    private int _grams;

    private final int MIN_KILOS = 1;
    private final int MIN_GRAMS = 0;
    private final int MAX_GRAMS = 999;

    /**
     *
     * @param kilos
     * @param grams
     */
    public Weight(int kilos, int grams){
        if (kilos < MIN_KILOS){
            _kilos = MIN_KILOS;
        }
        else {
            _kilos = kilos;
        }
        if (grams < MIN_GRAMS || grams > MAX_GRAMS){
            _grams = MIN_GRAMS;
        }
        else{
            _grams = grams;
        }
    }

    /**
     *
     * @param other
     */
    public Weight (Weight other){
        this(other._kilos, other._grams);
    }

    /**
     *
     * @param totalGrams
     */
    public Weight(int totalGrams){
        if((totalGrams%1000 < MIN_GRAMS) || (totalGrams%1000 == MIN_GRAMS && totalGrams/1000 == MIN_GRAMS)){
            _kilos = MIN_KILOS;
            _grams = MIN_GRAMS;
        }
        else{
            _kilos = totalGrams/1000;
            _grams = totalGrams%1000;
        }
    }

    /**
     *
     * @return
     */
    public int getKilos(){
        return _kilos;
    }

    /**
     *
     * @return
     */
    public int getGrams(){
        return _grams;
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals (Weight other){
        return (other._kilos == _kilos && other._grams == _grams);
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean lighter (Weight other){
        return ((_kilos < other._kilos) || ((_kilos == other._kilos) && (_grams < other._grams)));
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean heavier (Weight other) {
        return (!(this.lighter(other)) && other.lighter(this));
    }

    /**
     *
     * @return
     */
    public String toString() {
        if (_grams % 10 != 0){
            if(_grams / 100 != 0){
                return (_kilos + "." + _grams);//101,111
            }
            else if(_grams / 10 % 10 == 0){
                    return (_kilos + ".00" + _grams);//001
            }
            return (_kilos + ".0" + _grams);//011
        }
        else{
            if (_grams / 100 == 0 && _grams / 10 % 10 != 0){
                return (_kilos + ".0" + _grams / 10);//010
            }
            else if(_grams / 10 % 10 != 0){
                return (_kilos + "." + _grams / 10);//110
            }
        }
        return (_kilos + "." + _grams / 100);//100,000
    }

    /**
     *
     * @param grams
     * @return
     */
    public Weight add (int grams){
        int newGrams = _grams, newKilos = _kilos;
        if(((_kilos*1000 + _grams + grams)/1000) >= MIN_KILOS){
            newKilos = ((_kilos*1000 + _grams + grams)/1000);
            newGrams = ((_kilos*1000 + _grams + grams)%1000);
        }
        return new Weight(newKilos, newGrams);
    }
}


