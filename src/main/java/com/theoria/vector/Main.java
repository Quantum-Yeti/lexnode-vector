package com.theoria.vector;

import com.theoria.vector.utils.DistanceUtils;

public class Main {

    static void main() {
        System.out.println("=== LexNode Vector Engine ===");
        System.out.println("Java Environment: " + Runtime.version());
        System.out.println("Available Core Workers: " + Runtime.getRuntime().availableProcessors());

        System.out.println("=== Test Vectors ===");
        testVector();
    }

        static void testVector() {
        float[] vectorA = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] vectorB = {2.0f, 3.0f, 4.0f, 5.0f};

        double euclidean = DistanceUtils.euclideanDistance(vectorA, vectorB);
        double cosine = DistanceUtils.cosineSimilarity(vectorA, vectorB);

        System.out.printf("Euclidean Distance: %.1f%n", + euclidean);
        System.out.printf("Cosine Similarity: %.4f%n", + cosine);

    }

}
