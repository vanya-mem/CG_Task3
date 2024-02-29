package com.kozheurov.cg.task.cg_task3.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ThreeDimensionMatrixTest {

    private ThreeDimensionMatrix matrix3x;

    private float[][] matrix1;

    private float[][] matrix2;

    private float[][] matrix3;

    private float[][] matrix4;

    private float[][] vector1;

    @BeforeEach
    void prepareData() {
        matrix3x = new ThreeDimensionMatrix();

        matrix1 = new float[][]{{1, 2, 2}, {3, 1, 1}};
        matrix2 = new float[][]{{4, 2, 1}, {3, 1, 5}, {1, 5, 9}};
        matrix3 = new float[][]{{6, 1, 0}, {7, 9, 2}, {0, 4, 7}};
        matrix4 = new float[][]{{2, 5, 7}, {6, 3, 4}, {5, -2, -3}};
        vector1 = new float[][]{{1}, {2}, {-1}};
    }

    @Test
    void sumMatrixSuccess() {
        assertEquals(10, matrix3x.sumMatrix(matrix2, matrix3)[0][0]);
    }

    @Test
    void sumMatrixFails() {
        assertNull(matrix3x.sumMatrix(matrix1, matrix2));
    }

    @Test
    void subtractMatrixSuccess() {
        assertEquals(-2, matrix3x.subtractMatrix(matrix2, matrix3)[0][0]);
    }

    @Test
    void subtractMatrixFails() {
        assertNull(matrix3x.subtractMatrix(matrix1, matrix3));
    }

    @Test
    void matrixVectorMultiplicationSuccess() {
        assertEquals(7, matrix3x.matrixVectorMultiplication(matrix2, vector1)[0][0]);
    }

    @Test
    void matrixVectorMultiplicationFails() {
        assertNull(matrix3x.matrixVectorMultiplication(matrix1, vector1));
    }

    @Test
    void matrixMultiplicationSuccess() {
        assertEquals(12, matrix3x.matrixMultiplication(matrix1, matrix2)[0][0]);
    }

    @Test
    void matrixMultiplicationFails() {
        assertNull(matrix3x.matrixMultiplication(matrix2, matrix1));
    }

    @Test
    void matrixTransposeSuccess() {
        assertEquals(3, matrix3x.matrixTranspose(matrix2)[0][1]);
    }

    @Test
    void matrixTransposeFails() {
        assertNull(matrix3x.matrixTranspose(matrix1));
    }

    @Test
    void matrixDeterminateSuccess() {
        assertEquals(281, matrix3x.matrixDeterminate(matrix3));
    }

    @Test
    void matrixDeterminateFails() {
        assertNull(matrix3x.matrixDeterminate(matrix1));
    }

    @Test
    void inverseMatrixSuccess() {
        assertEquals(1, matrix3x.inverseMatrix(matrix4)[0][0]);
    }

    @Test
    void inverseMatrixFails() {
        assertNull(matrix3x.inverseMatrix(matrix1));
    }
}