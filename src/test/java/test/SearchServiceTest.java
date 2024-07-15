package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import program.SearchService;
import program.Valute;
import program.ValuteLoader;

import java.io.IOException;
import java.util.List;

public class SearchServiceTest {

    private SearchService searchService = new SearchService();
    List<Valute> loadedValutes;
    @Before
    public void loadValute() throws IOException {
        ValuteLoader loader = new ValuteLoader();
        loadedValutes = loader.loadValute("src/test/resources/currency_test.csv");
    }

    @Test
    public void testSearchByCurrencyCode(){
        String searchedValue = "USD";
        List<Valute> findedValutes = searchService.searchValute(loadedValutes, searchedValue, Valute.Column.CURRENCY_CODE);
        Assert.assertNotNull(findedValutes);
        long expectedCodes = loadedValutes
                .stream()
                .filter(v -> v.getCurrencyCode().equals("USD"))
                .count();
        Assert.assertEquals(expectedCodes, findedValutes.size());
        for (Valute valute : findedValutes) {
            Assert.assertEquals(searchedValue, valute.getCurrencyCode());
        }

    }

    @Test
    public void testSearchByCurrencyName(){
        String searchedValue = "Армянских драмов";
        List<Valute> findedValutes = searchService.searchValute(loadedValutes, searchedValue, Valute.Column.CURRENCY_NAME);
        Assert.assertNotNull(findedValutes);
        long expectedNames = loadedValutes
                .stream()
                .filter(v -> v.getCurrencyName().equals("Армянских драмов"))
                .count();
        Assert.assertEquals(expectedNames, findedValutes.size());
        for (Valute valute : findedValutes) {
            Assert.assertEquals(searchedValue, valute.getCurrencyName());
        }

    }
    @Test
    public void testSearchHowManyValutes(){
        int expectedNumberOfValutes = 34;
        int findedNumberOfValutes = searchService.countValutes(loadedValutes);
        Assert.assertEquals(expectedNumberOfValutes,findedNumberOfValutes);
    }
    @Test
    public void testSearchFiveMostExpensiveValutes(){
        List<Valute> findedValutes = searchService.searchFiveMostExpensiveValutes(loadedValutes);
        Assert.assertNotNull(findedValutes);
        Assert.assertNotSame(findedValutes,loadedValutes);
        Assert.assertEquals(5,findedValutes.size());
        for (int i = 0; i < findedValutes.size(); i++) {
            Assert.assertTrue(findedValutes.get(i).getValue()/findedValutes.get(i).getNominal() <= findedValutes.get(i).getValue()/findedValutes.get(i).getNominal());
        }
    }
    @Test
    public void testSearchFiveMostCheapestValutes(){
        List<Valute> findedValutes = searchService.searchFiveMostCheapestValutes(loadedValutes);
        Assert.assertNotNull(findedValutes);
        Assert.assertNotSame(findedValutes,loadedValutes);
        Assert.assertEquals(5,findedValutes.size());
        for (int i = 0; i < findedValutes.size(); i++) {
            Assert.assertTrue(findedValutes.get(i).getValue()/findedValutes.get(i).getNominal() >= findedValutes.get(i).getValue()/findedValutes.get(i).getNominal());
        }
    }

}
