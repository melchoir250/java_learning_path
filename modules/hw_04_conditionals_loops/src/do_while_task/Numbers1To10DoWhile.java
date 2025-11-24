package do_while_task;

public class Numbers1To10DoWhile {
    public static void NumberDo() {
        int i = 1;

        do{
            System.out.println(i);
            i++;
        } while (i <= 10);
    }

    public static void main(String[] args) {
        NumberDo();
    }
}
