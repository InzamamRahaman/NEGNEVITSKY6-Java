package funs;

/**
 * Created by inzamamrahaman on 07/09/2016.
 */
public class SigmoidFunction extends ActivationFunction
{

    @Override
    public double eval(double x)
    {
        double denom = 1 + Math.exp(-1 * x);
        return 1.0 / denom;
    }
}
