package chapter_03_static_final;
import java.time.LocalDateTime;

// Создай объект, который при создании получает текущую дату и время.
// Это значение сохраняется и не должно меняться в дальнейшем.
// Пояснение: реализуй финальное поле и задай его в момент создания.

public class CreatedAt {
    private final LocalDateTime time;

    public CreatedAt(String someTime) {
        this.time = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public static void main(String[] args) {
        CreatedAt createdAt = new CreatedAt("Time now");
        System.out.println(createdAt.getTime());
    }
}
