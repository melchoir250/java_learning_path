package chapter_06_oop_principles.currency_converter;

import java.util.HashMap;
import java.util.Map;

public class FixedRateConverter implements CurrencyConverter {
    private final Map<String, Double> rates = new HashMap<>();

    public FixedRateConverter() {
        rates.put("USD_RUB", 90.0);
        rates.put("EUR_RUB", 100.0);
        rates.put("AED_RUB", 110.0);
    }

    @Override
    public double convert(double amount, String from, String to) {
        String key = from + "_" + to;
        Double rate = rates.get(key);
        if (rate == null) {
            throw new IllegalArgumentException("Нет такой пары в БД");
        }
        return amount * rate;
    }
}