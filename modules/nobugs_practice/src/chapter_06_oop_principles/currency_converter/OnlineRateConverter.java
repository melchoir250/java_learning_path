package chapter_06_oop_principles.currency_converter;

import java.util.HashMap;
import java.util.Map;

public class OnlineRateConverter implements CurrencyConverter {
    private final Map<String, Double> rates = new HashMap<>();

    public OnlineRateConverter() {
        rates.put("BTC_RUB", 0.0001);
        rates.put("USDT_RUB", 101.5);
        rates.put("LTC_RUB", 230.0);
    }

    @Override
    public double convert(double amount, String from, String to) {
        String key = from + "_" + to;
        Double rate = rates.get(key);
        double commissionForConvert = 0.05;
        if (rate == null) {
            throw new IllegalArgumentException("Нет такой пары в БД");
        }
        return amount * rate * (1 - commissionForConvert);
    }
}