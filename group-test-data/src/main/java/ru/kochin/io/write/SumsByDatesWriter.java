package ru.kochin.io.write;

import lombok.extern.slf4j.Slf4j;
import ru.kochin.models.context.GroupingTestDataContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class SumsByDatesWriter implements GeneratedDataWriter {

    @Override
    public void write(GroupingTestDataContext context) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(context.getSumsByDateFileName())) {
            StringBuilder stringBuilder = new StringBuilder();

            context.getSumsByDateData().entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        stringBuilder.append(entry.getKey());
                        stringBuilder.append(";");
                        stringBuilder.append(entry.getValue());
                        stringBuilder.append(System.getProperty("line.separator"));
                    });

            fileOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex.getCause());
        }
    }
}
