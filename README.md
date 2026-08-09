# LexNode Vector Engine

A high-performance, zero-dependency, in-memory vector database engineered from scratch using **Java 25 (LTS)**. This engine utilizes optimized 8-Bit Scalar Quantization (SQ8) to compress high-dimensional floating-point embeddings (e.g., 1536-dimension text vectors), reducing memory footprint by **~75%** while preserving structural spatial similarity during retrieval operations.

---

## Architectural Overview

The engine eliminates the overhead of external network dependencies and bloated third-party abstractions by executing low-level memory transformations and mathematical lookups natively within a multi-threaded execution pipeline.

### 1. High-Density Quantization (``)
Operates as a zero-allocation vector translator. It dynamically samples the statistical distribution boundaries of incoming embedding arrays, normalizes coordinates linearly, and packs data into dense signed binary streams (`byte[]`) mapped across the `[-128, 127]` range.

### 2. Segmented Parallel Execution (``)
Partitions memory allocations into discrete, thread-isolated runtime zones. It leverages modern Java Virtual Threads to execute asynchronous retrieval tasks concurrently across all available CPU cores without thread-starvation or locking overhead.

### 3. Low-Latency Distance Metrics (``)
Implements strict, single-pass primitive array manipulation loops to compute Cosine Similarity. The algorithm bypasses intermediate object allocations to maximize cache locality and maintain a near-zero Garbage Collection (GC) footprint under heavy analytical loads.

---

## Core Engineering Highlights

*   **Memory Efficiency**: Reduces enterprise cloud infrastructure overhead by transforming heavy 32-bit `float` representations into dense 8-bit `byte` layouts.
*   **Zero-Allocation Compute**: Eliminates GC pauses during high-frequency queries by avoiding runtime wrapper object generation inside core math operations.
*   **Modern Concurrency Design**: Replaces legacy, heavy thread pooling with lightweight virtual threads to handle data-intensive segment scans without locking contentions.
*   **Enterprise Tooling Integration**: Organized with strict package-private domain separation and built using a robust, maintainable Gradle Kotlin DSL configuration.

---

## Execution & Performance Diagnostics

The application can be compiled and profiled locally using the native Gradle build automation wrapper.

### 1. Run Compilation & Execution Tasks
```bash
# Windows
.\gradlew.bat run

# Mac / Linux
./gradlew run
```

### 2. Standard Profiling Output
```text
=== Launching Original Segmented Vector Search Engine ===
Generating data clusters...
Executing concurrent segmented similarity search scan...
Search execution finalized in: 0.842 milliseconds

Top 3 Closest Match Results Identified:
 -> Vector Record ID: 1042 | Cosine Similarity Score: 0.9984
 -> Vector Record ID: 3912 | Cosine Similarity Score: 0.9851
 -> Vector Record ID: 2205 | Cosine Similarity Score: 0.9712
```