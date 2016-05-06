package com.mobiledev.topimpamatrix;

import org.ejml.data.CDenseMatrix64F;
import org.ejml.data.Complex64F;
import org.ejml.data.DenseMatrix64F;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larspmayrand on 4/24/16.
 */
public class MatrixHelperTest {

    private Complex64F[] complexNumbers;
    private DenseMatrix64F identity;
    private CDenseMatrix64F zeroMatrix;
    private CDenseMatrix64F complexIdentity;
    private CDenseMatrix64F complexMatrix;
    private CDenseMatrix64F realMatrix;
    private CDenseMatrix64F complexVector;
    private CDenseMatrix64F realVector;
    private CDenseMatrix64F complexNumber;
    private CDenseMatrix64F realNumber;

    @Before
    public void setup() {
        complexNumbers = new Complex64F[]{new Complex64F(1, 1), new Complex64F(1, 1)};
        identity = new DenseMatrix64F(new double[][]{{1, 0},{0, 1}});

        zeroMatrix = new CDenseMatrix64F(2, 2);
        zeroMatrix.set(0, 0, 0, 0);
        zeroMatrix.set(0, 1, 0, 0);
        zeroMatrix.set(1, 0, 0, 0);
        zeroMatrix.set(1, 1, 0, 0);

        complexIdentity = new CDenseMatrix64F(2, 2);
        complexIdentity.set(0, 0, 1, 1);
        complexIdentity.set(0, 1, 0, 0);
        complexIdentity.set(1, 0, 0, 0);
        complexIdentity.set(1, 1, 1, 1);

        complexMatrix = new CDenseMatrix64F(2, 2);
        for (int i = 0; i < 2; i++) { complexMatrix.set(i, i, 1, 1); }

        realMatrix = new CDenseMatrix64F(new double[][]{{1, 0, 1, 0},{1, 0, 1, 0}});

        complexVector = new CDenseMatrix64F(2, 1);
        complexVector.set(0, 0, 1, 1);
        complexVector.set(1, 0, 1, 1);

        realVector = new CDenseMatrix64F(2, 1);
        realVector.set(0, 0, 1, 0);
        realVector.set(1, 0, 1, 0);

        complexNumber = new CDenseMatrix64F(1, 1);
        complexNumber.set(0, 0, 1, 1);

        realNumber = new CDenseMatrix64F(1, 1);
        realNumber.set(0, 0, 1, 0);
    }

    @Test
    public void testMakeComplex() {
        CDenseMatrix64F matrix = new CDenseMatrix64F(2, 2);
        matrix.set(0, 0, 1, 0);
        matrix.set(0, 1, 0, 0);
        matrix.set(1, 0, 0, 0);
        matrix.set(1, 1, 1, 0);
        for (int c = 0; c < identity.numCols; c++) {
            for (int r = 0; r < identity.numRows; r++) {
                Assert.assertTrue(MatrixHelper.makeComplex(identity).getReal(r, c) == matrix.getReal(r, c));
                Assert.assertTrue(MatrixHelper.makeComplex(identity).getImaginary(r, c) == matrix.getImaginary(r, c));
            }
        }
    }

    @Test
    public void testMakeReal() {
        double[][] values = new double[][]{{1, 1}, {1, 1}};
        for (int c = 0; c < realMatrix.numCols; c++) {
            for (int r = 0; r < realMatrix.numRows; r++) {
                Assert.assertTrue(MatrixHelper.makeReal(realMatrix).get(r, c) == values[r][c]);
            }
        }
    }

    @Test
    public void testClassify() {
        Assert.assertEquals(MatrixHelper.classify(complexMatrix), "complex matrix");
        Assert.assertEquals(MatrixHelper.classify(realMatrix), "real matrix");
        Assert.assertEquals(MatrixHelper.classify(complexVector), "complex vector");
        Assert.assertEquals(MatrixHelper.classify(realVector), "real vector");
        Assert.assertEquals(MatrixHelper.classify(complexNumber), "complex number");
        Assert.assertEquals(MatrixHelper.classify(realNumber), "real number");
    }

    @Test
    public void testMakeVector() {
        ComplexVector vector = MatrixHelper.makeVector(complexVector);
        for (int i = 0; i < vector.getDimension(); i++) {
            Assert.assertTrue(vector.getComponents()[i].real == complexNumbers[i].real);
            Assert.assertTrue(vector.getComponents()[i].imaginary == complexNumbers[i].imaginary);
        }

    }

    @Test
    public void testIsReal() {
        Assert.assertTrue(MatrixHelper.isReal(realMatrix));
    }

    @Test
    public void testIsSquare() {
        Assert.assertTrue(MatrixHelper.isSquare(complexMatrix));
        Assert.assertTrue(MatrixHelper.isSquare(realMatrix));
    }

    @Test
    public void testTrace() {
        Assert.assertTrue(MatrixHelper.trace(zeroMatrix).real == 0);
        Assert.assertTrue(MatrixHelper.trace(zeroMatrix).imaginary == 0);
        Assert.assertTrue(MatrixHelper.trace(complexIdentity).real == 2);
        Assert.assertTrue(MatrixHelper.trace(complexIdentity).imaginary == 2);
        Assert.assertTrue(MatrixHelper.trace(complexMatrix).real == 2);
        Assert.assertTrue(MatrixHelper.trace(complexMatrix).imaginary == 2);
    }

    @Test
    public void testIsPrime() {
        int[] primes = new int[]{2, 3, 5, 7, 1721, 1723, 1733};
        for (int prime : primes) {
            Assert.assertTrue(MatrixHelper.isPrime(prime));
        }
        Assert.assertFalse(MatrixHelper.isPrime(20));
        Assert.assertTrue(true);
    }

    @Test
    public void testTwinPrime() {
        int[] twins = new int[]{3, 29, 59, 347};
        for (int twin : twins) {
            Assert.assertTrue(MatrixHelper.isTwin(twin));
        }
        Assert.assertFalse(MatrixHelper.isTwin(0));
        Assert.assertFalse(MatrixHelper.isTwin(2));
        Assert.assertFalse(MatrixHelper.isTwin(23));
    }

}
