package test;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import program.SortService;
import program.Valute;
import program.ValuteLoader;
import org.junit.Assert;
import org.junit.Test;

public class SortServiceTest {

    private SortService sortService = new SortService();
    List<Valute> valuteList;
    @Before
    public void loadValute() throws IOException {
        ValuteLoader loader = new ValuteLoader();
        valuteList = loader.loadValute("src/test/resources/currency_test.csv");
    }

    @Test
    public void testSortServiceValuteByValueAscending() {
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.VALUE, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getValue() <= sortedValuteList.get(i + 1).getValue());
        }
    }

    @Test
    public void testSortServiceValuteByValueDescending() {
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.VALUE, false);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getValue() >= sortedValuteList.get(i + 1).getValue());
        }
    }

    @Test
    public void testSortServiceValuteByCodeAscending() {
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.CURRENCY_CODE, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getCurrencyCode()
                    .compareTo(sortedValuteList.get(i + 1).getCurrencyCode()) <= 0);
        }
    }

    @Test
    public void testSortServiceValuteByDateAscending() {
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.DATE, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getDate().getTime() <= sortedValuteList.get(i + 1).getDate().getTime());
        }
    }
    @Test
    public void testSortServiceValuteByNominalAscending(){
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.NOMINAL, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size()-1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getNominal() <= sortedValuteList.get(i+1).getNominal());
        }
    }
    @Test
    public void testSortServiceValuteByNameAscending(){
        List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Column.CURRENCY_NAME, true);
        Assert.assertNotNull(sortedValuteList);
        Assert.assertEquals(valuteList.size(), sortedValuteList.size());
        Assert.assertNotSame(valuteList, sortedValuteList);
        for (int i = 0; i < sortedValuteList.size() - 1; i++) {
            Assert.assertTrue(sortedValuteList.get(i).getCurrencyName()
                    .compareTo(sortedValuteList.get(i + 1).getCurrencyName()) <= 0);
        }
    }
}
