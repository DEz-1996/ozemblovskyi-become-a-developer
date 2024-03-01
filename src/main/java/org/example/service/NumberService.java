package org.example.service;

import java.util.List;

public interface NumberService {
    Integer max(List<Integer> integers);

    Integer min(List<Integer> integers);

    double median(List<Integer> integers);

    double average(List<Integer> integers);

    List<Integer> largestIncreasedSequence(List<Integer> integers);

    List<Integer> largestDecreasedSequence(List<Integer> integers);
}
