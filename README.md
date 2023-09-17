# Grover's Algorithm Implementation and Visualization

![Grover's Algorithm](Grover_Algorithm.png)

This repository contains Java code for implementing Grover's algorithm, a quantum algorithm designed to solve unstructured search problems more efficiently than classical algorithms. It includes both sequential and parallel versions of the algorithm, as well as basic text-based visualization of the quantum state during each iteration.

## Table of Contents

- [Introduction](#introduction)
- [Implementation Details](#implementation-details)
- [Performance Comparison](#performance-comparison)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Grover's algorithm is a quantum algorithm that offers a quadratic speedup for unstructured search problems compared to classical algorithms. It works by amplifying the amplitude of the marked item in a quantum superposition and subsequently measuring the result.

This repository provides a Java implementation of Grover's algorithm, both in a sequential and a parallel version. It also includes basic text-based visualization to observe the evolution of the quantum state during each iteration.

## Implementation Details

- The `GroverState` class manages the quantum state and operations on it.
- The `runSequentialGrover` and `runParallelGrover` methods execute the sequential and parallel versions of the algorithm.
- Visualization of the quantum state is provided after each iteration.

## Performance Comparison

The performance of the sequential and parallel versions of Grover's algorithm can be compared for different problem sizes (N). Execution times and efficiency improvements due to parallelization should be analyzed.

## Getting Started

To run and experiment with the Grover's algorithm implementations, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/m12shehab/grover-algorithm.git
