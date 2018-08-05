package ru.kochin.models.context;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
public class GroupingTestDataContext {

    private String operationsFileName;
    private String sumsByDateFileName;
    private String sumsByOfficesFileName;

    Map<LocalDate, BigDecimal> sumsByDateData;
    Map<String, BigDecimal> sumsByOfficesData;
}
