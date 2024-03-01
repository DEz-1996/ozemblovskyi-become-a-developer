package org.example.service;

import java.util.List;

public interface CustomFileReader {
    List<Integer> readNumbersFromBz2(String filePath);
}
