package frc.robot;

public class LagBehind {
    double value;
    double error;

    public LagBehind(double initialValue){
        this.value = initialValue;
        error = 0;
    }

    /**
     * Updates the running average by calculating the 
     * @param nextValue
     */
    public void update(double nextValue){
        value = (value + nextValue / 2);
        error = Math.abs(nextValue - value);
    }

    /**
     * Returns the running average
     * @return the running average
     */
    public double getValue(){
        return value;
    }

    /**
     * Returns the absolute difference between the last value the average was updated with and the running average
     * @return the absolute error between the last update value and the running average
     */
    public double getError(){
        return error;
    }

    /**
     * Resets the running average to the reset value and the error to 0
     * @param resetValue the value for the running average to be set to
     */
    public void reset(double resetValue){
        value = resetValue;
        error = 0;
    }
}
