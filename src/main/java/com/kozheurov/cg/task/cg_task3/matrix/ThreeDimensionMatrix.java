package com.kozheurov.cg.task.cg_task3.matrix;

import java.util.Arrays;

public class ThreeDimensionMatrix extends Matrix {

    @Override
    public float[][] sumMatrix(float[][] matrix1, float[][] matrix2) {
        if ((matrix1.length == matrix2.length && matrix1.length == 3) &&
                (matrix1[0].length == matrix2[0].length && matrix1[0].length == 3)) {
            float[][] resultMatrix = new float[matrix1.length][matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return resultMatrix;
        }
        return null;
    }


    /**
     * matrix1 - matrix2
     */
    @Override
    public float[][] subtractMatrix(float[][] matrix1, float[][] matrix2) {
        if ((matrix1.length == matrix2.length && matrix1.length == 3) &&
                (matrix1[0].length == matrix2[0].length && matrix1[0].length == 3)) {
            float[][] resultMatrix = new float[matrix1.length][matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return resultMatrix;
        }
        return null;
    }

    @Override
    public float[][] matrixVectorMultiplication(float[][] matrix, float[][] vector) {
        if (matrix[0].length == vector.length && vector[0].length == 1 && matrix[0].length == 3 && matrix.length == 3) {
            float[][] result = new float[vector.length][1];
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    result[i][0] += matrix[i][j] * vector[j][0];
                }
            }
            return result;
        }
        return null;
    }


    /**
     * matrix1 * matrix2;
     */
    @Override
    public float[][] matrixMultiplication(float[][] matrix1, float[][] matrix2) {
        if (matrix1[0].length == matrix2.length) {
            float[][] resultMatrix = new float[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return resultMatrix;
        }
        return null;
    }

    @Override
    public float[][] matrixTranspose(float[][] matrix) {
        if (matrix.length == 3 && matrix[0].length == 3) {
            float[][] resultMatrix = new float[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    resultMatrix[j][i] = matrix[i][j];
                }
            }
            return resultMatrix;
        }
        return null;
    }

    @Override
    public float[][] getZeroMatrix() {
        return new float[3][3];
    }

    @Override
    public float[][] getIdentityMatrix() {
        float[][] matrix = new float[3][3];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 1);
        }
        return matrix;
    }

    @Override
    public Float matrixDeterminate(float[][] matrix) {
        if (matrix.length == matrix[0].length && matrix.length == 3) {
            float positivePart = matrix[0][0] * matrix[1][1] * matrix[2][2] + matrix[0][2] * matrix[1][0] * matrix[2][1]
                    + matrix[0][1] * matrix[1][2] * matrix[2][0];
            float negativePart = matrix[0][2] * matrix[1][1] * matrix[2][0] + matrix[0][0] * matrix[1][2] * matrix[2][1]
                    + matrix[0][1] * matrix[1][0] * matrix[2][2];
            return positivePart - negativePart;
        }
        return null;
    }

    @Override
    public float[][] inverseMatrix(float[][] matrix) {
        Float matrixDeterminant = matrixDeterminate(matrix);
        if (matrix.length == matrix[0].length && matrix.length == 3 && matrixDeterminant != 0) {
            float[][] inverseMatrix = new float[3][3];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    float[][] sideMatrix = getDoubleMatrix(matrix, i, j);
                    float determinant = sideMatrix[0][0] * sideMatrix[1][1] - sideMatrix[0][1] * sideMatrix[1][0];
                    inverseMatrix[i][j] = determinant;
                }
            }
            inverseMatrix[0][1] = -inverseMatrix[0][1];
            inverseMatrix[1][0] = -inverseMatrix[1][0];
            inverseMatrix[1][2] = -inverseMatrix[1][2];
            inverseMatrix[2][1] = -inverseMatrix[2][1];
            inverseMatrix = matrixTranspose(inverseMatrix);
            for (int i = 0; i < inverseMatrix.length; i++) {
                for (int j = 0; j < inverseMatrix[0].length; j++) {
                    inverseMatrix[i][j] = inverseMatrix[i][j] / matrixDeterminant;
                }
            }
            return inverseMatrix;
        }
        return null;
    }

    private float[][] getDoubleMatrix(float[][] matrix, int rowIndex, int colIndex) {
        float[][] resultMatrix = new float[2][2];
        int matrixRowCounter = 0;
        for (int i = 0; i < matrix.length; i++) {
            int matrixColCounter = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != rowIndex && j != colIndex) {
                    resultMatrix[matrixRowCounter][matrixColCounter++] = matrix[i][j];
                    if (matrixColCounter > 1) {
                        matrixRowCounter++;
                    }
                }
                if (matrixRowCounter > 1 && matrixColCounter > 1) {
                    break;
                }
            }
        }
        return resultMatrix;
    }
}
