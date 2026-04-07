package chapter_06_oop_principles.currency_converter;

public class Main {
    public static void main(String[] args) {
        CurrencyService service = new CurrencyService(new FixedRateConverter());
        System.out.println(service.performConversion(1000, "USD", "RUB"));

        service.setConverter(new OnlineRateConverter());
        System.out.println(service.performConversion(1999999, "BTC", "RUB"));
        System.out.println(service.performConversion(22222, "DOGE", "RUB"));
    }
}