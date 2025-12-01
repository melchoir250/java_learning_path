package chapter_03_static_final;

// У объекта должен быть строковый токен (например,
//"abcd1234"), который задаётся
//один раз в момент создания.
//Токен нельзя изменить после присвоения, но можно получить.
//Пояснение: реализуй неизменяемое поле с доступом только для чтения.

public class Token {
    static final String TOKEN = "1234-ABC-34";

    public static void main(String[] args) {
        System.out.println(TOKEN);
    }
}
