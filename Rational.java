/**
 * A class that represents a rational number in normal form where the numerator
 * and the denominator share no common factors and only the numerator
 * can be negative.
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    // private data fields to hold state for rational object (step 2)
    private int numerator;
    private int denominator;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        // constructor for rational number 1 (step 3)
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
        // completing alternate constructor, throw zero dem exception (step 5)
        if (d == 0) {
            throw new ArithmeticException("Denominator can't be 0.");
        }
        this.numerator = n;
        this.denominator = d;
        // normalize rational number
        normalize();
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // complete get numerator method (step 6)
        return this.numerator;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // complete get denominator method (step 7)
        return this.denominator;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        // dont change rational number, return new rational object, positive den (step 8)
        return new Rational(-this.numerator, this.denominator);
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
        // step 9, reciprocal method
        if (this.numerator == 0) {
            throw new ArithmeticException("Can't invert rational number.");
        }
        // swap
        return new Rational(this.denominator, this.numerator);
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        // add other method, step 10
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        // add normalize so that it returns simplest
        result.normalize();
        return result;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        // subtract method step 11
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        // add normalize so that it returns simplest
        result.normalize();
        return result;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        // multiply other method
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        // add normalize so that it returns simplest
        result.normalize();
        return result;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
        // step 14  complete method divide other
        if (other.numerator == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        Rational result = new Rational(newNumerator, newDenominator);
        // add normalize so that it returns simplest
        result.normalize();
        return result;
    }
     
      
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * can be negative.
     *
     */
    private void normalize()
    {
        // putting rational # in normal form (step 4) (gcd)
        // make sure num and dem are lowest possible value w gcd
        int gcd = gcd(Math.abs(numerator), denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;

        //make sure only num is negative!!
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }


    }
    
    /**
     * Recursively compute the greatest common divisor of two *positive* integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
