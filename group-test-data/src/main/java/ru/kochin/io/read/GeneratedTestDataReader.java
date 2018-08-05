package ru.kochin.io.read;

import ru.kochin.models.context.GroupingTestDataContext;

@FunctionalInterface
public interface GeneratedTestDataReader {

    void read(GroupingTestDataContext context);
}
