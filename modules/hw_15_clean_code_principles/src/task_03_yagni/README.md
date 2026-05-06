# Задача 3: Исправление нарушения YAGNI

## Описание проблемы

Исходный код нарушает принцип YAGNI (You Ain't Gonna Need It):

- Класс содержит поля, которые никогда не используются
- Социальный номер (socialSecurityNumber) объявлен, но нигде не применяется
- Другие поля (preferredLanguage, homeAddress, workAddress, rewardPoints, isPremiumMember) также могут быть не нужны для
  базовой функциональности
- Избыточные поля усложняют поддержку и тестирование кода

## Исходный код

```java
public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isPremiumMember;
    private int rewardPoints;
    private String preferredLanguage;
    private String homeAddress;
    private String workAddress;
    private String socialSecurityNumber; // Никогда не используется

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
```

## Задача

Удалите неиспользуемые поля и оставьте только необходимые данные.
