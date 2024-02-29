package com.kozheurov.cg.task.cg_task3.vector;

public abstract class Vector {

    public abstract float[][] sumVectors(float[][] vector1, float[][] vector2);

    public abstract float[][] subtractVectors(float[][] vector1, float[][] vector2);

    public abstract float[][] divisionByScalar(float[][] vector, float scalar);

    public abstract float[][] multiplyByScalar(float[][] vector, float scalar);

    public abstract Float vectorLength(float[][] vector);

    public abstract float[][] normalizeVector(float[][] vector);

    public abstract Float scalarMultiply(float[][] vector1, float[][] vector2, double angle);
}
