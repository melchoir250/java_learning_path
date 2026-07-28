# Модуль 20: API автотесты (Middle)

Автотесты для итерации 2 банковского API.  
Тест-кейсы спроектированы в [hw_18 → iteration2.http](../hw_18_api_test_case_design/requests/iteration2.http).

**API:** `http://localhost:4111`  
**Стек:** Java 25, JUnit 5, Maven, RestAssured

---

## Запуск

```bash
# поднять бэкенд на localhost:4111, потом:
cd modules/hw_20_autotest_middle
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
