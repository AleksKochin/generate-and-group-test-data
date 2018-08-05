package ru.kochin.io.read;

import lombok.extern.slf4j.Slf4j;
import ru.kochin.exceptions.PointsToSaleReadingException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class PointsToSaleFileReaderImpl implements PointsToSaleFileReader {

    @Override
    public List<String> read(String path) throws PointsToSaleReadingException {

        List<String> points = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(path);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {

            String currentPoint;
            while ((currentPoint = bufferedReader.readLine()) != null) {
                points.add(currentPoint);
            }
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex.getCause());
            throw new PointsToSaleReadingException(ex.getMessage(), ex.getCause());
        }

        return points.stream()
                .filter(point -> point != null && point.length() > 0)
                .collect(Collectors.toList());
    }
}
