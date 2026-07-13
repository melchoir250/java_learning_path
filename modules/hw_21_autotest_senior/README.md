# Модуль 21: API автотесты (Senior)

Автотесты для итерации 2 банковского API.  
Тест-кейсы: [hw_18 → iteration2.http](../hw_18_api_test_case_design/requests/iteration2.http).

**API:** `http://localhost:4111`  
**Стек:** Java 25, JUnit 5, Maven, RestAssured, AssertJ, RgxGen

---

## Запуск

```bash
# поднять бэкенд на localhost:4111, потом:
cd modules/hw_21_autotest_senior
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


| Файл                         | Эндпоинт                         | Тестов |
| ---------------------------- | -------------------------------- | ------ |
| `DepositAccountTest.java`    | `POST /api/v1/accounts/deposit`  | 10     |
| `TransferMoneyTest.java`     | `POST /api/v1/accounts/transfer` | 7      |
| `UpdateProfileNameTest.java` | `PUT /api/v1/customer/profile`   | 7      |


---



## Архитектура (senior)

Тест = сценарий. HTTP и проверки состояния — в steps / specs / ModelAssertions.

```
tests/          → сценарий (кто → что → ожидаемое состояние)
requests/steps/ → AdminSteps, UserSteps (создание юзера, депозит, transfer, GET)
requests/skelethon/
  Endpoint      → url + request/response model
  CrudRequester / ValidatedCrudRequester → HTTP + статус/тело через ResponseSpecs
models/         → request/response DTO
models/comparison/ → ModelAssertions + model-comparison.properties
specs/          → RequestSpecs / ResponseSpecs
generators/     → RandomModelGenerator (RgxGen)
configs/        → config.properties (server, apiVersion)
```

Типичный happy-path:

```
AdminSteps.createUser
  → UserSteps.authAs / createAccount / deposit|transfer|updateProfile
  → ModelAssertions (request ↔ response) и/или ResponseSpecs (message, status)
  → UserSteps.assertAccountBalance | assertProfile   // состояние через GET
```

Авторизация — **Basic Auth** (токен после login в `RequestSpecs.authAsUser`).

`BaseTest` держит SoftAssertions (паттерн курса); в senior-тестах проверки в основном вне `softly`.