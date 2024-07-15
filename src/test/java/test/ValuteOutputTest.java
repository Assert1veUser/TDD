package test;

import org.junit.Assert;
import org.junit.Test;
import program.Valute;

import java.util.Date;

public class ValuteOutputTest {
    @Test
    public void testValuteToCliUi(){
        Valute valute = new Valute("1",100.00,1,"Zoloto","OOO",new Date());
        String expectedString = "1 100.00 Рублей = 1 Zoloto (OOO)";
        Assert.assertEquals(expectedString, valute.toString());
        valute = new Valute();
        expectedString = "NULL NULL Рублей = NULL NULL (NULL)";
        Assert.assertEquals(expectedString,valute.toString());
    }
}
