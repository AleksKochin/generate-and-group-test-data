package ru.kochin.io.write;

import lombok.extern.slf4j.Slf4j;
import ru.kochin.models.context.GroupingTestDataContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Slf4j
public class SumsByOfficesWriter implements GeneratedDataWriter {
    @Override
    public void write(GroupingTestDataContext context) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(context.getSumsByOfficesFileName())) {
            StringBuilder stringBuilder = new StringBuilder();

            context.getSumsByOfficesData().entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
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
