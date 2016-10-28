package mlp;

import funs.ActivationFunction;
import funs.SigmoidFunction;

/**
 * Created by inzamamrahaman on 19/09/2016.
 */
public class ActivationFunFactory
{
    private static ActivationFunFactory instance;

    private ActivationFunFactory()
    {

    }

    public static ActivationFunFactory getInstance()
    {
        if(instance == null)
        {
            instance = new ActivationFunFactory();
        }
        return instance;
    }

    public ActivationFunction createFunction(ActivationFun specification)
    {
        if(specification == ActivationFun.EXPONENTIAL_SIGMOID)
        {
            return (new SigmoidFunction());
        }

        if(specification == ActivationFun.HYPERBOLIC_TANGENT)
        {
            return null;
        }

        return null;
    }
}
