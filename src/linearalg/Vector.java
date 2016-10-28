package linearalg;

public final class Vector
{

    private double[] vec;
    private int length;


    public Vector(double[] vec) {
        this.vec = vec;
        this.length = vec.length;
    }

    public Matrix toMatrix()
    {
        double matrix[][] = new double[1][this.length];
        for(int idx = 0; idx < this.length; idx++)
        {
            matrix[0][idx] = this.vec[idx];
        }
        return new Matrix(matrix);
    }

    public Matrix toColumnMatrix()
    {
        return this.toMatrix().transpose();
    }

    public double euclideanDistance(Vector other)
    {
        Vector sub = this.subtract(other);
        Vector mult = sub.multiply(sub);
        double sumSquare = mult.sumComponents();
        return Math.sqrt(sumSquare);
    }

    public int getLength() {
        return this.length;
    }

    public double sumComponents()
    {
        double sum = 0;
        for(int idx = 0; idx < this.length; idx++)
        {
            sum += this.v(idx);
        }
        return sum;
    }

    public double v(int idx) {
        return this.vec[idx];
    }

    public Vector scalarMultiply(double scalar)
    {
        double[] temp = new double[this.length];
        for (int idx = 0; idx < length; idx++) {
            temp[idx] = this.vec[idx] * scalar;
        }
        return new Vector(temp);
    }


    public Vector add(Vector other) {
        double[] temp = new double[this.length];
        for (int idx = 0; idx < this.length; idx++) {
            temp[idx] = this.v(idx) + other.v(idx);
        }
        return new Vector(temp);
    }

    public Vector multiply(Vector other) {
        double[] temp = new double[this.length];
        for (int idx = 0; idx < this.length; idx++) {
            temp[idx] = this.v(idx) * other.v(idx);
        }
        return new Vector(temp);
    }

    public Vector add(double x)
    {
        double vec[] = new double[this.length];
        for(int idx = 0; idx < this.length; idx++)
        {
            vec[idx] = this.vec[idx] + x;
        }
        return new Vector(vec);
    }

    public Matrix outerProduct(Vector other)
    {
        int numRows = this.length;
        int numCols = other.length;
        double matrix[][] = new double[numRows][numCols];

        for(int idx = 0; idx < numRows; idx++)
        {
            Vector temp = other.scalarMultiply(this.v(idx));
            System.arraycopy(temp.vec, 0, matrix[idx], 0, temp.length);
        }
        return new Matrix(matrix);
    }


    public Vector subtract(Vector other) {
        return this.add(other.scalarMultiply(-1.0));
    }

    public double dotProduct(Vector other)
    {
        double sum = 0.0;
        for(int idx = 0; idx < this.length; idx++)
        {
            sum += this.v(idx) * other.v(idx);
        }
        return sum;
    }


    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int idx = 0; idx < this.length; idx++)
        {
            sb.append(this.v(idx));

            if(idx + 1 < length)
            {
                sb.append("; ");
            }

        }

        sb.append("]");
        return sb.toString();
    }

    public static double dotProduct(double[] vec1, double[] vec2)
    {
        return (new Vector(vec1)).dotProduct((new Vector(vec2)));
    }

    public boolean equals(Object obj)
    {
        if(obj != null && obj instanceof Vector)
        {

            int length1 = this.length;
            Vector v = (Vector) obj;
            int length2 = v.length;

            if (length1 != length2)
            {
                return false;
            }
            boolean vals = true;
            for(int idx = 0; idx < length1; idx++)
            {
               vals = vals & NumericUtilities.doubleEquals(this.v(idx), v.v(idx));
            }
            return vals;
        }

        return false;

    }

    public Vector applyToMatrix(Matrix M)
    {

        int numCols = M.getNumCols();
        int numRows = M.getNumRows();
        double[] newVec = new double[numCols];
        for (int idx = 0; idx < numCols; idx++)
        {
            newVec[idx] = this.dotProduct(M.colSlice(idx));
        }

        return new Vector(newVec);

    }





}
