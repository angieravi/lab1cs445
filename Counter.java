
/**
 * A counter that will roll over to the min
 * value when attempting to increase it beyond the maximum value and to the max 
 * value when attempting to decrease it below the min value
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter {
    // private data fields that will hold state of counter object (step 2)
    private int min;
    private int max;
    private int value;
    private boolean rolledOver;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter() {
        // step 3, default constructor making
        this.min = 0;
        this.max = Integer.MAX_VALUE;
        this.value = min;
        this.rolledOver = false;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max) throws CounterInitializationException
    { 
        // complete alternate constructor, step 4 
        if (min >= max) {
            throw new CounterInitializationException("Minimum can't be greater or equal to the max.");
        }
        // declaring mins/maxes
        this.min = min;
        this.max = max;
        this.value = min;
        this.rolledOver = false;   
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    //adjust original code to make sure that it takes into account counter instance
    @Override
    public boolean equals(Object otherObject)
    // step 6, completing equals method
    {   if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Counter other = (Counter) otherObject; // make sure values are same
        return this.min == other.min &&
               this.max == other.max &&
               this.value == other.value &&
               this.rolledOver == other.rolledOver;
    }

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        // step 7, completing value method
        if (value >= max) {
            value = min;
            rolledOver = true;
        } else {
            value ++ ;
            rolledOver = false;
        }
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease() {
        // step 8, completing rolled over methods
        if (value <= min) {
            value = max;
            rolledOver = true;
        } else {
            value--;
            rolledOver = false;
        }
    } 
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value() {
        // current value returning, increase method completing, counter is this.value , step 9
        return this.value;
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        // completing decrease method, returning rolled over, step 10
        return this.rolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    @Override
    public String toString() {
        // step 5, string that describes object being returned
        return "Counter: value=" + value + " min=" + min + " max=" + max + " rolledOver=" + rolledOver;
    }

}
