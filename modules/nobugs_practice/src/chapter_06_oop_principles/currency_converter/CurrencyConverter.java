package chapter_06_oop_principles.currency_converter;

public interface CurrencyConverter {
    double convert(double amount, String from, String to);
}