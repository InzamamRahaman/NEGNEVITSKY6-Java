package mlp;

import funs.ActivationFunction;
import linearalg.Matrix;
import linearalg.RandomFactory;
import linearalg.Vector;

/**
 * Created by inzamamrahaman on 07/09/2016.
 */
public class Layer
{

    private int numInputs;
    private int numOutputs;
    private Matrix weights;
    private Matrix deltaWeights;
    private ActivationFunction f;
    private LayerConnector connector;
    private double beta;
    private double alpha;
    private boolean isLast;
    private Vector lastOutput;
    private Vector lastInput;
    private boolean isFirst;

    public Layer(int numInputs, int numOutputs, ActivationFunction f, double beta, double alpha)
    {
        this.numInputs = numInputs;
        this.numOutputs = numOutputs;
        this.weights = RandomFactory.getInstance().randomMatrix(numInputs, numOutputs,
                -2.4 / numInputs, 2.4 / numInputs);
        this.deltaWeights = Matrix.zeros(numInputs, numOutputs);
        this.f = f;
        this.connector = new LayerConnector(this);
        this.alpha = alpha;
        this.beta = beta;
        this.isLast = false;
        this.isFirst = false;
    }

    public void setIsLast(boolean isLast)
    {
        this.isLast = isLast;
    }

    public void setIsFirst(boolean isFirst) {this.isFirst = isFirst; }

    public void connect(Layer prevLayer)
    {
        this.connector.setInputLayer(prevLayer);
    }


    public Vector eval(Vector x)
    {
        Vector y = x.applyToMatrix(this.weights);
        this.lastOutput = y;
        this.lastInput = x;
        return f.eval(y);
    }

    public void train(Vector errorVec)
    {
        if(!this.isFirst)
        {
            Vector gradient = this.lastOutput.multiply(this.lastOutput.add(1.0));
            gradient = gradient.multiply(errorVec);
            Matrix delta = this.lastInput.outerProduct(gradient).scalarMultiply(this.alpha);
            Vector errorGradient = gradient.applyToMatrix(this.weights);
            this.weights = this.weights.add(delta);
            this.connector.backpropogate(errorGradient);
        }
    }


}
