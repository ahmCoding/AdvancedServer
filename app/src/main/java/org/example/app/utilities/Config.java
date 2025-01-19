package org.example.app.utilities;

public class Config {
    public static final String DATASET_PATH = "data/WDICSV.csv";
    public static final int SERIAL_PORT = 2223;
    public static final int PARALLEL_PORT = 2244;
    public static final int RMI_PORT = 1100;

    public static final int SERVER_SLEEP_TIME = 1_000;
    public static long getMaxTimeForExecutorTermination = 10;

}
