package chapter_03_static_final;

//Создай класс UserAccount, где логин задаётся один раз при создании объекта и
//далее не меняется.
//Остальные поля, например имя или email, можно редактировать.
//Пояснение: ограничь возможность изменения логина после инициализации, но оставь
//доступ к другим данным.

public class UserAccount {
    private final String login;
    String name;
    String email;

    UserAccount(String someName, String someEmail, String someLogin) {
        this.name = someName;
        this.email = someEmail;
        this.login = someLogin;
    }

    String getLogin() {
        return this.login;
    }
}
