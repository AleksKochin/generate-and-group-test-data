package ru.kochin.io.write;

import lombok.extern.slf4j.Slf4j;
import ru.kochin.models.context.GeneratingTestDataContext;
import ru.kochin.utils.GeneratedUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class TestDataWriterImpl implements TestDataWriter {

    private static final String ONE_LINE_DATA_DELIMETER = ";";

    @Override
    public void write(GeneratingTestDataContext context, List<String> pointsToSaleSet) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(context.getFileToGenerateData())) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < context.getCountOfOperpation(); i++) {
                stringBuilder.append(GeneratedUtils.generateLocalDateTime());
                stringBuilder.append(ONE_LINE_DATA_DELIMETER);
                stringBuilder.append(fetchRandomPointToSale(pointsToSaleSet));
                stringBuilder.append(ONE_LINE_DATA_DELIMETER);
                stringBuilder.append(GeneratedUtils.generateRandomSum());
                stringBuilder.append(System.getProperty("line.separator"));
            }
            fileOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex.getCause());
        }
    }

    private String fetchRandomPointToSale(List<String> pointsToSaleSet) {

        return pointsToSaleSet.get(
                GeneratedUtils.generateRandomInt(pointsToSaleSet.size() - 1, 0)
        );
    }
}
