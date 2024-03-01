package org.example.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.example.service.CustomFileReader;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final String CANT_READ_FILE = "Can't read file: ";

    @Override
    public List<Integer> readNumbersFromBz2(String fileName) {
        List<Integer> filesLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new CompressorStreamFactory().createCompressorInputStream(
                                new BufferedInputStream(new FileInputStream(fileName)))))) {
            filesLines = bufferedReader.lines().map(Integer::parseInt).toList();
        } catch (IOException | CompressorException e) {
            throw new RuntimeException(CANT_READ_FILE + fileName, e);
        }
        return filesLines;
    }
}
