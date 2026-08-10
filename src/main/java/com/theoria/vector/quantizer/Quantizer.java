package com.theoria.vector.quantizer;

public class Quantizer {

    private final float minBound;
    private final float maxBound;

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
    }
}
