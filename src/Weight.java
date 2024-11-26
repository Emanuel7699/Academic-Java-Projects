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


    public Weight(int kilos, int grams){
        if (kilos < MIN_KILOS){
            _kilos = MIN_KILOS;
        }
        else {
            _kilos = kilos;
        }
        if (grams < MIN_GRAMS){
            _grams = MIN_GRAMS;
        }
        else{
            _grams = grams;
        }
    }

    public Weight (Weight other){
        this(other._kilos, other._grams);
    }

    public Weight(int totalGrams){
        if(totalGrams%1000 < MIN_GRAMS || totalGrams%1000 > MAX_GRAMS){
            _kilos = MIN_KILOS;
            _grams = MIN_GRAMS;
        }
        else{
            _kilos = totalGrams/1000;
            _grams = totalGrams%1000;
        }
    }

    public int getKilos(){
        return _kilos;
    }

    public int getGrams(){
        return _grams;
    }

    public boolean equals (Weight other){
        return (_kilos == other._kilos && _grams == other._grams);
    }

    public boolean lighter (Weight other){
        return ((_kilos < other._kilos) || ((_kilos == other._kilos) && (_grams < other._grams)));
    }

    public boolean heavier (Weight other) {
        return (!(this.lighter(other)) && !(this.equals(other)));
    }

    public String toString() {
        if ((_grams % 10 != 0) && (_grams / 100 == 0) && (_grams / 10 % 10 == 0)) {
            return (_kilos + ".00" + _grams);
        }
        else if ((_grams%10 != 0) && (_grams / 100 == 0)) {
            return (_kilos + ".0" + _grams);
        }
        else if ((_grams%10 == 0) && (_grams / 100 == 0) && (_grams / 10 % 10 != 0)) {
            return (_kilos + ".0" + _grams / 10);
        }
        else if ((_grams % 10 == 0) && (_grams / 100 == 0)) {
            return (_kilos + "." + MIN_GRAMS);
        }
        return (_kilos + "." + _grams / 10);
    }

    public Weight add (int grams){
        if(((_kilos*1000 + _grams + grams)/1000) > MIN_KILOS){
            _kilos = ((_kilos*1000 + _grams + grams)/1000);
            _grams = ((_kilos*1000 + _grams + grams)%1000);
        }
        return this;
    }
}


