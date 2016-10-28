package funs;

import linearalg.Vector;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */
public abstract class ActivationFunction
{


    public abstract double eval(double x);

    /*
     * Implements the activation function across all elements of a vector
     * @param x: the vector to which the function is applied
     * @return: a vector with the activation function applied
     */
    public Vector eval(Vector x)
    {
        int length = x.getLength();
        double[] temp = new double[length];
        for(int idx = 0; idx < length; idx++)
        {
            temp[idx] = this.eval(x.v(idx));
        }
        return new Vector(temp);
    }



}
