package com.mobiledev.topimpamatrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by larspmayrand on 4/24/16.
 */
public class VectorTest {

    private double EPSILON = 10e-4;

    private Vector zeroVector;
    private Vector vectorA;
    private Vector vectorB;
    private Vector unitXVector;
    private Vector unitYVector;

    @Before
    public void setUp() {
        zeroVector = new Vector(new double[]{0, 0});
        vectorA = new Vector(new double[]{1, 1});
        vectorB = new Vector(new double[]{2, 0});
        unitXVector = new Vector(new double[]{1, 0});
        unitYVector = new Vector(new double[]{0, 1});
    }

    @Test
    public void testMagnitude() {
        Assert.assertEquals(zeroVector.magnitude(), 0, EPSILON);
        Assert.assertEquals(vectorA.magnitude(), Math.sqrt(2), EPSILON);
        Assert.assertEquals(unitYVector.magnitude(), 1, EPSILON);
    }

    @Test
    public void testNormalize() {
        Vector normalized = vectorB.normalize();
        Assert.assertTrue(normalized.equals(unitXVector));
    }

    @Test
    public void testAngle() {
        Assert.assertEquals(unitXVector.angle(), 0, EPSILON);
        Assert.assertEquals(unitYVector.angle(), Math.PI/2, EPSILON);
        Assert.assertEquals(vectorA.angle(), 0.785398, EPSILON); // 0.785398 radians = 45 degrees
    }

    @Test
    public void testScale() {
        Assert.assertTrue(unitXVector.scale(2).equals(vectorB));
    }

    @Test
    public void testSlope() {
        Assert.assertEquals(vectorA.slope(), 1, EPSILON);
        Assert.assertEquals(unitXVector.slope(), 0, EPSILON);
    }

}
