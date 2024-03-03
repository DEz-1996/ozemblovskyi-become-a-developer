package org.example;

import java.util.List;
import org.example.service.NumberService;
import org.example.service.impl.CustomFileReaderBz2;
import org.example.service.impl.NumberServiceImpl;

public class Main {
    private static final CustomFileReaderBz2 customFileReader = new CustomFileReaderBz2();
    private static final NumberService numberService = new NumberServiceImpl();
    private static final String FILE_NAME = "10m.txt.bz2";
    private static final String TOTAL_EXECUTION_TIME = "Total execution time is: %d seconds";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<Integer> integers = customFileReader.readNumbers(FILE_NAME);
        System.out.println("Max is: " + numberService.max(integers));
        System.out.println("Min is: " + numberService.min(integers));
        System.out.println("Median is: " + numberService.median(integers));
        System.out.println("Average is: " + numberService.average(integers));
        System.out.println("Largest increased sequence is: "
                + numberService.largestIncreasedSequence(integers));
        System.out.println("Largest decreased sequence is: "
                + numberService.largestDecreasedSequence(integers));

        long finishTime = System.currentTimeMillis();
        System.out.printf((TOTAL_EXECUTION_TIME), ((finishTime - startTime) / 1000));
    }
}
