package perceptron;


import funs.ActivationFunction;
import funs.StepFunction;
import linearalg.RandomFactory;
import linearalg.Vector;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */

public class Perceptron
{

    private double alpha;
    private int numInputs;
    private int numOutputs;

    private RandomFactory randFactory;
    private Vector weights;
    private double threshold;
    private ActivationFunction f;

    public Perceptron(int numInputs, double alpha)
    {

        this.alpha = alpha;
        this.numInputs = numInputs;

        this.randFactory = RandomFactory.getInstance();
        this.f = new StepFunction(0.0);
        this.weights = randFactory.randomVector(numInputs, -0.5, 0.5);
        this.threshold = randFactory.randDouble(0, 0.5);
    }

    public Perceptron(int numInputs)
    {
        this(numInputs, 0.1);
    }


    public double eval(Vector x)
    {
        double pre_y = (x.dotProduct(this.weights) - this.threshold);
        double y = this.f.eval(pre_y);
        return y;
    }

    public int train(Vector[] inputs, double[] targets)
    {
        int numTraining = inputs.length;
        int count = 0;
        Vector old = this.weights;
        boolean converged = false;
        while(converged == false)
        {
            old = this.weights;
            //System.out.println("-------------------------");
            for(int idx = 0; idx < numTraining; idx++)
            {
                Vector x = inputs[idx];
                double actualY = this.eval(x);
                double targetY = targets[idx];
                double error = targetY - actualY;
//                System.out.println(actualY);
//                System.out.println(targetY);
//                System.out.println(error);
                Vector delta = x.scalarMultiply(this.alpha);
//                System.out.println(delta.toString());
                delta = delta.scalarMultiply(error);
//                System.out.println(delta.toString());
                this.weights = this.weights.add(delta);
//                System.out.println(this.weights.toString());
            }
            count++;
            converged = old.equals(this.weights);
//            System.out.println(converged);
//            System.out.println(old.toString());
//            System.out.println(this.weights.toString());
        }

//        System.out.println(this.weights.toString());
//        System.out.println(this.threshold);
        return count;
    }

    public void setWeights(Vector weights) {
        this.weights = weights;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}

