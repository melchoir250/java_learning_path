---

# Задача 4: NullPointerException при проверке палиндрома

## Описание
Программа должна проверять, является ли строка палиндромом, но при передаче `null` выбрасывает исключение. Ваша задача — с помощью отладчика найти причину ошибки и исправить код.

## Условие
```java
public class DebugTask4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
    }
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
```

## Ожидаемый результат
Программа должна корректно обрабатывать случай с `null` и возвращать `false` (или другое осмысленное значение), не выбрасывая исключение.

## Фактическое поведение
При запуске программа выбрасывает исключение:
```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "this" is null
    at java.base/java.lang.StringBuilder.<init>(StringBuilder.java:132)
    at DebugTask4.isPalindrome(DebugTask4.java:6)
    at DebugTask4.main(DebugTask4.java:3)
```

## Задание
1. Запустите программу в режиме отладки (Debug).
2. Установите точку останова (breakpoint) в начале метода `isPalindrome`.
3. Проанализируйте значение переменной `str`.
4. Проследите выполнение программы до момента возникновения исключения.
5. Найдите причину `NullPointerException`.
6. Исправьте код так, чтобы он корректно обрабатывал `null` и работал согласно ожиданию.
7. Запишите процесс отладки и исправления на видео.

## Подсказки для отладки
- Обратите внимание на значение параметра `str` при входе в метод.
- Проверьте, что происходит при попытке создать `StringBuilder` с `null`.
- Подумайте, как следует обрабатывать `null` в методе проверки палиндрома.