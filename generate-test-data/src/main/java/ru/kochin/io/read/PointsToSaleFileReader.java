package ru.kochin.io.read;

import ru.kochin.exceptions.PointsToSaleReadingException;

import java.util.List;

@FunctionalInterface
public interface PointsToSaleFileReader {

    List<String> read(String path) throws PointsToSaleReadingException;
}
