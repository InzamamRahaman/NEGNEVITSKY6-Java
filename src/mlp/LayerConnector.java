package mlp;

import linearalg.Vector;

/**
 * Created by inzamamrahaman on 07/09/2016.
 */
public class LayerConnector
{

    private Layer inputLayer;
    private Layer outputLayer;

    public LayerConnector(Layer outputLayer)
    {
        this.inputLayer = null;
        this.outputLayer = outputLayer;
    }

    public void setInputLayer(Layer inputLayer)
    {
        if(this.inputLayer == null)
        {
            this.inputLayer = inputLayer;
        }
    }

    public void backpropogate(Vector errorVec)
    {
        this.inputLayer.train(errorVec);
    }

}
