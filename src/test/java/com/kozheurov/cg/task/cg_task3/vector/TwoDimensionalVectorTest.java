package com.kozheurov.cg.task.cg_task3.vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionalVectorTest {

    private TwoDimensionalVector vector2x;

    private float[][] vector1;

    private float[][] vector2;

    private float[][] vector3;

    private float scalar;

    private double angle;

    @BeforeEach
    void prepareData() {
        vector2x = new TwoDimensionalVector();

        vector1 = new float[][]{{1}, {0}};
        vector2 = new float[][]{{-5}, {10}};
        vector3 = new float[][]{{-3}, {1}, {10}};
        scalar = -5;
        angle = 90;
    }

    @Test
    void sumVectorsSuccess() {
        assertEquals(-4, vector2x.sumVectors(vector1, vector2)[0][0]);
    }

    @Test
    void sumVectorsFails() {
        assertNull(vector2x.sumVectors(vector1, vector3));
    }

    @Test
    void subtractVectorsSuccess() {
        assertEquals(6, vector2x.subtractVectors(vector1, vector2)[0][0]);
    }

    @Test
    void subtractVectorsFails() {
        assertNull(vector2x.subtractVectors(vector1, vector3));
    }

    @Test
    void divisionByScalarSuccess() {
        assertEquals(1, vector2x.divisionByScalar(vector2, scalar)[0][0]);
    }

    @Test
    void divisionByScalarFails() {
        assertNull(vector2x.divisionByScalar(vector1, 0));
    }

    @Test
    void multiplyByScalarSuccess() {
        assertEquals(25, vector2x.multiplyByScalar(vector2, scalar)[0][0]);
    }

    @Test
    void multiplyByScalarFails() {
        assertNull(vector2x.multiplyByScalar(vector3, scalar));
    }

    @Test
    void vectorLengthSuccess() {
        assertEquals(1, vector2x.vectorLength(vector1));
    }

    @Test
    void vectorLengthFails() {
        assertNull(vector2x.vectorLength(vector3));
    }

    @Test
    void normalizeVectorSuccess() {
        assertEquals(1, vector2x.normalizeVector(vector1)[0][0]);
    }

    @Test
    void normalizeVectorFails() {
        assertNull(vector2x.normalizeVector(vector3));
    }

    @Test
    void scalarMultiplySuccess() {
        assertEquals(1, vector2x.scalarMultiply(vector1, vector1, 0));
    }

    @Test
    void scalarMultiplyFails() {
        assertNull(vector2x.scalarMultiply(vector1, vector3, angle));
    }
}