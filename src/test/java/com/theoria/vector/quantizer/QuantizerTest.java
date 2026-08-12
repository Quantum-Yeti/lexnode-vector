package com.theoria.vector.quantizer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantizerTest {

    @Test
    void roundTripStaysWithinHalfAStep() {
        float minBound = 0f;
        float maxBound = 255f;
        Quantizer quantizer = new Quantizer(minBound, maxBound);
        float scale = (maxBound - minBound) / 255.0f;
        float tolerance = scale / 2.0f;

        float[] testValues = { 0f, 1f, 50f, 127f, 128f, 200f, 254f, 255f };

        for (float original : testValues) {
            byte quantized = quantizer.quantize(original);
            float reconstructed = quantizer.dequantize(quantized);
            assertEquals(original, reconstructed, tolerance,
                    "Round-trip failed for value: " + original);
        }
    }

    @Test
    void boundariesMapToExactByteLimits() {
        Quantizer quantizer = new Quantizer(0f, 255f);
        assertEquals((byte) -128, quantizer.quantize(0f));
        assertEquals((byte) 127, quantizer.quantize(255f));
    }

    @Test
    void valuesOutsideBoundsAreClamped() {
        Quantizer quantizer = new Quantizer(0f, 255f);
        assertEquals(quantizer.quantize(0f), quantizer.quantize(-50f));   // clamps to minBound
        assertEquals(quantizer.quantize(255f), quantizer.quantize(999f)); // clamps to maxBound
    }

    @Test
    void vectorQuantizeMatchesScalarElementWise() {
        Quantizer quantizer = new Quantizer(0f, 255f);
        float[] input = { 0f, 100f, 255f };
        byte[] expected = {
                quantizer.quantize(0f),
                quantizer.quantize(100f),
                quantizer.quantize(255f)
        };
        assertArrayEquals(expected, quantizer.quantize(input));
    }
}
