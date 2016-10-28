package funs;

/**
 * Created by inzamamrahaman on 25/10/2016.
 */
public class HyperbolicTangent extends ActivationFunction
{

    private double a;
    private double b;
    private double numer;

    public HyperbolicTangent(double a, double b)
    {
        this.a = a;
        this.b = b;
        this.numer = 2 * a;
    }

    public HyperbolicTangent()
    {
        this(1.716, 0.667);
    }

    @Override
    public double eval(double x)
    {
        double denom = 1 + Math.exp(-1 * this.b * x);
        double component = this.numer / denom;
        double ans = component - this.a;
        return ans;
    }
}
