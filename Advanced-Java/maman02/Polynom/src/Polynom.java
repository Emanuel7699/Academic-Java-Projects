import java.util.ArrayList;

public class Polynom {
    private ArrayList<Polynom> Poly;
    double coefficient;
    int exponent;

    // Private constructor for a single term (coefficient and exponent)
    private Polynom (double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }


    // Constructor - builds a polynom from arrays of coefficients and exponents
    public Polynom (double[] coefficient, int[] exponent) throws Exception {
        if (coefficient.length != exponent.length) throw new Exception("Error: Arrays must be the same length");
        this.Poly = new ArrayList<>();
        for (int i = 0; i < coefficient.length; i++){
            this.Poly.add(new Polynom(coefficient[i], exponent[i]));
        }
        sort(); // Sort terms from highest to lowest exponent
    }


    // Returns a new polynom that is the sum of this polynom and other
    public Polynom plus (Polynom other) throws Exception {
        double[] coefs = new double[this.Poly.size() + other.Poly.size()];
        int[] exps = new int[this.Poly.size() + other.Poly.size()];
        int i = 0, j = 0, idx = 0;
        while (i < this.Poly.size() || j < other.Poly.size()) {
            if (i >= this.Poly.size() || (j < other.Poly.size() && (this.Poly.get(i).exponent < other.Poly.get(j).exponent))){
                coefs[idx] = other.Poly.get(j).coefficient;
                exps[idx] = other.Poly.get(j).exponent;
                j++;
            }
            else if (j >= other.Poly.size() || (i < this.Poly.size() && this.Poly.get(i).exponent > other.Poly.get(j).exponent)){
                coefs[idx] = this.Poly.get(i).coefficient;
                exps[idx] = this.Poly.get(i).exponent;
                i++;
            }
            else if (this.Poly.get(i).exponent == other.Poly.get(j).exponent){
                coefs[idx] = this.Poly.get(i).coefficient + other.Poly.get(j).coefficient;
                exps[idx] = this.Poly.get(i).exponent;
                i++;
                j++;
            }
            idx++;
        }
        return new Polynom(coefs, exps);
    }

    // Returns a new polynom that is the difference of this polynom and other
    public Polynom minus (Polynom other) throws Exception {
        double[] coefs = new double[this.Poly.size() + other.Poly.size()];
        int[] exps = new int[this.Poly.size() + other.Poly.size()];
        int i = 0, j = 0, idx = 0;
        while (i < this.Poly.size() || j < other.Poly.size()) {
            if (i >= this.Poly.size() || (j < other.Poly.size() && (this.Poly.get(i).exponent < other.Poly.get(j).exponent))){
                coefs[idx] = other.Poly.get(j).coefficient;
                exps[idx] = other.Poly.get(j).exponent;
                j++;
            }
            else if (j >= other.Poly.size() || (i < this.Poly.size() && this.Poly.get(i).exponent > other.Poly.get(j).exponent)){
                coefs[idx] = this.Poly.get(i).coefficient;
                exps[idx] = this.Poly.get(i).exponent;
                i++;
            }
            else if (this.Poly.get(i).exponent == other.Poly.get(j).exponent){
                coefs[idx] = this.Poly.get(i).coefficient - other.Poly.get(j).coefficient;
                exps[idx] = this.Poly.get(i).exponent;
                i++;
                j++;
            }
            idx++;
        }
        return new Polynom(coefs, exps);
    }

    // Returns a new polynom that is the derivative of this polynom
    public Polynom derivative () throws Exception {
        double[] coefs = new double[this.Poly.size()];
        int[] exps = new int[this.Poly.size()];
        for (int i = 0; i < this.Poly.size(); i++) {
            coefs[i] = this.Poly.get(i).coefficient * this.Poly.get(i).exponent;
            exps[i] = Math.max(0, this.Poly.get(i).exponent - 1);
        }
        return new Polynom(coefs, exps);
    }

    // Returns the polynom as a readable string
    public String toString() {
        String str = "";
        for (int i = 0; i < this.Poly.size(); i++) {
            if (this.Poly.get(i).coefficient == 0){
                continue;
            }
            if (this.Poly.get(i).exponent == 1) {
                str += (this.Poly.get(i).coefficient+ "x");
                continue;
            }
            if (this.Poly.get(i).exponent == 0) {
                str += this.Poly.get(i).coefficient;
                continue;
            }
            if (!str.isEmpty()) str += " + ";
            str += (this.Poly.get(i).coefficient + "x^" + this.Poly.get(i).exponent);
        }
        return str;
    }

    // Checks if two polynoms are equal
    public boolean equals(Object obj) {
        if (!(obj instanceof Polynom)) {return false;}
        Polynom other = (Polynom) obj;
        if (this.Poly.size() != other.Poly.size()) {return false;}
        for (int i = 0; i < this.Poly.size(); i++) {
            if (this.Poly.get(i).coefficient != other.Poly.get(i).coefficient || this.Poly.get(i).exponent != other.Poly.get(i).exponent){
                return false;}
        }
        return true;
    }

    // Sorts terms from highest to lowest exponent, combines terms with same exponent
    private void sort() {
        for (int i = 0; i < this.Poly.size()-1; i++) {
            for (int j = i + 1; j < this.Poly.size(); j++) {
                if (this.Poly.get(i).exponent == this.Poly.get(j).exponent) {
                    this.Poly.get(i).coefficient += this.Poly.get(j).coefficient;
                    this.Poly.remove(j);
                    j--;
                }
                if (this.Poly.get(i).exponent < this.Poly.get(j).exponent) {
                    Polynom temp = this.Poly.get(i);
                    this.Poly.set(i, this.Poly.get(j));
                    this.Poly.set(j, temp);
                }
            }
        }
    }
}