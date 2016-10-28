package linearalg;

/**
 * Created by inzamamrahaman on 06/09/2016.
 */
public class NumericUtilities
{

    /*
     *  Compares two doubles and test if they are within EPSILON of each other
     *   @param a: the first number
     *   @param b: the second number
     *   @return: whether a and b are close enough to be considered equal
     */
    public static boolean doubleEquals(double a, double b)
    {
        double EPSILON = 0.000001;
        if(Math.abs(a - b) <= EPSILON)
        {
            return true;
        }
        return false;
    }

}
