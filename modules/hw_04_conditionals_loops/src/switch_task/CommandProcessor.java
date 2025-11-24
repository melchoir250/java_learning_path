package switch_task;

public class CommandProcessor {
    public static String nextLine(ProccessorEnum processorenum) {
        String description = "";

        switch (processorenum) {
            case start -> description = "Система запущена";
            case stop -> description = "Система остановлена";
            case restart -> description = "Система перезагружена";
            case status -> description = "Статус системы";
        }
        return description;
    }

    public static void main(String[] args) {
        System.out.println(nextLine(ProccessorEnum.stop));
        System.out.println(nextLine(ProccessorEnum.status));
    }
}
