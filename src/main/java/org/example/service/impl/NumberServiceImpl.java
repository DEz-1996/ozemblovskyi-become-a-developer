package org.example.service.impl;

import org.example.service.NumberService;

import java.util.ArrayList;
import java.util.List;

public class NumberServiceImpl implements NumberService {
    @Override
    public Integer max(List<Integer> integers) {
        return integers.stream()
                .mapToInt(n -> n)
                .max()
                .getAsInt();
    }

    @Override
    public Integer min(List<Integer> integers) {
        return integers.stream()
                .mapToInt(n -> n)
                .min()
                .getAsInt();
    }

    @Override
    public double median(List<Integer> integers) {
        List<Integer> sortedList = integers.stream()
                .sorted()
                .toList();
        int size = sortedList.size();
        return (size % 2 == 0)
                ? 0.5 * (sortedList.get(size / 2) + sortedList.get(size / 2 - 1))
                : sortedList.get(size / 2);
    }

    @Override
    public double average(List<Integer> integers) {
        return integers.stream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
    }

    @Override
    public List<Integer> largestIncreasedSequence(List<Integer> integers) {
        List<Integer> largestSequence = new ArrayList<>();
        List<Integer> currentSequence = new ArrayList<>();

        for (int i = 1; i < integers.size(); i++) {
            int curNum = integers.get(i);
            int prevNum = integers.get(i - 1);
            if (curNum > prevNum) {
                if (currentSequence.isEmpty()) {
                    currentSequence.add(prevNum);
                }
                currentSequence.add(curNum);
            } else {
                if (currentSequence.size() > largestSequence.size()) {
                    largestSequence.clear();
                    largestSequence.addAll(currentSequence);
                }
                currentSequence.clear();
            }
        }

        return largestSequence;
    }

    @Override
    public List<Integer> largestDecreasedSequence(List<Integer> integers) {
        List<Integer> largestSequence = new ArrayList<>();
        List<Integer> currentSequence = new ArrayList<>();

        for (int i = 1; i < integers.size(); i++) {
            int curNum = integers.get(i);
            int prevNum = integers.get(i - 1);
            if (curNum < prevNum) {
                if (currentSequence.isEmpty()) {
                    currentSequence.add(prevNum);
                }
                currentSequence.add(curNum);
            } else {
                if (currentSequence.size() > largestSequence.size()) {
                    largestSequence.clear();
                    largestSequence.addAll(currentSequence);
                }
                currentSequence.clear();
            }
        }

        return largestSequence;
    }
}
