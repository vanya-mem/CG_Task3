package com.kozheurov.cg.task.cg_task3.matrix;

import java.util.Arrays;

public class FourDimensionMatrix extends Matrix {

    @Override
    public float[][] sumMatrix(float[][] matrix1, float[][] matrix2) {
        if ((matrix1.length == matrix2.length && matrix1.length == 4) &&
                (matrix1[0].length == matrix2[0].length && matrix1[0].length == 4)) {
            float[][] resultMatrix = new float[4][4];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return resultMatrix;
        }
        return null;
    }

    @Override
    public float[][] subtractMatrix(float[][] matrix1, float[][] matrix2) {
        if ((matrix1.length == matrix2.length && matrix1.length == 4) &&
                (matrix1[0].length == matrix2[0].length && matrix1[0].length == 4)) {
            float[][] resultMatrix = new float[4][4];
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
        if (matrix[0].length == vector.length && vector[0].length == 1 && matrix[0].length == 4 && matrix.length == 4) {
            float[][] result = new float[4][1];
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    result[i][0] += matrix[i][j] * vector[j][0];
                }
            }
            return result;
        }
        return null;
    }

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
        if (matrix.length == 4 && matrix[0].length == 4) {
            float[][] resultMatrix = new float[4][4];
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
        return new float[4][4];
    }

    @Override
    public float[][] getIdentityMatrix() {
        float[][] matrix = new float[4][4];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 1);
        }
        return matrix;
    }

    @Override
    public Float matrixDeterminate(float[][] matrix) {
        if (matrix.length == matrix[0].length && matrix.length == 4) {
            float matrixDeterminate = 0;
            ThreeDimensionMatrix matrix3x = new ThreeDimensionMatrix();
            for (int k = 0; k < matrix.length; k++) {
                int matrixRowCounter = 0;
                float[][] subMatrix = new float[3][3];
                for (int i = 0; i < matrix.length; i++) {
                    int matrixColCounter = 0;
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (i != k && j != 0) {
                            subMatrix[matrixRowCounter][matrixColCounter++] = matrix[i][j];
                            if (matrixColCounter > 2) {
                                matrixRowCounter++;
                            }
                        }
                    }
                }
                matrixDeterminate += Math.pow(-1, k) * matrix[k][0] * matrix3x.matrixDeterminate(subMatrix);
            }
            return matrixDeterminate;
        }
        return null;
    }

    @Override
    public float[][] inverseMatrix(float[][] matrix) {
        Float matrixDeterminant = matrixDeterminate(matrix);
        if (matrix.length == matrix[0].length && matrix.length == 4 && matrixDeterminant != 0) {
            ThreeDimensionMatrix matrix3x = new ThreeDimensionMatrix();
            float[][] inverseMatrix = new float[4][4];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    float[][] sideMatrix = getTripleMatrix(matrix, i, j);
                    float determinant = matrix3x.matrixDeterminate(sideMatrix);
                    inverseMatrix[i][j] = matrix[i][j] * determinant;
                }
            }
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

    private float[][] getTripleMatrix(float[][] matrix, int rowIndex, int colIndex) {
        float[][] resultMatrix = new float[3][3];
        int matrixRowCounter = 0;
        for (int i = 0; i < matrix.length; i++) {
            int matrixColCounter = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != rowIndex && j != colIndex) {
                    resultMatrix[matrixRowCounter][matrixColCounter++] = matrix[i][j];
                    if (matrixColCounter > 2) {
                        matrixRowCounter++;
                    }
                }
                if (matrixRowCounter > 2 && matrixColCounter > 2) {
                    break;
                }
            }
        }
        return resultMatrix;
    }
}
