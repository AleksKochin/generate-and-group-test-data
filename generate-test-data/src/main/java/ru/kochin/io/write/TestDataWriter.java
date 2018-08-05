package ru.kochin.io.write;

import ru.kochin.models.context.GeneratingTestDataContext;

import java.util.List;

@FunctionalInterface
public interface TestDataWriter {

    void write(GeneratingTestDataContext context, List<String> pointsToSaleSet);
}
