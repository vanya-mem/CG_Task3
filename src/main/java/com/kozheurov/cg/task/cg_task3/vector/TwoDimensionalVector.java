package com.kozheurov.cg.task.cg_task3.vector;

public class TwoDimensionalVector extends Vector {

    @Override
    public float[][] sumVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 2) {
            float[][] resultVector = new float[vector1.length][1];
            resultVector[0][0] = vector1[0][0] + vector2[0][0];
            resultVector[1][0] = vector1[1][0] + vector2[1][0];
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] subtractVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 2) {
            float[][] resultVector = new float[vector1.length][1];
            resultVector[0][0] = vector1[0][0] - vector2[0][0];
            resultVector[1][0] = vector1[1][0] - vector2[1][0];
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] divisionByScalar(float[][] vector, float scalar) {
        if (vector.length == 2 && scalar != 0F) {
            vector[0][0] = vector[0][0] / scalar;
            vector[1][0] = vector[1][0] / scalar;
            return vector;
        }
        return null;
    }

    @Override
    public float[][] multiplyByScalar(float[][] vector, float scalar) {
        if (vector.length == 2) {
            vector[0][0] = vector[0][0] * scalar;
            vector[1][0] = vector[1][0] * scalar;
            return vector;
        }
        return null;
    }

    @Override
    public Float vectorLength(float[][] vector) {
        return vector.length == 2 ? (float) Math.sqrt(Math.pow(vector[0][0], 2) + Math.pow(vector[1][0], 2)) : null;
    }

    @Override
    public float[][] normalizeVector(float[][] vector) {
        Float vectorLength = vectorLength(vector);
        if (vector.length == 2 && vectorLength != 0) {
            vector[0][0] = vector[0][0] / vectorLength;
            vector[1][0] = vector[1][0] / vectorLength;
            return vector;
        }
        return null;
    }

    @Override
    public Float scalarMultiply(float[][] vector1, float[][] vector2, double angle) {
        if (vector1.length == vector2.length && vector1.length == 2 && angle <= 180F) {
            return (float) (vectorLength(vector1) * vectorLength(vector2) * Math.cos(angle));
        }
        return null;
    }
}
