package ru.kochin.main;

import ru.kochin.adapters.CommandLineArgsAdapter;
import ru.kochin.adapters.CommandLineArgsAdapterImpl;
import ru.kochin.models.context.GeneratingTestDataContext;
import ru.kochin.io.read.PointsToSaleFileReader;
import ru.kochin.io.read.PointsToSaleFileReaderImpl;
import ru.kochin.io.write.TestDataWriter;
import ru.kochin.io.write.TestDataWriterImpl;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        CommandLineArgsAdapter<GeneratingTestDataContext> commandLineArgsAdapter = new CommandLineArgsAdapterImpl();
        PointsToSaleFileReader pointsToSaleFileReader = new PointsToSaleFileReaderImpl();
        TestDataWriter dataWriter = new TestDataWriterImpl();

        GeneratingTestDataContext context = commandLineArgsAdapter.prepareContext(args);
        List<String> pointsToSale = pointsToSaleFileReader.read(context.getPointsToSaleFile());
        dataWriter.write(context, pointsToSale);
    }
}
