package chapter_03_static_final;

// 3. Страна с фиксированным кодом
//Создай класс Country, в котором указывается код страны (например,
//"RU" или
//"US").
//Этот код задаётся один раз при создании и не может быть изменён после.
//Он должен быть доступен извне только для чтения.
//Пояснение: реши, как ограничить доступ на изменение, но при этом позволить читать
//значение.

public class Country {
    private final String code_country;

    public Country(String someCodeCountry) {
        this.code_country = someCodeCountry;
    }

    public String getCode_country() {
        return code_country;
    }

    public static void main(String[] args) {
        Country country_ru = new Country("RU");
        System.out.println(country_ru.getCode_country());
    }
}
