package com.kozheurov.cg.task.cg_task3.matrix;

public abstract class Matrix {



    public abstract float[][] sumMatrix(float[][] matrix1, float[][] matrix2);

    public abstract float[][] subtractMatrix(float[][] matrix1, float[][] matrix2);

    public abstract float[][] matrixVectorMultiplication(float[][] matrix, float[][] vector);

    public abstract float[][] matrixMultiplication(float[][] matrix1, float[][] matrix2);

    public abstract float[][] matrixTranspose(float[][] matrix);

    public abstract float[][] getZeroMatrix();

    public abstract float[][] getIdentityMatrix();

    public abstract Float matrixDeterminate(float[][] matrix);

    public abstract float[][] inverseMatrix(float[][] matrix);
}
