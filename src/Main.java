import linearalg.Matrix;
import linearalg.Vector;
import perceptron.Perceptron;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */
public class Main
{

//    public static void main(String[] args)
//    {
//        Vector[] inputs = new Vector[4];
//        double[][] temp =
//                {
//                        {0, 0},
//                        {0, 1},
//                        {1, 0},
//                        {1, 1}
//                };
//
//        for(int idx = 0; idx < 4; idx++)
//        {
//            inputs[idx] = new Vector(temp[idx]);
//        }
//
//        double[] targets = {0, 0, 0, 1};
//
//        Perceptron perceptron = new Perceptron(2);
//        double[] d = {0.3, -0.1};
//        //perceptron.setWeights((new Vector(d)));
////        perceptron.setThreshold(0.2);
//
//        System.out.println("Starting training.....");
//
//        int numIterations = perceptron.train(inputs, targets);
//
//        System.out.println("Finished training in " + numIterations);
//
//        for(int idx = 0; idx < 4; idx++)
//        {
//            System.out.println(perceptron.eval(inputs[idx]));
//        }
//
////        double[] v = {0.09999999999999998, 0.1};
////        Vector v1 = new Vector(v);
////        Vector v2 = new Vector(v);
////        System.out.println(v1.equals(v2));
//
//
//    }

    public static void main(String[] args)
    {
        double[][] arr = {
                {2, 3},
                {4, 5}
        };
        double[] vec = {1, 2};
        Matrix m = new Matrix(arr);
        Matrix n = m.multiply(m);
        Vector v = new Vector(vec);
        System.out.println(v);
        System.out.println(v.applyToMatrix(m));
        System.out.println(n);
        System.out.println(v.outerProduct(v));

//        Matrix col = v.toColumnMatrix();
//        Matrix row = v.toMatrix();
//        System.out.println(col);
//        System.out.println(row);
//        System.out.println(col.getNumRows());
//        System.out.println(col.getNumCols());
//        //System.out.println(col.multiply(row));
    }

}
