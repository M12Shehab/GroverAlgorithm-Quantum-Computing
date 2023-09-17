import java.util.Random;

public class GroverAlgorithmWithVisualization {

    public static void main(String[] args) {
        int N = 256; // Increased search space size
        int GROVER_ITERATIONS = (int) Math.round(Math.sqrt(N) * 10); // Increased number of iterations
        int markedItem = new Random().nextInt(N);

        System.out.println("Searching for item: " + markedItem);

        GroverState stateSequential = new GroverState(N);
        GroverState stateParallel = new GroverState(N);

        // Run the sequential version and measure time
        long startTimeSequential = System.currentTimeMillis();
        runSequentialGrover(stateSequential, GROVER_ITERATIONS, markedItem);
        long endTimeSequential = System.currentTimeMillis();

        // Run the parallel version and measure time
        long startTimeParallel = System.currentTimeMillis();
        runParallelGrover(stateParallel, GROVER_ITERATIONS, markedItem);
        long endTimeParallel = System.currentTimeMillis();

        int resultSequential = stateSequential.measure();
        int resultParallel = stateParallel.measure();

        System.out.println("Found item in sequential version: " + resultSequential);
        System.out.println("Found item in parallel version: " + resultParallel);

        long elapsedTimeSequential = endTimeSequential - startTimeSequential;
        long elapsedTimeParallel = endTimeParallel - startTimeParallel;

        System.out.println("Sequential version execution time: " + elapsedTimeSequential + " milliseconds");
        System.out.println("Parallel version execution time: " + elapsedTimeParallel + " milliseconds");
    }

    private static void runSequentialGrover(GroverState state, int iterations, int markedItem) {
        for (int iteration = 0; iteration < iterations; iteration++) {
            applyOracle(state, markedItem);
            applyGroverDiffusion(state);
            visualizeState(state, iteration);
        }
    }

    private static void runParallelGrover(GroverState state, int iterations, int markedItem) {
        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];

        for (int i = 0; i < threads.length; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                for (int iteration = 0; iteration < iterations / threads.length; iteration++) {
                    applyOracle(state, markedItem);
                    applyGroverDiffusion(state);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void applyOracle(GroverState state, int markedItem) {
        state.applyOracle(markedItem);
    }

    private static void applyGroverDiffusion(GroverState state) {
        state.applyGroverDiffusion();
    }

    private static void visualizeState(GroverState state, int iteration) {
        System.out.println("Iteration " + (iteration + 1) + ":");
        System.out.println(state.toString());
    }
}

