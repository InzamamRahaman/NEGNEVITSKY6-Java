package mlp;

import funs.ActivationFunction;

/**
 * Created by inzamamrahaman on 19/09/2016.
 */
public class LayerFactory
{
    private static LayerFactory factory;
    private ActivationFunFactory activationFuncGen;
    private ActivationFun function;
    private double alpha;
    private double beta;
    private Layer previousLayer;

    private LayerFactory(ActivationFun function, double alpha, double beta)
    {
        this.function = function;
        this.activationFuncGen = ActivationFunFactory.getInstance();
        this.alpha = alpha;
        this.beta = beta;
        this.previousLayer = null;
    }

    public static LayerFactory getInstance(ActivationFun function, double alpha, double beta)
    {
        if(factory == null)
        {
            factory = new LayerFactory(function, alpha, beta);
        }
        return factory;
    }

    public Layer createLayer(int numInputs, int numOutputs)
    {
        ActivationFunction af = activationFuncGen.createFunction(this.function);
        Layer l = new Layer(numInputs, numOutputs, af, this.alpha, this.beta);
        l.connect(this.previousLayer);
        this.previousLayer = l;
        return l;
    }
}
