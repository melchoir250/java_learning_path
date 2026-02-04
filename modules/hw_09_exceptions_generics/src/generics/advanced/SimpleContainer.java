package generics.advanced;

public class SimpleContainer<T> implements Container<T> {

    private T element;

    @Override
    public void add(T item) {
        this.element = item;
    }

    @Override
    public T get() {
        return element;
    }
}
