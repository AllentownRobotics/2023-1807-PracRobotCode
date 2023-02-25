package frc.robot;

public class LagBehind {
    double value;
    double error;

    public LagBehind(double initialValue){
        this.value = initialValue;
        error = 0;
    }

    public void update(double nextValue){
        value = (value + nextValue / 2);
        error = Math.abs(nextValue - value);
    }

    public double getValue(){
        return value;
    }

    public double getError(double testValue){
        return error;
    }
}
