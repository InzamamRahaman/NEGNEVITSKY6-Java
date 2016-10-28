package linearalg;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */
public class RandomFactory
{

    private static RandomFactory factory;
    private Random randGen;



    private RandomFactory()
    {
        this.randGen = new Random();
    }

    public static synchronized RandomFactory getInstance()
    {
        if(factory == null)
        {
            factory = new RandomFactory();
        }
        return factory;
    }

    public int randInt(int min, int max)
    {
        return 0;
    }

    public double randDouble(double min, double max)
    {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public Vector randomVector(int length, double min, double max)
    {
        double[] temp = new double[length];
        for(int idx = 0; idx < length; idx++)
        {
            temp[idx] = this.randDouble(min, max);
        }
        return new Vector(temp);
    }

    public Matrix randomMatrix(int numRows, int numCols, double min, double max)
    {
        double[][] temp = new double[numRows][numCols];
        for(int idx = 0; idx < numRows; idx++)
        {
            for(int jdx = 0; jdx < numCols; jdx++)
            {
                temp[idx][jdx] = this.randDouble(min, max);
            }
        }
        return new Matrix(temp);
    }

}
