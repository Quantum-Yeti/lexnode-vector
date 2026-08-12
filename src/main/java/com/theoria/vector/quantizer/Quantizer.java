package com.theoria.vector.quantizer;

public class Quantizer {

    private final float minBound;
    private final float maxBound;
    private final float scale;

    /**
    Instantiates a Quantizer with fixed mathematical data boundaries.
     Maps the minimum float boundary to -128 and the maximum float boundary to 127.
     */
    public Quantizer(float minBound, float maxBound) {
        if (minBound >= maxBound) {
            throw new IllegalArgumentException("Minimum bound must be less than maximum bound.");
        }
        this.minBound = minBound;
        this.maxBound = maxBound;
        this.scale = (maxBound - minBound) / 255.0f;
    }

    /**
     * Quantizes a single float value into an 8-bit signed integer range [-128, 127]
     * Values outside [minBound, maxBound] are clamped before scaling.
     */
    public byte quantize(float value) {
        float clamped = Math.max(minBound, Math.min(maxBound, value));
        int mapped = Math.round((clamped - minBound) / scale) -128;

        // Guard against rounding (e.g. 127.8 -> 128)
        mapped = Math.max(-128, Math.min(127, mapped));
        return (byte) mapped;
    }

    /**
     * Dequantizes an 8-bit signed integer back into a float value
     * within [minBound, maxBound].
     */
    public float dequantize(byte value) {
        return ((value + 128) * scale) + minBound;
    }

    /**
     * Quantizes a vector.
     */
    public byte[] quantize(float[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Vector cannot be null.");
        }
        byte[] result = new byte[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = quantize(vector[i]);
        }
        return result;
    }

    /**
     * Dequantize a vector.
     */
    public float[] dequantize(byte[] vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Vector cannot be null.");
        }
        float[] result = new float[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = dequantize(vector[i]);
        }
        return result;
    }
}
