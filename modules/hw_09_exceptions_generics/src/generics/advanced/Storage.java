package generics.advanced;


import java.util.List;

public class Storage<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

}
