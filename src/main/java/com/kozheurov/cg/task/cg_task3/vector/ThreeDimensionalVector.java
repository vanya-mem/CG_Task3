package com.kozheurov.cg.task.cg_task3.vector;

public class ThreeDimensionalVector extends Vector {

    @Override
    public float[][] sumVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 3) {
            float[][] resultVector = new float[vector1.length][1];
            resultVector[0][0] = vector1[0][0] + vector2[0][0];
            resultVector[1][0] = vector1[1][0] + vector2[1][0];
            resultVector[2][0] = vector1[2][0] + vector2[2][0];
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] subtractVectors(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 3) {
            float[][] resultVector = new float[vector1.length][1];
            resultVector[0][0] = vector1[0][0] - vector2[0][0];
            resultVector[1][0] = vector1[1][0] - vector2[1][0];
            resultVector[2][0] = vector1[2][0] - vector2[2][0];
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] divisionByScalar(float[][] vector, float scalar) {
        if (vector.length == 3 && scalar != 0F) {
            float[][] resultVector = new float[vector.length][1];
            resultVector[0][0] = vector[0][0] / scalar;
            resultVector[1][0] = vector[1][0] / scalar;
            resultVector[2][0] = vector[2][0] / scalar;
            return resultVector;
        }
        return null;
    }

    @Override
    public float[][] multiplyByScalar(float[][] vector, float scalar) {
        if (vector.length == 3) {
            float[][] resultVector = new float[vector.length][1];
            resultVector[0][0] = vector[0][0] * scalar;
            resultVector[1][0] = vector[1][0] * scalar;
            resultVector[2][0] = vector[2][0] * scalar;
            return resultVector;
        }
        return null;
    }

    @Override
    public Float vectorLength(float[][] vector) {
        return vector.length == 3 ? (float) Math.sqrt(Math.pow(vector[0][0], 2) + Math.pow(vector[1][0], 2) +
                Math.pow(vector[2][0], 2)) : null;
    }

    @Override
    public float[][] normalizeVector(float[][] vector) {
        Float vectorLength = vectorLength(vector);
        if (vector.length == 3 && vectorLength != 0) {
            vector[0][0] = vector[0][0] / vectorLength;
            vector[1][0] = vector[1][0] / vectorLength;
            vector[2][0] = vector[2][0] / vectorLength;
            return vector;
        }
        return null;
    }

    @Override
    public Float scalarMultiply(float[][] vector1, float[][] vector2, double angle) {
        if (vector1.length == vector2.length && vector1.length == 3 && angle <= 180.0) {
            return (float) (vectorLength(vector1) * vectorLength(vector2) * Math.cos(angle));
        }
        return null;
    }

    public float[][] vectorMultiply(float[][] vector1, float[][] vector2) {
        if (vector1.length == vector2.length && vector1.length == 3) {
            float[][] resultVector = new float[vector1.length][1];
            resultVector[0][0] = vector1[1][0] * vector2[2][0] - vector1[2][0] * vector2[1][0];
            resultVector[1][0] = vector1[2][0] * vector2[0][0] - vector1[0][0] * vector2[2][0];
            resultVector[2][0] = vector1[0][0] * vector2[1][0] - vector1[1][0] * vector2[0][0];
            return resultVector;
        }
        return null;
    }
}
