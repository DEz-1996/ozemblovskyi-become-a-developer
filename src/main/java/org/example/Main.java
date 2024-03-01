package org.example;

import java.util.List;
import org.example.service.impl.CustomFileReaderImpl;

public class Main {
    private static final CustomFileReaderImpl customFileReader = new CustomFileReaderImpl();
    private static final String FILE_NAME = "10m.txt.bz2";
    private static final String TOTAL_EXECUTION_TIME = "Total execution time is: %d seconds";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<Integer> integers = customFileReader.readNumbersFromBz2(FILE_NAME);
        System.out.println(integers);

        long finishTime = System.currentTimeMillis();
        System.out.printf((TOTAL_EXECUTION_TIME), ((finishTime - startTime) / 1000));
    }
}
