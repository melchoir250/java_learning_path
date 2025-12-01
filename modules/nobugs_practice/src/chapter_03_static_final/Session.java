package chapter_03_static_final;

// Создай класс Session, в котором при создании объекта счётчик активных сессий
//увеличивается, а при вызове метода close() — уменьшается.
//Количество активных сессий должно быть доступно через отдельный метод.
//Пояснение: используешь общее поле для отслеживания состояний всех экземпляров.

public class Session {
    static int active;
    String session;

    Session(String someSession) {
        this.session = someSession;
        active++;
    }

    public String getSession() {
        return this.session;
    }

    public void close() {
        active--;
    }

    public void print() {
        System.out.println("Session: " + getSession() + ", Session active: " + active);
    }

    public static void main(String[] args) {
        Session session_petr = new Session("Petr active session");
        session_petr.print();
        session_petr.close();
        session_petr.print();
    }
}
