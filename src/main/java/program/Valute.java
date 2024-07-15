package program;

import java.util.Date;
import java.util.Locale;

public class Valute {
    public enum Column {
        ID,
        VALUE,
        NOMINAL,
        CURRENCY_NAME,
        CURRENCY_CODE,
        DATE
    }
    private String id;
    private double value;
    private int nominal;
    private String currencyCode;
    private String currencyName;
    private Date date;

    public Valute() {
    }

    public Valute(String id, double value, int nominal, String currencyName, String currencyCode, Date date) {
        this.id = id;
        this.value = value;
        this.nominal = nominal;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s %s Рублей = %s %s (%s)",
                id!=null && !id.isEmpty() ? id : "NULL",
                value != 0 ? String.format(Locale.ENGLISH,"%.2f",value) : "NULL",
                nominal != 0 ? Integer.toString(nominal) : "NULL",
                currencyName!= null && !currencyName.isEmpty() ? currencyName : "NULL",
                currencyCode!= null && !currencyCode.isEmpty() ? currencyCode : "NULL");
    }
}
