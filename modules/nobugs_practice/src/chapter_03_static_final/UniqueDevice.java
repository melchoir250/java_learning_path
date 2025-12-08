package chapter_03_static_final;

//28. Уникальное имя устройства
//Каждое создаваемое устройство должно автоматически получать имя по шаблону:
//"Device_1"
//"Device_2"
//Имя не должно изменяться после создания.
//Пояснение: используй счётчик на уровне класса и финальное поле на уровне объекта.

public class UniqueDevice {
    private final String device;
    private static int count = 0;

    public UniqueDevice() {
        count++;
        this.device = "Device_" + count;
    }

    public String getDevice() {
        return this.device;
    }
}
