package ru.kochin.adapters;

import ru.kochin.exceptions.IlegalCommandLineException;
import ru.kochin.models.context.GeneratingTestDataContext;

public class CommandLineArgsAdapterImpl implements CommandLineArgsAdapter<GeneratingTestDataContext> {

    @Override
    public GeneratingTestDataContext prepareContext(String[] args) throws IlegalCommandLineException {

        validateCommandLineArgs(args);

        GeneratingTestDataContext generatingTestDataContext = new GeneratingTestDataContext();

        generatingTestDataContext.setPointsToSaleFile(args[0]);

        prepareCountOfOperations(generatingTestDataContext, args[1]);

        generatingTestDataContext.setFileToGenerateData(args[2]);

        return generatingTestDataContext;
    }

    private void prepareCountOfOperations(GeneratingTestDataContext context, String stringCount) throws IlegalCommandLineException {
        try {
            context.setCountOfOperpation(Integer.parseInt(stringCount));
        } catch (NumberFormatException ex) {
            throw new IlegalCommandLineException("Incorrect count of operation");
        }
    }
}
