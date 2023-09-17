class GroverState {
    private double[] state;

    GroverState(int N) {
        state = new double[N];
        for (int i = 0; i < N; i++) {
            state[i] = 1.0 / Math.sqrt(N);
        }
    }

    void applyOracle(int markedItem) {
        for (int i = 0; i < state.length; i++) {
            if (i == markedItem) {
                state[i] = -state[i];
            }
        }
    }

    void applyGroverDiffusion() {
        double average = 0;
        for (double value : state) {
            average += value;
        }
        average /= state.length;

        for (int i = 0; i < state.length; i++) {
            state[i] = 2 * average - state[i];
        }
    }

    int measure() {
        double maxAmplitude = 0;
        int result = -1;

        for (int i = 0; i < state.length; i++) {
            if (state[i] > maxAmplitude) {
                maxAmplitude = state[i];
                result = i;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < state.length; i++) {
            sb.append(String.format("%.2f", state[i]));
            if (i < state.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
