# Многопоточное программирование на Java

## Практикум по основам многопоточности (hw_11_multithreading)

Данный проект представляет собой сборник практических заданий для изучения многопоточного программирования в Java. Задания охватывают ключевые концепции: от создания простых потоков до продвинутых механизмов синхронизации.

## Структура проекта

```
hw_11_multithreading/
├── README.md                 # Общее описание проекта
└── src/
    └── hw_11_multithreading/
        ├── task_01_single_thread/        # Задача 1: Создание одного потока
        │   ├── README.md                 # Описание задачи 1
        │   └── Task01_SingleThread.java  # Решение задачи 1
        ├── task_02_two_threads/          # Задача 2: Создание двух потоков
        │   ├── README.md                 # Описание задачи 2
        │   └── Task02_TwoThreads.java    # Решение задачи 2
        ├── task_03_volatile/             # Задача 3: Использование volatile
        │   ├── README.md                  # Описание задачи 3
        │   └── Task03_VolatileStop.java   # Решение задачи 3
        ├── task_04_synchronized/          # Задача 4: Использование synchronized
        │   ├── README.md                   # Описание задачи 4
        │   └── Task04_SynchronizedCounter.java # Решение задачи 4
        ├── task_05_executor_service/      # Задача 5: ExecutorService (пул потоков)
        │   ├── README.md                   # Описание задачи 5
        │   └── Task05_ExecutorServicePool.java # Решение задачи 5
        ├── task_06_parallel_processing/   # Задача 6: Параллельная обработка данных
        │   ├── README.md                    # Описание задачи 6
        │   └── Task06_ParallelProcessing.java # Решение задачи 6
        └── task_07_reentrant_lock/        # Задача 7: ReentrantLock
            ├── README.md                    # Описание задачи 7
            └── Task07_ReentrantLock.java    # Решение задачи 7
```

## Список задач

### Базовый уровень

| Задача | Тема | Краткое описание |
|--------|------|------------------|
| [Задача 1](src/hw_11_multithreading/task_01_single_thread/README.md) | Создание потока | Один поток выводит сообщение 5 раз с паузой |
| [Задача 2](src/hw_11_multithreading/task_02_two_threads/README.md) | Несколько потоков | Два потока печатают символы "A" и "B" |
| [Задача 3](src/hw_11_multithreading/task_03_volatile/README.md) | volatile | Остановка потока через volatile-флаг |
| [Задача 4](src/hw_11_multithreading/task_04_synchronized/README.md) | synchronized | Синхронизация доступа к счетчику |

### Повышенный уровень

| Задача | Тема | Краткое описание |
|--------|------|------------------|
| [Задача 5](src/hw_11_multithreading/task_05_executor_service/README.md) | ExecutorService | Пул потоков для обработки задач |
| [Задача 6](src/hw_11_multithreading/task_06_parallel_processing/README.md) | Параллельная обработка | Разделение данных между потоками |
| [Задача 7](src/hw_11_multithreading/task_07_reentrant_lock/README.md) | ReentrantLock | Банковские переводы с блокировками |

## Цели практикума

После выполнения всех задач вы научитесь:

1. **Создавать и управлять потоками** — запуск, остановка, ожидание завершения
2. **Понимать проблемы многопоточности** — race condition, visibility problems
3. **Применять механизмы синхронизации** — synchronized, volatile, ReentrantLock
4. **Использовать высокоуровневые конструкции** — ExecutorService, пулы потоков
5. **Избегать типичных ошибок** — deadlock, starvation

## Как работать с проектом

1. **Изучите условие задачи** в соответствующем README.md
2. **Ознакомьтесь с реализацией** в Java-файле
3. **Запустите программу** и проанализируйте результат
4. **Экспериментируйте** — изменяйте параметры, добавляйте вывод отладочной информации
5. **Обращайте внимание** на неочевидное поведение многопоточных программ
