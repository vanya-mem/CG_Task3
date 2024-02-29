package com.kozheurov.cg.task.cg_task3.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourDimensionMatrixTest {

    private FourDimensionMatrix matrix4x;

    private float[][] matrix1;

    private float[][] matrix2;

    private float[][] matrix3;

    private float[][] matrix4;

    private float[][] vector1;

    @BeforeEach
    void prepareData() {
        matrix4x = new FourDimensionMatrix();

        matrix1 = new float[][]{{1, 2, 2, 5}, {3, 1, 1, 3}};
        matrix2 = new float[][]{{4, 2, 1, 7}, {3, 1, 5, 3}, {1, 5, 9, 0}, {-5, 2, 5, -2}};
        matrix3 = new float[][]{{6, 1, 0, -11}, {7, 9, 2, -8}, {0, 4, 7, 2}, {2, 4, 7, -2}};
        matrix4 = new float[][]{{1, 2, 3, 4}, {2, 3, 1, 2}, {1, 1, 1, -1}, {1, 0, -2, -6}};
        vector1 = new float[][]{{1}, {2}, {-1}, {5}};
    }

    @Test
    void sumMatrixSuccess() {
        assertEquals(10, matrix4x.sumMatrix(matrix2, matrix3)[0][0]);
    }

    @Test
    void sumMatrixFails() {
        assertNull(matrix4x.sumMatrix(matrix1, matrix2));
    }

    @Test
    void subtractMatrixSuccess() {
        assertEquals(-2, matrix4x.subtractMatrix(matrix2, matrix3)[0][0]);
    }

    @Test
    void subtractMatrixFails() {
        assertNull(matrix4x.subtractMatrix(matrix1, matrix3));
    }

    @Test
    void matrixVectorMultiplicationSuccess() {
        assertEquals(42, matrix4x.matrixVectorMultiplication(matrix2, vector1)[0][0]);
    }

    @Test
    void matrixVectorMultiplicationFails() {
        assertNull(matrix4x.matrixVectorMultiplication(matrix1, vector1));
    }

    @Test
    void matrixMultiplicationSuccess() {
        assertEquals(-13, matrix4x.matrixMultiplication(matrix1, matrix2)[0][0]);
    }

    @Test
    void matrixMultiplicationFails() {
        assertNull(matrix4x.matrixMultiplication(matrix2, matrix1));
    }

    @Test
    void matrixTransposeSuccess() {
        assertEquals(3, matrix4x.matrixTranspose(matrix2)[0][1]);
    }

    @Test
    void matrixTransposeFails() {
        assertNull(matrix4x.matrixTranspose(matrix1));
    }

    @Test
    void matrixDeterminateSuccess() {
        assertEquals(-34, matrix4x.matrixDeterminate(matrix3));
    }

    @Test
    void matrixDeterminateFails() {
        assertNull(matrix4x.matrixDeterminate(matrix1));
    }

    @Test
    void inverseMatrixSuccess() {
        assertEquals(22, matrix4x.inverseMatrix(matrix4)[0][0]);
    }

    @Test
    void inverseMatrixFails() {
        assertNull(matrix4x.inverseMatrix(matrix1));
    }
}