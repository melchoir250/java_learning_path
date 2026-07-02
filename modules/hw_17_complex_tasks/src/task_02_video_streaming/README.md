# Задача 2: Библиотека для стримингового сервиса видео

## Описание

Создать библиотеку, которая обеспечивает функции загрузки и просмотра видео в форматах: AVI, MOV, WMV.
Система должна поддерживать загрузку видео в различных форматах и конвертировать их в единый внутренний формат MP4 для упрощения стриминга.

## Паттерны проектирования

| Паттерн | Назначение |
|---------|------------|
| **Adapter** | Преобразование загружаемых форматов (AVI, MOV, WMV) во внутренний формат MP4 |
| **Facade** | Упрощённый интерфейс к операциям загрузки, конвертации и стриминга |

## Архитектура библиотеки

| Компонент | Описание |
|-----------|----------|
| `VideoService` | Facade: методы `uploadVideo` и `streamVideo`, скрывающие детали конвертации |
| `VideoAdapter` | Интерфейс адаптера для конвертации видео в MP4 |
| `AviVideoAdapter` | Адаптер для формата AVI |
| `MovVideoAdapter` | Адаптер для формата MOV |
| `WmvVideoAdapter` | Адаптер для формата WMV |
| `Video` | Модель загруженного видео (id, путь, формат) |
| `Stream` | Модель стрима MP4-видео |

## Требования

1. **`VideoAdapter`**: интерфейс с методом конвертации в MP4, например `String convertToMp4(String filePath)`
2. **Адаптеры форматов**: `AviVideoAdapter`, `MovVideoAdapter`, `WmvVideoAdapter`
3. **`VideoService`**: принимает адаптеры в конструкторе, определяет формат по расширению файла
4. **`uploadVideo(String videoPath)`**: конвертирует видео в MP4 и возвращает объект `Video`
5. **`streamVideo(String videoId)`**: возвращает объект `Stream` для воспроизведения MP4

## Пример использования

```java
// Инициализация сервиса с адаптерами для поддерживаемых форматов
VideoService videoService = new VideoService(
        new AviVideoAdapter(),
        new MovVideoAdapter(),
        new WmvVideoAdapter()
);

// Загрузка видео файла в формате AVI
String videoPath = "path/to/example.avi";
Video video = videoService.uploadVideo(videoPath);

// Стриминг видео в формате MP4
Stream stream = videoService.streamVideo(video.getId());

// Вывод информации о стриме
System.out.println("Streaming video in MP4 format, Video ID: " + video.getId());
```
