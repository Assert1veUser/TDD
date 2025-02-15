package program;

import java.util.Date;
import java.util.List;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class SortService {
    public List<Valute> sortByColumn(List<Valute> valuteList, Valute.Column columnName, boolean isAscending) {
        return valuteList
                .stream()
                .sorted((valute1, valute2) -> {
                    switch (columnName) {
                        case VALUE -> {
                            return sortDouble(valute1.getValue(), valute2.getValue(), isAscending);
                        }
                        case CURRENCY_CODE -> {
                            return sortString(valute1.getCurrencyCode(), valute2.getCurrencyCode(), isAscending);
                        }
                        case DATE -> {
                            return sortDate(valute1.getDate(), valute2.getDate(), isAscending);
                        }
                        case CURRENCY_NAME -> {
                            return sortString(valute1.getCurrencyName(), valute2.getCurrencyName(), isAscending);
                        }
                        case NOMINAL -> {
                            return sortInteger(valute1.getNominal(), valute2.getNominal(), isAscending);
                        }
                        default -> throw new IllegalArgumentException();
                    }
                })
                .toList();
    }

    private int sortDate(Date value1, Date value2, boolean isAscending) {
        return sortLong(value1.getTime(), value2.getTime(), isAscending);
    }

    private int sortLong(Long value1, Long value2, boolean isAscending) {
        if (isAscending) {
            return Long.compare(value1, value2);
        } else {
            return Long.compare(value2, value1);
        }
    }

    private int sortString(String value1, String value2, boolean isAscending) {
        if (isAscending) {
            return value1.compareTo(value2);
        } else {
            return value2.compareTo(value1);
        }
    }

    private int sortDouble(Double value1, Double value2, boolean isAscending) {
        if (isAscending) {
            return Double.compare(value1, value2);
        } else {
            return Double.compare(value2, value1);
        }
    }
    private int sortInteger(int nominal1, int nominal2, boolean isAscending){
        if(isAscending){
            return Integer.compare(nominal1, nominal2);
        } else {
            return Integer.compare(nominal2, nominal1);
        }
    }
}