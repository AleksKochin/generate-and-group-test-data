package ru.kochin.adapters;

import ru.kochin.models.context.GroupingTestDataContext;
import ru.kochin.exceptions.IlegalCommandLineException;

public class CommandLineArgsAdapterImpl implements CommandLineArgsAdapter<GroupingTestDataContext> {

    @Override
    public GroupingTestDataContext prepareContext(String[] args) throws IlegalCommandLineException {

        validateCommandLineArgs(args);

        GroupingTestDataContext context = new GroupingTestDataContext();

        context.setOperationsFileName(args[0]);
        context.setSumsByDateFileName(args[1]);
        context.setSumsByOfficesFileName(args[2]);
        return context;
    }
}
