package com.kozheurov.cg.task.cg_task3.vector;

public class FourDimensionalVector extends Vector {

    @Override
    public float[][] sumVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 4) {
            float[][] resultVector = new float[vector1.length][1];
            for (int i = 0; i < vector1.length; i++) {
                resultVector[i][0] = vector1[i][0] + vector2[i][0];
            }
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] subtractVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 4) {
            float[][] resultVector = new float[vector1.length][1];
            for (int i = 0; i < vector1.length; i++) {
                resultVector[i][0] = vector1[i][0] - vector2[i][0];
            }
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] divisionByScalar(float[][] vector, float scalar) {
        if (vector.length == 4 && scalar != 0F) {
            for (int i = 0; i < vector.length; i++) {
                vector[i][0] = vector[i][0] / scalar;
            }
            return vector;
        }
        return null;
    }

    @Override
    public float[][] multiplyByScalar(float[][] vector, float scalar) {
        if (vector.length == 4) {
            for (int i = 0; i < vector.length; i++) {
                vector[i][0] = vector[i][0] * scalar;
            }
            return vector;
        }
        return null;
    }

    @Override
    public Float vectorLength(float[][] vector) {
        return vector.length == 4 ? (float) Math.sqrt(Math.pow(vector[0][0], 2) + Math.pow(vector[1][0], 2) +
                Math.pow(vector[2][0], 2) + Math.pow(vector[3][0], 2)) : null;
    }

    @Override
    public float[][] normalizeVector(float[][] vector) {
        Float vectorLength = vectorLength(vector);
        if (vector.length == 4 && vectorLength != 0) {
            for (int i = 0; i < vector.length; i++) {
                vector[i][0] = vector[i][0] / vectorLength;
            }
            return vector;
        }
        return null;
    }

    @Override
    public Float scalarMultiply(float[][] vector1, float[][] vector2, double angle) {
        if (vector1.length == vector2.length && vector1.length == 4 && angle <= 180.0) {
            return (float) (vectorLength(vector1) * vectorLength(vector2) * Math.cos(angle));
        }
        return null;
    }
}
