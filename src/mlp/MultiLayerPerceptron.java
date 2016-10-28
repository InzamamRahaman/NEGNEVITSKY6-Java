package mlp;

import linearalg.Vector;

/**
 * Created by inzamamrahaman on 07/09/2016.
 */
public class MultiLayerPerceptron
{

    private Layer[] layers;
    private LayerFactory layerFactory;
    private Layer lastLayer;
    private double errorLimit;

    public MultiLayerPerceptron(int numInput, int numOutput, ActivationFun layerSpecs,
                                int[] sizes, double alpha, double beta, double errorLimit)
    {
        int numHiddenLayers = sizes.length;
        this.layerFactory = LayerFactory.getInstance(layerSpecs, alpha, beta);
        this.layers = new Layer[numHiddenLayers + 1];
        this.layers[0] = this.layerFactory.createLayer(numInput, sizes[0]);
        this.errorLimit = errorLimit;

        for(int idx = 1; idx < numHiddenLayers; idx++)
        {
            this.layers[idx] = this.layerFactory.createLayer(sizes[idx - 1], sizes[idx]);
        }

        this.lastLayer = this.layerFactory.createLayer(sizes[numHiddenLayers - 1], numOutput);
        this.lastLayer.setIsLast(true);
        this.layers[numHiddenLayers] = this.lastLayer;
        this.layers[0].setIsFirst(true);
    }

    public Vector eval(Vector v)
    {
        Vector y = v;
        for(Layer l : this.layers)
        {
            y = l.eval(y);
        }
        return y;
    }

    public int train(Vector[] vecs, Vector[] targets, double maxError)
    {
        boolean converged = false;
        double errorSum = 0;
        Vector errorVec = null;
        int epochs = 0;

        while(converged ==  false)
        {

            errorSum = 0.0;
            for(int idx = 0; idx < vecs.length; idx++)
            {
                Vector y = this.eval(vecs[idx]);
                errorVec = targets[idx].subtract(y);
                this.lastLayer.train(errorVec);
                errorSum += y.euclideanDistance(targets[idx]);

            }

            if(errorSum <= this.errorLimit)
            {
                converged = true;
            }
            else
            {
                epochs++;
            }

        }
        return epochs;
    }

}
