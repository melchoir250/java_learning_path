package chapter_06_oop_principles.currency_converter;

public class CurrencyService {
    private CurrencyConverter converter;

    public CurrencyService(CurrencyConverter converter) {
        this.converter = converter;
    }

    public void setConverter(CurrencyConverter converter) {
        this.converter = converter;
    }

    public double performConversion(double amount, String from, String to) {
        return converter.convert(amount, from, to);
    }
}