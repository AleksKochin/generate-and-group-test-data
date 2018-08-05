package ru.kochin.main;

import ru.kochin.adapters.CommandLineArgsAdapterImpl;
import ru.kochin.io.read.GeneratedTestDataReaderImpl;
import ru.kochin.io.write.SumsByDatesWriter;
import ru.kochin.io.write.SumsByOfficesWriter;
import ru.kochin.models.context.GroupingTestDataContext;
import ru.kochin.adapters.CommandLineArgsAdapter;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        CommandLineArgsAdapter<GroupingTestDataContext> commandLineArgsAdapter = new CommandLineArgsAdapterImpl();
        GeneratedTestDataReaderImpl generatedTestDataReader = new GeneratedTestDataReaderImpl();
        SumsByDatesWriter sumsByDatesWriter = new SumsByDatesWriter();
        SumsByOfficesWriter sumsByOfficesWriter = new SumsByOfficesWriter();

        GroupingTestDataContext context = commandLineArgsAdapter.prepareContext(args);
        generatedTestDataReader.read(context);
        sumsByDatesWriter.write(context);
        sumsByOfficesWriter.write(context);
    }
}
