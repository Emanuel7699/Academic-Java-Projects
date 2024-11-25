public class Weight {
    private int _kilos;
    private int _grams;

    private final int MIN_kilos = 1;
    private final int MIN_grams = 0;
    private final int MAX_grams = 999;


    public Weight(int kilos, int grams){
        if (kilos < MIN_kilos){
            _kilos = MIN_kilos;
        }
        else{
            _kilos = kilos;
        }
        if (grams < MIN_grams){
            _grams = MIN_grams;
        }
        else{
            _grams = grams;
        }
    }

    public Weight (Weight other){
        this(other._kilos, other._grams);
    }

    public Weight(int totalGrams){
        if(totalGrams%1000 < MIN_grams || totalGrams%1000 > MAX_grams){
            _kilos = MIN_kilos;
            _grams = MIN_grams;
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
            return (_kilos + "." + MIN_grams);
        }
        return (_kilos + "." + _grams / 10);
    }

    public Weight add (int grams){
        if(((_kilos*1000 + _grams + grams)/1000) > MIN_kilos){
            _kilos = ((_kilos*1000 + _grams + grams)/1000);
            _grams = ((_kilos*1000 + _grams + grams)%1000);
        }
        return this;
    }


//        if(_grams%10 != 0) {
//            if (_grams / 100 == 0) {
//                if (_grams / 10 % 10 == 0) {
//                    return (_kilos + ".00" + _grams);
//                }
//                return (_kilos + ".0" + _grams);
//            }
//        }
//        else{
//            if (_grams / 100 == 0) {
//                if (_grams / 10 % 10 == 0) {
//                    return (_kilos + "." + MIN_grams);
//                }
//                return (_kilos + ".0" + _grams/10);
//            }
//        }
//        return (_kilos + "." + _grams/10);
//    }
}


