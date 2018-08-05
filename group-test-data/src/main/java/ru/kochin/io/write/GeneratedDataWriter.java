package ru.kochin.io.write;

import ru.kochin.models.context.GroupingTestDataContext;

@FunctionalInterface
public interface GeneratedDataWriter {

    void write(GroupingTestDataContext context);
}
