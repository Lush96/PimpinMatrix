package com.mobiledev.topimpamatrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larspmayrand on 4/26/16.
 */
public class VectorOperationsTest {

    private Vector zeroVector;
    private Vector vectorA;
    private Vector vectorB;
    private Vector unitXVector;
    private Vector unitYVector;

    @Before
    public void setUp() {
        zeroVector = new Vector(new double[]{0, 0});
        vectorA = new Vector(new double[]{2, 0});
        vectorB = new Vector(new double[]{1, 1});
        unitXVector = new Vector(new double[]{1, 0});
        unitYVector = new Vector(new double[]{0, 1});
    }

    @Test
    public void testGramSchmidtProcess() {
        Vector[] normalized = VectorOperations.gramSchmidt(vectorA, vectorB);
        Assert.assertTrue(new Vector(new double[] { -1, 0 }).equals(normalized[0]));
        Assert.assertTrue(new Vector(new double[]{-2, -1}).equals(normalized[1]));
    }

    @Test
    public void testProjection() {
        Assert.assertTrue(new Vector(new double[]{1, 0}).equals(VectorOperations.projection(vectorA, vectorB)));
    }

    @Test
    public void testAdd() {
        Assert.assertTrue(new Vector(new double[] { 3, 1 }).equals(VectorOperations.add(vectorA, vectorB)));
    }

    @Test
    public void testSubtract() {
        Assert.assertTrue(new Vector(new double[] { 1, -1 }).equals(VectorOperations.subtract(vectorA, vectorB)));
    }

    @Test
    public void testDotProduct() {
        Assert.assertEquals(2, VectorOperations.dot(vectorA, vectorB), 10e-3);
    }

}
