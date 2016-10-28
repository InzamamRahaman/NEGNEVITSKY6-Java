package funs;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */
public class StepFunction extends ActivationFunction
{

    private double point;

    public StepFunction()
    {
        this(0.5);
    }

    public StepFunction(double point)
    {
        this.point = point;
    }

    @Override
    public double eval(double x)
    {
        if(x < this.point - 0.000001)
        {
            return 0.0;
        }

        return 1.0;
    }
}
