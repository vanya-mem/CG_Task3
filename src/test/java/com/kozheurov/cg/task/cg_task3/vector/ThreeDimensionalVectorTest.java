package com.kozheurov.cg.task.cg_task3.vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeDimensionalVectorTest {

    private ThreeDimensionalVector vector3x;

    private float[][] vector1;

    private float[][] vector2;

    private float[][] vector3;

    private float scalar;

    private double angle;

    @BeforeEach
    void prepareData() {
        vector3x = new ThreeDimensionalVector();

        vector1 = new float[][]{{1}, {0}, {0}};
        vector2 = new float[][]{{-5}, {10}, {3}};
        vector3 = new float[][]{{-3}, {1}};
        scalar = -5;
        angle = 90;
    }

    @Test
    void sumVectorsSuccess() {
        assertEquals(-4, vector3x.sumVectors(vector1, vector2)[0][0]);
    }

    @Test
    void sumVectorsFails() {
        assertNull(vector3x.sumVectors(vector1, vector3));
    }

    @Test
    void subtractVectorsSuccess() {
        assertEquals(6, vector3x.subtractVectors(vector1, vector2)[0][0]);
    }

    @Test
    void subtractVectorsFails() {
        assertNull(vector3x.subtractVectors(vector1, vector3));
    }

    @Test
    void divisionByScalarSuccess() {
        assertEquals(1, vector3x.divisionByScalar(vector2, scalar)[0][0]);
    }

    @Test
    void divisionByScalarFails() {
        assertNull(vector3x.divisionByScalar(vector1, 0));
    }

    @Test
    void multiplyByScalarSuccess() {
        assertEquals(25, vector3x.multiplyByScalar(vector2, scalar)[0][0]);
    }

    @Test
    void multiplyByScalarFails() {
        assertNull(vector3x.multiplyByScalar(vector3, scalar));
    }

    @Test
    void vectorLengthSuccess() {
        assertEquals(1, vector3x.vectorLength(vector1));
    }

    @Test
    void vectorLengthFails() {
        assertNull(vector3x.vectorLength(vector3));
    }

    @Test
    void normalizeVectorSuccess() {
        assertEquals(1, vector3x.normalizeVector(vector1)[0][0]);
    }

    @Test
    void normalizeVectorFails() {
        assertNull(vector3x.normalizeVector(vector3));
    }

    @Test
    void scalarMultiplySuccess() {
        assertEquals(1, vector3x.scalarMultiply(vector1, vector1, 0));
    }

    @Test
    void scalarMultiplyFails() {
        assertNull(vector3x.scalarMultiply(vector1, vector3, angle));
    }

    @Test
    void vectorMultiplySuccess() {
        assertEquals(0, vector3x.vectorMultiply(vector1, vector2)[0][0]);
    }

    @Test
    void vectorMultiplyFails() {
        assertNull(vector3x.vectorMultiply(vector1, vector3));
    }
}