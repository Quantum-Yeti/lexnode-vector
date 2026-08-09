# LexNode Vector Engine

A high-performance, zero-dependency, in-memory vector database engineered from scratch using **Java 25 (LTS)**. This engine utilizes optimized 8-Bit Scalar Quantization (SQ8) to compress high-dimensional floating-point embeddings (e.g., 1536-dimension text vectors), reducing memory footprint by **~75%** while preserving structural spatial similarity during retrieval operations.

---

## Architectural Overview

The engine eliminates the overhead of external network dependencies and bloated third-party abstractions by executing low-level memory transformations and mathematical lookups natively within a multi-threaded execution pipeline.

