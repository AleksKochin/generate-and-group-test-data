package ru.kochin.models.context;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneratingTestDataContext {
    private String pointsToSaleFile;
    private int countOfOperpation;
    private String fileToGenerateData;
}
