package program;

import java.util.Arrays;
import java.util.List;

public class SearchService {
    public List<Valute> searchValute(List<Valute> loadedValutes, String searchedValue, Valute.Column column) {

        return loadedValutes
                .stream()
                .filter(v -> {
                    switch (column){
                        case CURRENCY_CODE -> {
                            return v.getCurrencyCode().equals(searchedValue.toUpperCase());
                        }
                        case CURRENCY_NAME -> {
                            return v.getCurrencyName().equals(searchedValue);
                        }
                        default -> throw new IllegalArgumentException();
                    }
                })
                .toList();
    }

    public int countValutes(List<Valute> loadedValutes) {
        return loadedValutes.size();
    }
    public List<Valute> searchFiveMostExpensiveValutes(List<Valute> loadedValutes){
        return loadedValutes.stream().sorted((valute1,valute2) -> Double.compare(valute2.getValue() / valute2.getNominal(),valute1.getValue() / valute1.getNominal())).limit(5).toList();
    }
    public List<Valute> searchFiveMostCheapestValutes(List<Valute> loadedValutes){
        return loadedValutes.stream().sorted((valute2,valute1) -> Double.compare(valute2.getValue() / valute2.getNominal(),valute1.getValue() / valute1.getNominal())).limit(5).toList();
    }
}
