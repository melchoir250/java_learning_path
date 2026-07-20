# Модуль 19: API автотесты

Автотесты для итерации 2 банковского API.  
Тест-кейсы спроектированы в [hw_18 → iteration2.http](../hw_18_api_test_case_design/requests/iteration2.http).

**API:** `http://localhost:4111`  
**Стек:** Java 25, JUnit 5, Maven, RestAssured

---

## Запуск

```bash
# поднять бэкенд на localhost:4111, потом:
cd modules/hw_19_autotest_junior
mvn test
```

Один класс:

```bash
mvn test -Dtest=DepositAccountTest
mvn test -Dtest=TransferMoneyTest
mvn test -Dtest=UpdateProfileNameTest
```

---

## Тестовые классы

| Файл | Эндпоинт | Тестов |
|------|----------|--------|
| `DepositAccountTest.java` | `POST /api/v1/accounts/deposit` | 10 |
| `TransferMoneyTest.java` | `POST /api/v1/accounts/transfer` | 7 |
| `UpdateProfileNameTest.java` | `PUT /api/v1/customer/profile` | 8 |

Черновики (не основная сдача): `DepositAccountTest1.java`, `DepositAccountTest11.java`.

---

## Как устроены тесты

Каждый тест сам готовит данные:

```
createUser → login → (createAccount / deposit) → действие → проверка
```

Общие хелперы в классах:
- `createUser` — создание пользователя через admin
- `login` — возвращает `Authorization` токен
- `createAccount` — возвращает `id` счёта
- `getProfile` / `checkBalance` — проверки после действия

Авторизация — **Basic Auth** (токен из заголовка `Authorization` после логина).

---

## Важные моменты по API

### Депозит

| Кейс | Статус | Тело ошибки |
|------|--------|-------------|
| отрицательная / нулевая сумма | 400 | `Deposit amount must be at least 0.01` |
| сумма > 5000 | 400 | `Deposit amount cannot exceed 5000` |
| несуществующий `id` счёта | **403** | `Unauthorized access to account` |
| без авторизации | **401** | пустое тело |

Для «несуществующий id» счёт **не создаём**, шлём `id: 100`, сумма валидная (например `100`).

### Перевод

Тело запроса — **не как у депозита**:

```json
{
  "senderAccountId": 1,
  "receiverAccountId": 2,
  "amount": 50
}
```

Нужны **два пользователя**, у отправителя — депозит.  
Ответ transfer: `message`, `senderAccountId`, `receiverAccountId`, `amount` (не `transactions`).  
На transfer обязателен `Content-Type: application/json`.

### Профиль (имя)

Правила API (реальные, не всегда совпадают с `.http`):

- **ровно 2 слова** (один пробел)
- **только буквы** (латиница) — без цифр, дефисов, спецсимволов
- `username` (логин) и `name` (имя) — **разные поля**
- у нового пользователя `name = null`

Ответ PUT:

```json
{
  "message": "Profile updated successfully",
  "customer": { "name": "Ivan Petrov", ... }
}
```

Проверка имени: `customer.name` в PUT, потом `GET /customer/profile` → поле `name`.

Имя на 200 символов (рабочий вариант):

```java
"A".repeat(100) + " " + "B".repeat(99)  // 200 символов, 2 слова
```

---

## Расхождения: дока vs API

| Что в `.http` / README | Что на самом деле |
|------------------------|-------------------|
| Строка на 200 символов с дефисами (`Zephyrinus-Xanthippe...`) | **400** — 7 слов + дефисы, не проходит валидацию |
| Имя > 200 символов → ошибка | API **принимает** длинные имена (206, 500+ символов → 200) |
| `"A".repeat(200)` как макс. длина | **400** — одно слово, нужно 2 |

Тест `profile_shouldFail_forNameAboveMaximumLength` написан **по ТЗ** (ожидает 400), но API сейчас отвечает 200 — это баг/особенность бэкенда, не ошибка теста.

---

## Частые ошибки при написании

1. **`.body(username, ...)`** — нужно `.body("username", ...)` (имя поля в кавычках)
2. **Путать deposit и transfer** — разные поля в JSON
3. **Забыть `Content-Type: application/json`** на POST/PUT с телом → 415
4. **Пароль с `*`** — API не принимает, используй `!`
5. **`createAccount` должен возвращать `int`**, не `void`
6. **`getProfile(userAuth, username, name)`** — логин не меняется, меняется только `name`

---

## Пароль пользователя

Формат, который проходит валидацию:

```
{username}IVAN!
```

Минимум: цифра, upper, lower, спецсимвол (`!`), ≥ 8 символов. `*` не работает.

---

## Связь с hw_18

| Модуль | Что делает |
|--------|------------|
| hw_18 | ручные кейсы в `.http` |
| hw_19 | те же кейсы в Java-автотестах |
