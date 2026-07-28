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

| Файл | Эндпоинт | Тестов |
|------|----------|--------|
| `DepositAccountTest.java` | `POST /api/v1/accounts/deposit` | 9 |
| `TransferMoneyTest.java` | `POST /api/v1/accounts/transfer` | 8 |
| `UpdateProfileNameTest.java` | `PUT /api/v1/customer/profile` | 7 |

---

## Архитектура (senior)

Тест = сценарий. HTTP и проверки — в steps / specs / ModelAssertions.

```
tests/            → сценарий
requests/steps/
  CustomerContext → create → auth → account/deposit (переиспользуемый setup)
  AdminSteps / UserSteps → атомарные HTTP-шаги + GET-assert'ы
requests/skelethon/
  Endpoint / CrudRequester / ValidatedCrudRequester
models/ + models/comparison/
specs/            → RequestSpecs / ResponseSpecs
generators/       → RandomModelGenerator, RandomData
configs/          → config.properties + PROPERTY
```

Типичный happy-path:

```
CustomerContext.create().withAccount().withDeposit(amount)
  → action (deposit / transfer / updateProfile)
  → ModelAssertions / ResponseSpecs
  → customer.assertBalance(...) | assertProfileName(...)
```

Авторизация — **Basic Auth** (токен после login в `RequestSpecs.authAsUser`).

`BaseTest` держит SoftAssertions (паттерн курса); в senior-тестах проверки в основном вне `softly`.
