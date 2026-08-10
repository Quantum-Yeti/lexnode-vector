package com.theoria.vector.utils;

public class DistanceUtils {

    /**
     * Calculate the Euclidean distance between two floating-point vectors.
     * Formula: sqrt(sum((vector1[i] - vector2[i])^2))
     */
    public static double euclideanDistance(float[] vector1, float[] vector2) {
        if (vector1 == null || vector2 == null || vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must be non-null and have identical dimensions.");
        }

        double sum = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            double diff =  vector1[i] - vector2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    /**
     * Calculate the Cosine Similarity between two floating-point vectors.
     * Formula: (vector1 · vector2) / (norm(vector1) * norm(vector2))
     * Return a value between -1.0 (opposite) and 1.0 (identical).
     */
    public static double cosineSimilarity(float[] vector1, float[] vector2) {
        if (vector1 == null || vector2 == null || vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must be non-null and have identical dimensions.");
        }

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            normA += vector1[i] * vector1[i];
            normB += vector2[i] * vector2[i];
        }

        if (normA == 0.0 || normB == 0.0) {
            return 0.0; // Return zero similarity if a vector is completely empty or zero
        }

        double result = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
        return Math.max(-1.0, Math.min(1.0, result));
    }

}
