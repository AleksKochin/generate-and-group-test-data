package ru.kochin.io.read;

import lombok.extern.slf4j.Slf4j;
import ru.kochin.models.context.GroupingTestDataContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Slf4j
public class GeneratedTestDataReaderImpl implements GeneratedTestDataReader {

    @Override
    public void read(GroupingTestDataContext context) {

        context.setSumsByDateData(new HashMap<>());
        context.setSumsByOfficesData(new HashMap<>());

        try (FileInputStream fileInputStream = new FileInputStream(context.getOperationsFileName());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {

            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (!currentLine.isEmpty()) {

                    String[] split = currentLine.split(";");

                    fillSumsByDateData(context, split[0], split[2]);
                    fillSumsByOfficiesData(context, split[1], split[2]);
                }
            }

        } catch (IOException ex) {
            log.error(ex.getMessage(), ex.getCause());
        }
    }

    private void fillSumsByOfficiesData(GroupingTestDataContext context, String stringOffice, String stringSumValue) {

        BigDecimal storedSum = context.getSumsByOfficesData().get(stringOffice);

        if (storedSum == null) {
            context.getSumsByOfficesData().put(stringOffice, new BigDecimal(stringSumValue));
        } else {
            context.getSumsByOfficesData().put(stringOffice, storedSum.add(new BigDecimal(stringSumValue)));
        }
    }

    private void fillSumsByDateData(GroupingTestDataContext context, String stringDateValue, String stringSumValue) {

        LocalDateTime date = LocalDateTime.parse(stringDateValue, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        BigDecimal currentSum = new BigDecimal(stringSumValue);
        BigDecimal storedSum = context.getSumsByDateData().get(date.toLocalDate());

        if (storedSum == null) {
            context.getSumsByDateData().put(date.toLocalDate(), currentSum);
        } else {
            context.getSumsByDateData().put(date.toLocalDate(), currentSum.add(storedSum));
        }
    }
}
