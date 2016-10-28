package linearalg;

/**
 * Created by inzamamrahaman on 05/09/2016.
 */
public final class Matrix
{
    private double[][] mat;
    private int numRows;
    private int numCols;

    public Matrix(double[][] mat)
    {
        this.mat = mat;
        this.numRows = mat.length;
        this.numCols = mat[0].length;
    }

    public double m(int row, int col)
    {
        return this.mat[row][col];
    }

    public Matrix scalarMultiply(double scalar)
    {
        double[][] temp = new double[this.numRows][this.numCols];
        for(int idx = 0; idx < this.numRows; idx++)
        {
            for(int jdx = 0; jdx < this.numCols; jdx++)
            {
                temp[idx][jdx] = this.m(idx, jdx) * scalar;
            }
        }
        return new Matrix(temp);
    }

    public Matrix transpose()
    {
        double[][] temp = new double[this.numCols][this.numRows];
        for(int idx = 0; idx < this.numRows; idx++)
        {
            for(int jdx = 0; jdx < this.numCols; jdx++)
            {
                temp[jdx][idx] = this.m(idx, jdx);
            }
        }
        return new Matrix(temp);
    }

    public Matrix add(Matrix other)
    {
        double[][] temp = new double[this.numRows][this.numCols];
        for(int idx = 0; idx < this.numRows; idx++)
        {
            for(int jdx = 0; jdx < this.numCols; jdx++)
            {
                temp[idx][jdx] = this.m(idx, jdx) + other.m(idx, jdx);
            }
        }
        return new Matrix(temp);
    }

    public Matrix subtract(Matrix other)
    {
        return this.add(other.scalarMultiply(-1));
    }

    public Vector rowSlice(int row)
    {
        double[] vec = new double[this.numCols];
        for(int jdx = 0; jdx < this.numCols; jdx++)
        {
            vec[jdx] = this.m(row, jdx);
        }
        return new Vector(vec);
    }

    public Vector colSlice(int col)
    {
        double[] vec = new double[this.numRows];
        System.out.println("rows: " + this.numRows);
        for(int idx = 0; idx < this.numRows; idx++)
        {
            vec[idx] = this.m(idx, col);
        }
        return new Vector(vec);
    }

    public static Matrix zeros(int m, int n)
    {
        double matrix[][] = new double[m][n];
        return new Matrix(matrix);
    }

    public static Matrix id(int n)
    {
        double matrix[][] = new double[n][n];
        for(int idx = 0; idx < n; idx++)
        {
            matrix[idx][idx] = 1;
        }
        return new Matrix(matrix);
    }



    public Matrix multiply(Matrix M)
    {
        double[][] temp = new double[this.numRows][this.numCols];
        for(int idx = 0; idx < this.numRows; idx++)
        {
            for(int jdx = 0; jdx < M.numCols; jdx++)
            {
                System.out.println(M.numCols);
                System.out.println(jdx);
                Vector v1 = this.rowSlice(idx);
                Vector v2 = this.colSlice(jdx);
                double prod = v1.dotProduct(v2);
                temp[idx][jdx] = prod;
                System.out.println(temp[idx][jdx]);
            }
        }
        return new Matrix(temp);
    }



    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int idx = 0; idx < this.numRows; idx++)
        {
            for(int jdx = 0; jdx < this.numCols; jdx++)
            {
                sb.append(this.m(idx, jdx));
                if(jdx + 1 < this.numCols)
                {
                    sb.append(",");
                }
                else if(idx + 1 < this.numRows)
                {
                    sb.append(";");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }
}
